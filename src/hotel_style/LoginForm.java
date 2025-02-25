package hotel_style;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LoginForm implements ActionListener {
	JFrame frame = new JFrame();
	//JButton loginButton = new JButton("Login");
	//JButton resetButton = new JButton("reset");
	
	HtlBtn loginButton = new HtlBtn("Login");
	HtlBtn resetButton = new HtlBtn("Reset");
	
	

	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	
	JLabel userIDLabel = new JLabel("UserID:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel();
	
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	public LoginForm(HashMap<String,String> loginInfoOriginal){
		logininfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		messageLabel.setBounds(125, 250, 250, 30);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.addActionListener(this);
		resetButton.setBounds(230, 200, 100, 25);
		resetButton.addActionListener(this);
		
		userIDField.setBorder(BorderFactory.createLineBorder(Color.gray));
		userIDField.setBorder(BorderFactory.createCompoundBorder(
		        userIDField.getBorder(), 
		        BorderFactory.createEmptyBorder(3,3, 3, 3)));
		userPasswordField.setBorder(BorderFactory.createLineBorder(Color.gray));
		userPasswordField.setBorder(BorderFactory.createCompoundBorder(
				userPasswordField.getBorder(), 
				BorderFactory.createEmptyBorder(3,3, 3, 3)));
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		if(e.getSource()==loginButton) {
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if (logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login succesful");
					frame.dispose();
					StandardView standard = new StandardView();
				}else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong Password");
				}
			}else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username not found");
			}
		}
		
	}
}
