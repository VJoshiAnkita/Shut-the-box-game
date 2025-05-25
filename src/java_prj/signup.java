package java_prj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class signup {
    private static JPanel panel_1;
    static JFrame frame = new JFrame("Signup Page");
    
    public static void main(String[] args) {
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(710, 472);

        panel_1 = new JPanel();
        frame.getContentPane().add(panel_1);
        placeComponents(panel_1);

        JLabel label = new JLabel("New label");
        label.setBounds(-2, -13, 45, 13);
        panel_1.add(label);

        JLabel lblNewLabel = new JLabel("SIGNUP");
        lblNewLabel.setForeground(new Color(85, 107, 47));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel.setBounds(145, 31, 164, 57);
        panel_1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(signup.class.getResource("/images/signup img.jpg")));
        lblNewLabel_1.setBounds(-2, 0, 696, 433);
        panel_1.add(lblNewLabel_1);

        frame.setVisible(true);
        
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        Font labelFont = new Font("SansSerif", Font.PLAIN, 18);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 18);

        JLabel nameLabel = new JLabel("Enter Name:");
        nameLabel.setForeground(new Color(85, 107, 47));
        nameLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 18));
        nameLabel.setBounds(43, 125, 120, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setFont(labelFont);
        nameText.setBounds(238, 124, 152, 25);
        panel.add(nameText);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(new Color(85, 107, 47));
        userLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 18));
        userLabel.setBounds(43, 161, 120, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setFont(labelFont);
        userText.setBounds(238, 161, 152, 25);
        panel.add(userText);

        JLabel emailLabel = new JLabel("Enter Email:");
        emailLabel.setForeground(new Color(85, 107, 47));
        emailLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 18));
        emailLabel.setBounds(43, 195, 120, 25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setFont(labelFont);
        emailText.setBounds(238, 195, 152, 25);
        panel.add(emailText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(new Color(85, 107, 47));
        passwordLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 18));
        passwordLabel.setBounds(43, 231, 120, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setFont(labelFont);
        passwordText.setBounds(238, 230, 152, 26);
        panel.add(passwordText);

        JLabel confirmLabel = new JLabel("Confirm Password:");
        confirmLabel.setForeground(new Color(85, 107, 47));
        confirmLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 18));
        confirmLabel.setBounds(43, 267, 180, 25);
        panel.add(confirmLabel);

        JPasswordField confirmText = new JPasswordField(20);
        confirmText.setFont(labelFont);
        confirmText.setBounds(238, 267, 152, 25);
        panel.add(confirmText);

        JButton signupButton = new JButton("Signup");
        signupButton.setFont(buttonFont);
        signupButton.setBounds(43, 314, 136, 45);
        panel.add(signupButton);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		login lg = new login();
        		
        		
        	}
        });
        loginButton.setFont(buttonFont);
        loginButton.setBounds(254, 314, 136, 45);
        panel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and show the login page when the "Login" button is pressed.
            	
            	frame.dispose();
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String username = userText.getText();
                String email = emailText.getText();
                String password = new String(passwordText.getPassword());
                String confirmPassword = new String(confirmText.getPassword());

                if (name.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "All fields are mandatory. Please fill in all the details.");
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(panel, "Passwords do not match. Please try again.");
                    }
                    else if (checkUsernameExistence(username)) {
                        JOptionPane.showMessageDialog(panel, "Username already exists. Please choose a different one.");
                    }
                 else {
                    // Perform signup if all fields are filled and passwords match.
                    if (insertData(name, username, email, password)) {
                        JOptionPane.showMessageDialog(panel, "Signup Successful!");
                        login lg = new login();
                        
                        // dispose();
                        
                    }
                    else {
                        JOptionPane.showMessageDialog(panel, "Signup failed. Please try again.");
                    }
                }
            }
           
            
        });
    }

    // Insert data into the database
    private static boolean insertData(String name, String username, String email, String password) {
        String url = "jdbc:mysql://localhost:3306/javaprj";
        String user = "root";
        String password1 = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password1);
            String sql = "INSERT INTO login (name, username, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, username);
            statement.setString(3, email);
            statement.setString(4, password);
            int rowsInserted = statement.executeUpdate();
            statement.close();
            connection.close();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    private static boolean checkUsernameExistence(String username) {
        String url = "jdbc:mysql://localhost:3306/javaprj";
        String user = "root";
        String password1 = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password1);
            String sql = "SELECT COUNT(*) FROM login WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            resultSet.close();
            statement.close();
            connection.close();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}