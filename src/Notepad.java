import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Notepad {

	JFrame frame;
	static JTextArea textArea;
	private int findIndex = -1;
	private Color colors = new Color(0, 120, 215);
	private FindFrame f = new FindFrame(this);
	private FontF font = new FontF(this);
	private AskSave as = new AskSave(this);
	private AskSavaExit ase = new AskSavaExit(this);
	private ReplaceFrame rf = new ReplaceFrame(this);
	private Scanner scan;
	private File file = new File("Notepad.txt");
	private HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(colors);
	static boolean TF = false;

	// to paste text from Clipboard
	private String getFromClipboard() {

		Toolkit tk = Toolkit.getDefaultToolkit();
		Clipboard cp = tk.getSystemClipboard();
		DataFlavor df = DataFlavor.stringFlavor;

		if (cp.isDataFlavorAvailable(df)) {
			try {
				return (String) cp.getData(df);
			} catch (UnsupportedFlavorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}

	// to copy selected text
	private void copyToClipboard(String txt) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Clipboard cp = tk.getSystemClipboard();
		cp.setContents(new StringSelection(txt), null);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notepad Newwindow = new Notepad();
					Newwindow.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Notepad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

////////////////////////////////////////////////////////////////////////////////////

		frame = new JFrame();
		frame.setBounds(100, 100, 580, 388);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setTitle("Notepad");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("background.png"));
		/*
		 * frame.addWindowListener(new WindowAdapter() { public void
		 * windowClosing(WindowEvent e) { System.exit(0); } });
		 */

////////////////////////////////////////////////////////////////////////////////////

		textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		textArea.setFont(new Font(font.font1, Font.PLAIN, font.size1));
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				// case for keypress action
				case KeyEvent.VK_S:
					if (e.isControlDown()) {
						try {
							FileWriter fw = new FileWriter(file);
							fw.write(textArea.getText());
							fw.close();
							frame.setTitle("Notepad");

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					}
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_N:
					if (e.isControlDown()) {
						if (textArea.getText().equals("")) {
						} else {
							frame.setEnabled(false);
							as.setVisible(true);
							String from = "app.frame.setEnabled(true);";
							int start = Notepad.textArea.getText().indexOf(from);
							Notepad.textArea.replaceRange("", start, start + from.length());
						}
						break;
					}
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_O:
					if (e.isControlDown()) {
						JFileChooser fc = new JFileChooser();
						fc.showOpenDialog(frame);
						File file1 = fc.getSelectedFile();
						try {
							scan = new Scanner(file1);
							String txt = "";
							while (scan.hasNext()) {
								txt += scan.nextLine() + "\n";
							}
							textArea.setText(txt);
							scan.close();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					}
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_X:
					if (e.isControlDown()) {
						copyToClipboard(textArea.getSelectedText());
						textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
						textArea.insert("", textArea.getCaretPosition());
						break;
					}
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_A:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_B:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_C:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_D:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_E:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_F:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_G:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_H:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_I:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_J:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_K:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_L:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_M:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_P:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_Q:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_R:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_T:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_U:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_V:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_W:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_Y:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_Z:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_0:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_1:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_2:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_3:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_4:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_5:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_6:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_7:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_8:
					/////////////////////////////////////////////////////////////////
				case KeyEvent.VK_9:
					/////////////////////////////////////////////////////////////////
					try {
						scan = new Scanner(file);
						String txt = "";
						while (scan.hasNext()) {
							txt += scan.nextLine() + "\n";
						}

						if (txt.equals(textArea.getText())) {
							frame.setTitle("Notepad");
						} else {
							frame.setTitle("*Notepad");
						}

					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				}
			}
		});

////////////////////////////////////////////////////////////////////////////////////

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		menuBar.setBackground(Color.LIGHT_GRAY);

////////////////////////////////////////////////////////////////////////////////////

		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setIcon(new ImageIcon("folder_image.png"));
		menuBar.add(mnNewMenu);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textArea.getText().equals("")) {
					mntmNewMenuItem.setForeground(Color.GRAY);
				} else {
					as.setVisible(true);

				}
			}
		});

		mntmNewMenuItem.setBackground(Color.LIGHT_GRAY);
		mnNewMenu.add(mntmNewMenuItem);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New Window");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Notepad NewWindow = new Notepad();
				NewWindow.frame.setVisible(true);

			}
		});
		mntmNewMenuItem_1.setBackground(Color.LIGHT_GRAY);
		mnNewMenu.add(mntmNewMenuItem_1);

