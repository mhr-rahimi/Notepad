import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AskSave extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane1;

	/**
	 * Create the frame.
	 */
	public AskSave(Notepad app) {
////////////////////////////////////////////////////////////////////////////////////
        /*set contentPane option */
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(150, 150, 450, 300);
		setTitle("Notepad");
		setSize(337,168);
//		setLocation(50,100);
		setAlwaysOnTop(true);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Cancel button */
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				app.frame.setEnabled(true);
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(235, 95, 77, 25);
		contentPane1.add(btnNewButton);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Don't save button */
		JButton btnDontSave = new JButton("Don't Save");
		btnDontSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Notepad.textArea.setText("");
				setVisible(false);
				app.frame.setEnabled(true);
			}
		});
		btnDontSave.setForeground(Color.BLACK);
		btnDontSave.setBackground(Color.GRAY);
		btnDontSave.setBounds(144, 95, 85, 25);
		contentPane1.add(btnDontSave);
		
////////////////////////////////////////////////////////////////////////////////////
		/* save button */
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file=new File("Notepad.txt");
				try {
					FileWriter fw=new FileWriter(file);
					fw.write(Notepad.textArea.getText());
					fw.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				app.frame.setEnabled(true);
				
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(62, 95, 75, 25);
		contentPane1.add(btnNewButton_1);
		
////////////////////////////////////////////////////////////////////////////////////
		/* label to show text */
		JLabel lblNewLabel_2 = new JLabel("Do you want to save changes to Untitled?");
		lblNewLabel_2.setForeground(new Color(72, 61, 139));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN,14));
		lblNewLabel_2.setBounds(20, 20, 269, 57);
		contentPane1.add(lblNewLabel_2);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Label to set bottom background */
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setAutoscrolls(true);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(211, 211, 211));
		lblNewLabel.setBounds(0, 88, 320, 40);
		contentPane1.add(lblNewLabel);
		
////////////////////////////////////////////////////////////////////////////////////
		/* Label to set up background */
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 321, 88);
		contentPane1.add(lblNewLabel_1);
////////////////////////////////////////////////////////////////////////////////////	

		
		
	}
}
