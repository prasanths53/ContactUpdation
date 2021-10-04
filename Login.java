import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField uname;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(71, 71, 71, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(71, 99, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		uname = new JTextField();
		uname.setBounds(170, 68, 131, 20);
		contentPane.add(uname);
		uname.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(170, 96, 131, 20);
		contentPane.add(pass);
		pass.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un= uname.getText();
				String pw= pass.getText();
				if(un.equals("pooja")&&pw.equals("pooja")) {
					
					JOptionPane.showMessageDialog(null, "Login Successfull");
					//create object
					Update hframe=new Update();
					hframe.setVisible(true);
				}
				else
				{
			
					
					JOptionPane.showMessageDialog(null, "invalid Username or Password");
				}	
			}
		});
		
		
		btnNewButton.setBounds(152, 161, 89, 23);
		contentPane.add(btnNewButton);
	}
}