////////////////////////////////////////////////////////////////////////////////////	

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Open");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textArea.getText().equals("")) {
					JFileChooser fc = new JFileChooser();
					fc.showOpenDialog(frame);
					File file1 = fc.getSelectedFile();
					try {
						scan = new Scanner(file1);
						String txt = "";
						while (scan.hasNext()) {
							txt += scan.nextLine() + "\n";
						}
						textArea.setText(txt);
						scan.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					Notepad NewWindow = new Notepad();
					NewWindow.frame.setVisible(true);
					JFileChooser fc = new JFileChooser();
					fc.showOpenDialog(frame);
					File file1 = fc.getSelectedFile();
					try {
						scan = new Scanner(file1);
						String txt = "";
						while (scan.hasNext()) {
							txt += scan.nextLine() + "\n";
						}
						textArea.setText(txt);
						scan.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		mntmNewMenuItem_2.setBackground(Color.LIGHT_GRAY);
		mnNewMenu.add(mntmNewMenuItem_2);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Save");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					frame.setTitle("Notepad");
					FileWriter fw = new FileWriter(file);
					fw.write(textArea.getText());
					fw.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_3.setBackground(Color.LIGHT_GRAY);
		mnNewMenu.add(mntmNewMenuItem_3);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Close");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textArea.getText().equals("")) {
					frame.setVisible(false);
				} else {
					ase.setVisible(true);

				}
			}
		});

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Save As");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.showSaveDialog(frame);
				File file = fc.getSelectedFile();
				try {
					FileWriter fw = new FileWriter(file);
					fw.write(textArea.getText());
					fw.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_9);

		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Setting");
		mnNewMenu.add(mntmNewMenuItem_12);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		mntmNewMenuItem_4.setBackground(Color.LIGHT_GRAY);
		mnNewMenu.add(mntmNewMenuItem_4);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_19 = new JMenuItem("Close All");
		mntmNewMenuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_19);

////////////////////////////////////////////////////////////////////////////////////

		JMenu mnNewMenu_1 = new JMenu("Edit");
		mnNewMenu_1.setIcon(new ImageIcon("Edit_image.png"));
		mnNewMenu_1.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnNewMenu_1);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Find");

		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textArea.getText().equals("")) {
					mntmNewMenuItem_5.setForeground(Color.GRAY);
				} else {
					frame.setAlwaysOnTop(true);
					f.setVisible(true);

				}
			}
		});

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Copy");
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				copyToClipboard(textArea.getSelectedText());
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_17);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Paste");
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
				textArea.insert(getFromClipboard(), textArea.getCaretPosition());
			}
		});

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Cut");
		mntmNewMenuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copyToClipboard(textArea.getSelectedText());
				textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
				textArea.insert("", textArea.getCaretPosition());
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_18);
		mnNewMenu_1.add(mntmNewMenuItem_16);

////////////////////////////////////////////////////////////////////////////////////
		/* Define menuitem to delete file and textarea text */

		JMenuItem mntmNewMenuItem_20 = new JMenuItem("Delete ");
		mntmNewMenuItem_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText("");
					FileWriter df = new FileWriter(file);
					df.write("");
					df.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_20);

////////////////////////////////////////////////////////////////////////////////////
		/* add menuitem5 to menu */
		mntmNewMenuItem_5.setBackground(Color.LIGHT_GRAY);
		mnNewMenu_1.add(mntmNewMenuItem_5);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Replace");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textArea.getText().equals("")) {
					mntmNewMenuItem_6.setForeground(Color.GRAY);
				} else {
					frame.setAlwaysOnTop(true);
					rf.setVisible(true);

				}
			}
		});
		mntmNewMenuItem_6.setBackground(Color.LIGHT_GRAY);
		mnNewMenu_1.add(mntmNewMenuItem_6);

////////////////////////////////////////////////////////////////////////////////////

		JMenu mnNewMenu_3 = new JMenu("Format");
		mnNewMenu_3.setIcon(new ImageIcon("format_icon.png"));
		menuBar.add(mnNewMenu_3);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Font");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				font.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_10);

////////////////////////////////////////////////////////////////////////////////////

		JMenu mnNewMenu_5 = new JMenu("View");
		mnNewMenu_5.setIcon(new ImageIcon("View_image.png"));
		menuBar.add(mnNewMenu_5);

