import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReplaceFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane2;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Create the frame.
	 */
	public ReplaceFrame(Notepad app) {
////////////////////////////////////////////////////////////////////////////////////
		/*set contentPane option */
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 379, 190);
		setTitle("Replace");
		setResizable(false);
		setAlwaysOnTop(true);
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane2);
		contentPane2.setLayout(null);
		
////////////////////////////////////////////////////////////////////////////////////
		/*  set replace button action */
		JButton btnNewButton = new JButton("Replace");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(Notepad.textArea.getText().equals("")) {
				}
				else {
				if(textField.getText()!="" &&textField_1.getText()!="") {
					String from = textField.getText();
				    int start = Notepad.textArea.getText().indexOf(from);
					Notepad.textArea.replaceRange(textField_1.getText(), start, start+from.length());
					String from2 =" ";
				    int start2 = Notepad.textArea.getText().indexOf(from);
					Notepad.textArea.replaceRange("", start2, start2+from2.length());
				}
				}
			}
		});
		
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN,15));
		btnNewButton.setBounds(264, 53, 89, 33);
		contentPane2.add(btnNewButton);
		
////////////////////////////////////////////////////////////////////////////////////
		//find what
		
		textField = new JTextField();
		textField.setBounds(79, 11, 175, 25);
		contentPane2.add(textField);
		textField.setColumns(10);
		
////////////////////////////////////////////////////////////////////////////////////
		//replace with
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(79, 53, 175, 25);
		contentPane2.add(textField_1);
		
////////////////////////////////////////////////////////////////////////////////////
		/* set replace all button action */
		JButton btnNewButton_1 = new JButton("Replace All");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(Notepad.textArea.getText().equals("")) {
				}
				else {
					while(app.replacesAll(textField.getText())) {
						if(textField.getText()!="" &&textField_1.getText()!="") {
							String from = textField.getText();
							int start = Notepad.textArea.getText().indexOf(from);
							app.replacesAll(textField.getText());
							Notepad.textArea.replaceRange(textField_1.getText(), start, start+from.length());
				        }
			     	}
				}
			}
		});
		
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(165, 98, 89, 33);
		contentPane2.add(btnNewButton_1);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Define Cancel button */
		JButton btnNewButton_1_1 = new JButton("Cancel");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Notepad.textArea.getHighlighter().removeAllHighlights();
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(264, 97, 89, 33);
		contentPane2.add(btnNewButton_1_1);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Label to show "find what: " */
		
		JLabel lblNewLabel = new JLabel("  Find what :");
		lblNewLabel.setBounds(0, 11, 65, 25);
		contentPane2.add(lblNewLabel);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Label to show "replace with: " */
		
		JLabel lblReplaceWhit = new JLabel("  Replace whit :");
		lblReplaceWhit.setBounds(0, 53, 79, 25);
		contentPane2.add(lblReplaceWhit);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Define Find button */
		JButton btnFind = new JButton("Find");
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  //for app not find the space
				app.findNext(textField.getText().replaceAll(" ",""));
			}
		});
		btnFind.setBackground(Color.LIGHT_GRAY);
		btnFind.setBounds(264, 11, 89, 33);
		contentPane2.add(btnFind);
		
////////////////////////////////////////////////////////////////////////////////////

		
	}
}
