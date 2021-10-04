import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField phone;
	private JTextField address;
	private JTextField birthday;
	private JTextField anniversary;
	private JTable table_1;
	private JScrollPane scrollPane;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 395);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(40, 29, 67, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(40, 54, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setBounds(40, 79, 69, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(279, 29, 67, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Anniversary");
		lblNewLabel_4.setBounds(279, 79, 63, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Birthday");
		lblNewLabel_5.setBounds(279, 54, 67, 14);
		contentPane.add(lblNewLabel_5);
		
		name = new JTextField();
		name.setBounds(117, 26, 118, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		email = new JTextField();
		email.setBounds(117, 51, 118, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(117, 76, 118, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		address = new JTextField();
		address.setBounds(364, 26, 118, 20);
		contentPane.add(address);
		address.setColumns(10);
		
		birthday = new JTextField();
		birthday.setBounds(364, 51, 118, 20);
		contentPane.add(birthday);
		birthday.setColumns(10);
		
		anniversary = new JTextField();
		anniversary.setBounds(364, 76, 118, 20);
		contentPane.add(anniversary);
		anniversary.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 138, 718, 207);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i= table_1.getSelectedRow();
				name.setText(model.getValueAt(i, 0).toString());
				email.setText(model.getValueAt(i, 1).toString());
				phone.setText(model.getValueAt(i, 2).toString());
				address.setText(model.getValueAt(i, 3).toString());
				birthday.setText(model.getValueAt(i, 4).toString());
				anniversary.setText(model.getValueAt(i, 5).toString());
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"Name","email","phone","Address","Birthday","Anniversary"};
		Object[] row = new Object[6];
		model.setColumnIdentifiers(column);
		table_1.setModel(model);
			
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().equals("") || email.getText().equals("") || phone.getText().equals("") || address.getText().equals("") || birthday.getText().equals("") || anniversary.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
				}
				else
				{
					row[0] = name.getText();
					row[1] = email.getText();
					row[2] = phone.getText();
					row[3] = address.getText();
					row[4] = birthday.getText();
					row[5] = anniversary.getText();
					model.addRow(row);
					
					name.setText(" ");
					email.setText(" ");
					phone.setText(" ");
					address.setText(" ");
					birthday.setText(" ");
					anniversary.setText(" ");
					JOptionPane.showMessageDialog(null, "Saved Sucessfully");
				}
				
			}
		});
		btnNewButton.setBounds(499, 25, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				email.setText("");
				phone.setText("");
				address.setText("");
				birthday.setText("");
				anniversary.setText("");
			}
			
			
		});
		btnNewButton_1.setBounds(602, 25, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i= table_1.getSelectedRow();
				if(i>0)
				{
					model.setValueAt(name.getText(), i, 0);
					model.setValueAt(email.getText(), i, 1);
					model.setValueAt(phone.getText(), i, 2);
					model.setValueAt(address.getText(), i, 3);
					model.setValueAt(birthday.getText(), i, 4);
					model.setValueAt(anniversary.getText(), i, 5);
					JOptionPane.showMessageDialog(null, "Updated Sucessfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Select a Row first");	
				}
			}
		});
		btnNewButton_2.setBounds(499, 75, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("DELETE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table_1.getSelectedRow();
				if(i>=0)
				{
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Select a Row first");
				}
			}
		});
		btnNewButton_1_1.setBounds(602, 75, 89, 23);
		contentPane.add(btnNewButton_1_1);
	}
}