////////////////////////////////////////////////////////////////////////////////////

		JMenu mnNewMenu_6 = new JMenu("Zoom");
		mnNewMenu_5.add(mnNewMenu_6);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Zoom In");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				font.size1 += 2;
				textArea.setFont(new Font(font.font1, Font.PLAIN, font.size1));
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_13);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Zoom Out");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				font.size1 -= 2;
				textArea.setFont(new Font(font.font1, Font.PLAIN, font.size1));
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_14);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Restore Default Zoom");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));

			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_15);

////////////////////////////////////////////////////////////////////////////////////

		JMenu mnNewMenu_2 = new JMenu("Background Mode");
		mnNewMenu_5.add(mnNewMenu_2);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Dark mode");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setBackground(Color.DARK_GRAY);
				textArea.setForeground(Color.white);
			}
		});

		mntmNewMenuItem_7.setBackground(Color.LIGHT_GRAY);
		mnNewMenu_2.add(mntmNewMenuItem_7);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Light mode");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setBackground(Color.white);
				textArea.setForeground(Color.black);
			}
		});
		mntmNewMenuItem_8.setBackground(Color.LIGHT_GRAY);
		mnNewMenu_2.add(mntmNewMenuItem_8);

////////////////////////////////////////////////////////////////////////////////////

		JMenu mnNewMenu_7 = new JMenu("Compile&Run");
		mnNewMenu_7.setForeground(Color.GRAY);
		menuBar.add(mnNewMenu_7);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_39 = new JMenuItem("Build");
		mntmNewMenuItem_39.setForeground(Color.GRAY);
		mnNewMenu_7.add(mntmNewMenuItem_39);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_40 = new JMenuItem("Run");
		mntmNewMenuItem_40.setForeground(Color.GRAY);
		mnNewMenu_7.add(mntmNewMenuItem_40);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_41 = new JMenuItem("Build/Run");
		mntmNewMenuItem_41.setForeground(Color.GRAY);
		mnNewMenu_7.add(mntmNewMenuItem_41);

