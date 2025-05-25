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

public class login {
    private JFrame frame;

    public login() {
        frame = new JFrame("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(710, 472);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        placeComponents(panel);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\\\Users\\\\achut\\\\Desktop\\\\signup img.jpg"));
        lblNewLabel.setBounds(-2, 0, 696, 433);
        panel.add(lblNewLabel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        Font labelFont = new Font("SansSerif", Font.BOLD, 30);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 18);
        JLabel lblLogin = new JLabel("Login");
        lblLogin.setFont(labelFont);
        lblLogin.setBounds(145, 31, 164, 57);
        panel.add(lblLogin);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(43, 125, 120, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(238, 125, 152, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(43, 161, 120, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(238, 161, 120, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(buttonFont);
        loginButton.setBounds(139, 231, 136, 45);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (checkCredentials(username, password)) {
                    JOptionPane.showMessageDialog(panel, "Login Successful!");
                    Rules rule=new Rules(username);
                    rule.setVisible(true);
                    frame.dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(panel, "Login failed. Please check your credentials.");
                }
            }
        });
    }

    private boolean checkCredentials(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/javaprj";
        String user = "root";
        String password1 = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password1);
            String sql = "SELECT * FROM login WHERE username=? AND password=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            boolean result = resultSet.next();
            resultSet.close();
            statement.close();
            connection.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new login();
            }
        });
    }
}