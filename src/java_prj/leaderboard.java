package java_prj;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class leaderboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					leaderboard frame = new leaderboard(username);
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
	public leaderboard(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Leader Board");
		title.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 20));
		title.setBounds(21, 22, 178, 22);
		contentPane.add(title);
		
		JLabel top = new JLabel("top 5");
		top.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 18));
		top.setVerticalAlignment(SwingConstants.BOTTOM);
		top.setBounds(21, 50, 44, 22);
		contentPane.add(top);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(31, 83, 235, 179);
		contentPane.add(tabbedPane);
		
		JPanel players_high = new JPanel();
		players_high.setLayout(null);
		tabbedPane.addTab("Highscore", null, players_high, null);
		
		JPanel name_1 = new JPanel();
		name_1.setLayout(null);
		name_1.setBounds(10, 0, 98, 140);
		players_high.add(name_1);
		DefaultListModel<String> listModel;
		listModel = new DefaultListModel<>();
		DefaultListModel<String> listModel1;
		listModel1 = new DefaultListModel<>();
        // Add contents to the DefaultListModel
        try {
            // Step 1: Connect to the Database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaprj", "root", "");

            // Step 2: Retrieve Data from the Database
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name,score from score order by score desc limit 5");

            // Step 3: Populate JLabels with Data
            while (resultSet.next()) {
                listModel.addElement(resultSet.getString("name"));
                listModel1.addElement(resultSet.getString("score"));
                // Update with other columns as needed
            }

            // Step 4: Close Database Connection
            connection.close();

        } catch (Exception d) {
            d.printStackTrace();
        }
		JLabel no1_1 = new JLabel("player name");
		no1_1.setBounds(0, 0, 98, 14);
		name_1.add(no1_1);
		
		@SuppressWarnings("rawtypes")
		JList player_name = new JList<>(listModel);
		player_name.setBounds(10, 25, 78, 104);
		name_1.add(player_name);
		 
		JPanel score_1 = new JPanel();
		score_1.setLayout(null);
		score_1.setBounds(165, 0, 55, 140);
		players_high.add(score_1);
		
		JLabel no1_score_1 = new JLabel("scores");
		no1_score_1.setBounds(0, 0, 55, 14);
		score_1.add(no1_score_1);
		
		@SuppressWarnings("rawtypes")
		JList player_score = new JList<>(listModel1);
		player_score.setBounds(10, 25, 35, 104);
		score_1.add(player_score);
		DefaultListModel<String> listModel2;
		listModel2 = new DefaultListModel<>();
		DefaultListModel<String> listModel3;
		listModel3 = new DefaultListModel<>();
        // Add contents to the DefaultListModel
        try {
            // Step 1: Connect to the Database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaprj", "root", "");
            String query = "SELECT date, score FROM score WHERE name = ? LIMIT 5";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                // Set the parameter in the prepared statement
                preparedStatement.setString(1, username);

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                // Step 3: Populate DefaultListModel with Data
                while (resultSet.next()) {
                    listModel2.addElement(resultSet.getString("date"));
                    listModel3.addElement(resultSet.getString("score"));
                    // Update with other columns as needed
                }
            }
            connection.close();

        } catch (Exception d) {
            d.printStackTrace();
        }
		JPanel personal_high = new JPanel();
		tabbedPane.addTab("New tab", null, personal_high, null);
		personal_high.setLayout(null);
		
		JPanel name = new JPanel();
		name.setBounds(10, 0, 87, 140);
		personal_high.add(name);
		name.setLayout(null);
		
		JLabel no1 = new JLabel("date");
		no1.setBounds(0, 0, 87, 14);
		name.add(no1);
		
		@SuppressWarnings("rawtypes")
		JList date = new JList<>(listModel2);
		date.setBounds(0, 22, 87, 107);
		name.add(date);
		
		JPanel score = new JPanel();
		score.setBounds(168, 0, 52, 140);
		personal_high.add(score);
		score.setLayout(null);
		
		JLabel no1_score = new JLabel("scores");
		no1_score.setBounds(0, 0, 46, 14);
		score.add(no1_score);
		
		@SuppressWarnings("rawtypes")
		JList personal_score = new JList<>(listModel3);
		personal_score.setBounds(0, 25, 52, 104);
		score.add(personal_score);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(leaderboard.class.getResource("/images/leaderboard img.jpg")));
		lblNewLabel.setBounds(0, 0, 301, 355);
		contentPane.add(lblNewLabel);
		
	}
}