////////////////////////////////////////////////////////////////////////////////////

		JMenu mnNewMenu_4 = new JMenu("Help");
		mnNewMenu_4.setIcon(new ImageIcon("Help_image.png"));
		menuBar.add(mnNewMenu_4);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Whatsapp Support");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
					try {
						Desktop.getDesktop().browse(new URI("http://wa.me/989038770524"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_11);

////////////////////////////////////////////////////////////////////////////////////

		JScrollPane scrollableTextArea = new JScrollPane(textArea);

		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		frame.getContentPane().add(scrollableTextArea);

////////////////////////////////////////////////////////////////////////////////////

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setRequestFocusEnabled(false);
		menuBar_1.setOpaque(false);
		menuBar_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		menuBar_1.setPreferredSize(new Dimension(20, 26));
		scrollableTextArea.setColumnHeaderView(menuBar_1);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to create new file */

		JMenuItem mntmNewMenuItem_21 = new JMenuItem("");
		mntmNewMenuItem_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (textArea.getText().equals("")) {
				} else {
					as.setVisible(true);
				}
			}
		});
		mntmNewMenuItem_21.setRolloverEnabled(true);
		mntmNewMenuItem_21.setFocusable(true);
		mntmNewMenuItem_21.setIcon(new ImageIcon("Newfile-icon.png"));
		mntmNewMenuItem_21.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_21.setMinimumSize(new Dimension(30, 25));
		mntmNewMenuItem_21.setToolTipText("New");
		menuBar_1.add(mntmNewMenuItem_21);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to show open page */

		JMenuItem mntmNewMenuItem_22 = new JMenuItem("");
		mntmNewMenuItem_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (textArea.getText().equals("")) {
					JFileChooser fc = new JFileChooser();
					fc.showOpenDialog(frame);
					File file1 = fc.getSelectedFile();
					try {
						scan = new Scanner(file1);
						String txt = "";
						while (scan.hasNext()) {
							txt += scan.nextLine() + "\n";
						}
						textArea.setText(txt);
						scan.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					Notepad NewWindow = new Notepad();
					NewWindow.frame.setVisible(true);
					JFileChooser fc = new JFileChooser();
					fc.showOpenDialog(frame);
					File file1 = fc.getSelectedFile();
					try {
						scan = new Scanner(file1);
						String txt = "";
						while (scan.hasNext()) {
							txt += scan.nextLine() + "\n";
						}
						textArea.setText(txt);
						scan.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		mntmNewMenuItem_22.setRolloverEnabled(true);
		mntmNewMenuItem_22.setFocusable(true);
		mntmNewMenuItem_22.setIcon(new ImageIcon("open-icon.png"));
		mntmNewMenuItem_22.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_22.setMinimumSize(new Dimension(30, 25));
		mntmNewMenuItem_22.setToolTipText("Open");
		menuBar_1.add(mntmNewMenuItem_22);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to save */

		JMenuItem mntmNewMenuItem_23 = new JMenuItem("");
		mntmNewMenuItem_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {

					frame.setTitle("Notepad");
					FileWriter fw = new FileWriter(file);
					fw.write(textArea.getText());
					fw.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_23.setRolloverEnabled(true);
		mntmNewMenuItem_23.setFocusable(true);
		mntmNewMenuItem_23.setIcon(new ImageIcon("Save-icon.png"));
		mntmNewMenuItem_23.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_23.setMinimumSize(new Dimension(30, 25));
		mntmNewMenuItem_23.setToolTipText("Save");
		menuBar_1.add(mntmNewMenuItem_23);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to show save as page */

		JMenuItem mntmNewMenuItem_24 = new JMenuItem("");
		mntmNewMenuItem_24.setRolloverEnabled(true);
		mntmNewMenuItem_24.setFocusable(true);
		mntmNewMenuItem_24.setIcon(new ImageIcon("Save-as-icon.png"));
		mntmNewMenuItem_24.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_24.setMinimumSize(new Dimension(30, 25));
		mntmNewMenuItem_24.setToolTipText("Save As");
		menuBar_1.add(mntmNewMenuItem_24);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to close */

		JMenuItem mntmNewMenuItem_25 = new JMenuItem("");
		mntmNewMenuItem_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (textArea.getText().equals("")) {
					frame.setVisible(false);
				} else {
					ase.setVisible(true);
				}
			}
		});
		mntmNewMenuItem_25.setRolloverEnabled(true);
		mntmNewMenuItem_25.setFocusable(true);
		mntmNewMenuItem_25.setIcon(new ImageIcon("close-icon.png"));
		mntmNewMenuItem_25.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_25.setMinimumSize(new Dimension(30, 25));
		mntmNewMenuItem_25.setToolTipText("Close");
		menuBar_1.add(mntmNewMenuItem_25);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to close all */

		JMenuItem mntmNewMenuItem_26 = new JMenuItem("");
		mntmNewMenuItem_26.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_26.setRolloverEnabled(true);
		mntmNewMenuItem_26.setFocusable(true);
		mntmNewMenuItem_26.setIcon(new ImageIcon("close-all-icon.png"));
		mntmNewMenuItem_26.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_26.setMinimumSize(new Dimension(30, 25));
		mntmNewMenuItem_26.setToolTipText("Close All");
		menuBar_1.add(mntmNewMenuItem_26);

////////////////////////////////////////////////////////////////////////////////////

		JSeparator separator_2 = new JSeparator();
		separator_2.setPreferredSize(new Dimension(0, 0));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		menuBar_1.add(separator_2);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to cut */

		JMenuItem mntmNewMenuItem_27 = new JMenuItem("");
		mntmNewMenuItem_27.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				copyToClipboard(textArea.getSelectedText());
				textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
				textArea.insert("", textArea.getCaretPosition());
			}
		});
		mntmNewMenuItem_27.setRolloverEnabled(true);
		mntmNewMenuItem_27.setFocusable(true);
		mntmNewMenuItem_27.setIcon(new ImageIcon("Cut-icon.png"));
		mntmNewMenuItem_27.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_27.setMinimumSize(new Dimension(30, 25));
		mntmNewMenuItem_27.setToolTipText("Cut");
		menuBar_1.add(mntmNewMenuItem_27);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to copy */

		JMenuItem mntmNewMenuItem_28 = new JMenuItem("");
		mntmNewMenuItem_28.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				copyToClipboard(textArea.getSelectedText());
			}
		});
		mntmNewMenuItem_28.setRolloverEnabled(true);
		mntmNewMenuItem_28.setFocusable(true);
		mntmNewMenuItem_28.setIcon(new ImageIcon("copy-icon.png"));
		mntmNewMenuItem_28.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_28.setMinimumSize(new Dimension(30, 25));
		mntmNewMenuItem_28.setToolTipText("Copy");
		menuBar_1.add(mntmNewMenuItem_28);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to paste */

		JMenuItem mntmNewMenuItem_29 = new JMenuItem("");
		mntmNewMenuItem_29.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
				textArea.insert(getFromClipboard(), textArea.getCaretPosition());
			}
		});
		mntmNewMenuItem_29.setRolloverEnabled(true);
		mntmNewMenuItem_29.setFocusable(true);
		mntmNewMenuItem_29.setIcon(new ImageIcon("paste-icon.png"));
		mntmNewMenuItem_29.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_29.setMinimumSize(new Dimension(30, 25));
		mntmNewMenuItem_29.setToolTipText("Paste");
		menuBar_1.add(mntmNewMenuItem_29);

