import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class FontF extends JFrame {
	String font1="Tahoma";
     int size1=15;
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public FontF(Notepad app) {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Font");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 346, 276);
		contentPane = new JPanel();
		
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Size selected Box */
		
		String Size[]= {"8","10","12","14","16","18","20","24","36","54","72"};
		JComboBox<String> comboBox = new JComboBox<String>(Size);
		comboBox.setEditable(true);
		comboBox.setBounds(218, 50, 73, 20);
		comboBox.setEditable(true);
		contentPane.add(comboBox);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Font selected Box */
		
		String Fontsize[]= {"Tahoma","Elephant","Comic Sans MS","Engravers MT","Bodoni MT black"};
		JComboBox<String> comboBox2 = new JComboBox<String>(Fontsize);
		comboBox2.setEditable(true);
		comboBox2.setBounds(45, 50, 100, 20);
		comboBox2.setEditable(true);
		contentPane.add(comboBox2);

////////////////////////////////////////////////////////////////////////////////////
		/* Label to show "size: " */
		JLabel lblNewLabel = new JLabel("Size :");
		lblNewLabel.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN,size1));
		lblNewLabel.setBounds(240, 11, 42, 26);
		contentPane.add(lblNewLabel);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Label to show "font: " */
		JLabel lblFont = new JLabel("Font :");
		lblFont.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, size1));
		lblFont.setBounds(76, 11, 42, 26);
		contentPane.add(lblFont);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Done button */
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 font1 =comboBox.getItemAt(comboBox.getSelectedIndex());
				 String dataSize =comboBox.getItemAt(comboBox.getSelectedIndex());				
				  size1=Integer.parseInt(dataSize);
					Notepad.textArea.setFont(new Font(font1,Font.PLAIN,size1));
				setVisible(false);
			}
		});
		btnNewButton.setBounds(140, 198, 80, 23);
		contentPane.add(btnNewButton);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Cancel button */
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				font1="Tahoma";
				size1=15;
				Notepad.textArea.setFont(new Font(font1,Font.PLAIN,size1));
				setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(230, 198, 80, 23);
		contentPane.add(btnNewButton_1);
////////////////////////////////////////////////////////////////////////////////////

		
		
	}
}
