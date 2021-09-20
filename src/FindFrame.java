import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class FindFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public FindFrame(Notepad app) {
////////////////////////////////////////////////////////////////////////////////////
		/*set contentPane option */
		
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(200, 200, 373, 139);
		setTitle("Find");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Define Find button */
		JButton btnNewButton = new JButton("Find");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  //for app not find the space
				app.findNext(textField.getText().replaceAll(" ",""));
			}
		});
		btnNewButton.setBounds(265, 20, 89, 28);
		contentPane.add(btnNewButton); 
		
////////////////////////////////////////////////////////////////////////////////////
		/* Define Cancel button */
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Notepad.textArea.getHighlighter().removeAllHighlights();
			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(265, 59, 89, 28);
		contentPane.add(btnNewButton_1);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Define and set action  Find All button */
		JButton btnFindAll = new JButton("Find All");
		btnFindAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.findAll(textField.getText());
			}
		});
		btnFindAll.setBackground(Color.LIGHT_GRAY);
		btnFindAll.setBounds(166, 58, 89, 28);
		contentPane.add(btnFindAll);
		
////////////////////////////////////////////////////////////////////////////////////
		/* to write witch text do you need to find */
		
		textField = new JTextField();
		textField.setBounds(77, 20, 178, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Label to show "find what: " text */
		
		JLabel lblNewLabel = new JLabel("Find what :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN,15));
		lblNewLabel.setBounds(10, 19, 65, 28);
		contentPane.add(lblNewLabel);
////////////////////////////////////////////////////////////////////////////////////

	}
}