////////////////////////////////////////////////////////////////////////////////////

		JSeparator separator_3 = new JSeparator();
		separator_3.setPreferredSize(new Dimension(0, 0));
		separator_3.setOrientation(SwingConstants.VERTICAL);
		menuBar_1.add(separator_3);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to undo */

		JMenuItem mntmNewMenuItem_30 = new JMenuItem("");
		mntmNewMenuItem_30.setRolloverEnabled(true);
		mntmNewMenuItem_30.setFocusable(true);
		mntmNewMenuItem_30.setIcon(new ImageIcon("undo-icon.png"));
		mntmNewMenuItem_30.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_30.setMinimumSize(new Dimension(20, 25));
		mntmNewMenuItem_30.setToolTipText("Undo");
		menuBar_1.add(mntmNewMenuItem_30);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to redo */
		JMenuItem mntmNewMenuItem_31 = new JMenuItem("");
		mntmNewMenuItem_31.setRolloverEnabled(true);
		mntmNewMenuItem_31.setFocusable(true);
		mntmNewMenuItem_31.setIcon(new ImageIcon("redo-icon.png"));
		mntmNewMenuItem_31.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_31.setMinimumSize(new Dimension(20, 25));
		mntmNewMenuItem_31.setToolTipText("Redo");
		menuBar_1.add(mntmNewMenuItem_31);

////////////////////////////////////////////////////////////////////////////////////

		JSeparator separator_4 = new JSeparator();
		separator_4.setPreferredSize(new Dimension(0, 0));
		separator_4.setOrientation(SwingConstants.VERTICAL);
		menuBar_1.add(separator_4);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to show find page */
		JMenuItem mntmNewMenuItem_32 = new JMenuItem("");
		mntmNewMenuItem_32.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (textArea.getText().equals("")) {
				} else {
					frame.setAlwaysOnTop(true);
					f.setVisible(true);
				}
			}
		});
		mntmNewMenuItem_32.setRolloverEnabled(true);
		mntmNewMenuItem_32.setFocusable(true);
		mntmNewMenuItem_32.setIcon(new ImageIcon("find-icon.png"));
		mntmNewMenuItem_32.setPreferredSize(new Dimension(18, 18));
		mntmNewMenuItem_32.setMinimumSize(new Dimension(18, 18));
		mntmNewMenuItem_32.setToolTipText("Find");
		menuBar_1.add(mntmNewMenuItem_32);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to show replace page */

		JMenuItem mntmNewMenuItem_33 = new JMenuItem("");
		mntmNewMenuItem_33.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (textArea.getText().equals("")) {
				} else {
					frame.setAlwaysOnTop(true);
					rf.setVisible(true);
				}
			}
		});
		mntmNewMenuItem_33.setRolloverEnabled(true);
		mntmNewMenuItem_33.setFocusable(true);
		mntmNewMenuItem_33.setIcon(new ImageIcon("replace-icon.png"));
		mntmNewMenuItem_33.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_33.setMinimumSize(new Dimension(30, 25));
		mntmNewMenuItem_33.setToolTipText("Replace");
		menuBar_1.add(mntmNewMenuItem_33);

////////////////////////////////////////////////////////////////////////////////////

		JSeparator separator_5 = new JSeparator();
		separator_5.setPreferredSize(new Dimension(0, 0));
		separator_5.setOrientation(SwingConstants.VERTICAL);
		menuBar_1.add(separator_5);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to zoom out */

		JMenuItem mntmNewMenuItem_34 = new JMenuItem("");
		mntmNewMenuItem_34.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				font.size1 += 2;
				textArea.setFont(new Font(font.font1, Font.PLAIN, font.size1));
			}
		});
		mntmNewMenuItem_34.setRolloverEnabled(true);
		mntmNewMenuItem_34.setFocusable(true);
		mntmNewMenuItem_34.setIcon(new ImageIcon("zoom-out-icon.png"));
		mntmNewMenuItem_34.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_34.setMinimumSize(new Dimension(30, 25));
		mntmNewMenuItem_34.setToolTipText("Zoom Out");
		menuBar_1.add(mntmNewMenuItem_34);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to zoom in */

		JMenuItem mntmNewMenuItem_35 = new JMenuItem("");
		mntmNewMenuItem_35.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				font.size1 -= 2;
				textArea.setFont(new Font(font.font1, Font.PLAIN, font.size1));
			}
		});
		mntmNewMenuItem_35.setRolloverEnabled(true);
		mntmNewMenuItem_35.setFocusable(true);
		mntmNewMenuItem_35.setIcon(new ImageIcon("zoom-in-icon.png"));
		mntmNewMenuItem_35.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_35.setMinimumSize(new Dimension(30, 25));
		mntmNewMenuItem_35.setToolTipText("Zoom In");
		menuBar_1.add(mntmNewMenuItem_35);

////////////////////////////////////////////////////////////////////////////////////

		JSeparator separator_6 = new JSeparator();
		separator_6.setPreferredSize(new Dimension(0, 0));
		separator_6.setOrientation(SwingConstants.VERTICAL);
		menuBar_1.add(separator_6);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to show select language page */

		JMenuItem mntmNewMenuItem_36 = new JMenuItem("");
		mntmNewMenuItem_36.setRolloverEnabled(true);
		mntmNewMenuItem_36.setFocusable(true);
		mntmNewMenuItem_36.setIcon(new ImageIcon("selectlanguege-icon.png"));
		mntmNewMenuItem_36.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_36.setMinimumSize(new Dimension(30, 25));
		mntmNewMenuItem_36.setToolTipText("Select Language");
		menuBar_1.add(mntmNewMenuItem_36);

////////////////////////////////////////////////////////////////////////////////////
		/* define menu item to show document list */

		JMenuItem mntmNewMenuItem_37 = new JMenuItem("");
		mntmNewMenuItem_37.setRolloverEnabled(true);
		mntmNewMenuItem_37.setFocusable(true);
		mntmNewMenuItem_37.setIcon(new ImageIcon("document-list-icon.png"));
		mntmNewMenuItem_37.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_37.setMinimumSize(new Dimension(30, 25));
		mntmNewMenuItem_37.setToolTipText("Document List");
		menuBar_1.add(mntmNewMenuItem_37);

////////////////////////////////////////////////////////////////////////////////////

		JMenuItem mntmNewMenuItem_38 = new JMenuItem("");
		mntmNewMenuItem_38.setRolloverEnabled(true);
		mntmNewMenuItem_38.setFocusable(true);
		mntmNewMenuItem_38.setPreferredSize(new Dimension(20, 20));
		mntmNewMenuItem_38.setMinimumSize(new Dimension(30, 25));
		menuBar_1.add(mntmNewMenuItem_38);

////////////////////////////////////////////////////////////////////////////////////
	}

	// to highlight next selected word when press
	public void findNext(String keyWord) {
		textArea.getHighlighter().removeAllHighlights();
		String text = textArea.getText();

		if (text.length() > 0) {
			findIndex = text.indexOf(keyWord, findIndex + 1);
			if (findIndex != -1) {
				try {
					textArea.getHighlighter().addHighlight(findIndex, findIndex + keyWord.length(), painter);

				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// to get textArea text
	public String textarea() {
		if (textArea.getText().equals("")) {
			return null;
		} else {
			return textArea.getText();
		}
	}

	// to highlight all selected words
	public void findAll(String text) {
		findIndex = -1;
		if (text.length() > 0) {
			textArea.getHighlighter().removeAllHighlights();
			String txt = textArea.getText();
			int index = -1;
			while (true) {
				index = txt.indexOf(text, index + 1);
				if (index == -1) {
					break;
				} else {
					try {
						textArea.getHighlighter().addHighlight(index, index + text.length(), painter);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	// to replace all selected words
	public boolean replacesAll(String text) {
		findIndex = -1;
		if (text.length() > 0) {
			textArea.getHighlighter().removeAllHighlights();
			String txt = textArea.getText();
			int index = -1;
			while (true) {
				index = txt.indexOf(text, index + 1);

				if (index == -1) {
					TF = false;
					return false;

				} else {
					TF = true;
					return true;
				}
			}
		}
		return false;
	}
}