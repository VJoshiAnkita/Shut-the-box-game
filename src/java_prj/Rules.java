package java_prj;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Rules extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 * @param username 
	 */
	public static void main(String[] args, String username) {
		try {
			Rules dialog = new Rules(username);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Rules(String username) {
		setBounds(100, 100, 319, 433);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(0, 0, 128));
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel rule_label = new JLabel("Rules of the Game");
			rule_label.setForeground(new Color(0, 128, 0));
			rule_label.setBounds(10, 30, 206, 32);
			rule_label.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 20));
			contentPanel.add(rule_label);
		}
		{
			JLabel rule1 = new JLabel("1.Roll the dice.");
			rule1.setForeground(new Color(0, 128, 0));
			rule1.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
			rule1.setBounds(24, 86, 301, 40);
			contentPanel.add(rule1);
		}
		
		JLabel rule2 = new JLabel("2.select the numbers between 1 and 12 ");
		rule2.setForeground(new Color(0, 128, 0));
		rule2.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		rule2.setBounds(24, 133, 432, 32);
		contentPanel.add(rule2);
		
		JLabel rule2_a = new JLabel("either the number rolled itself ");
		rule2_a.setForeground(new Color(0, 128, 0));
		rule2_a.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		rule2_a.setBounds(44, 164, 255, 14);
		contentPanel.add(rule2_a);
		
		JLabel rule2_b = new JLabel("or the a set of numbers whose sum");
		rule2_b.setForeground(new Color(0, 128, 0));
		rule2_b.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		rule2_b.setBounds(44, 177, 469, 25);
		contentPanel.add(rule2_b);
		{
			JLabel rule2_b_1 = new JLabel("is the number on the dice.");
			rule2_b_1.setForeground(new Color(0, 128, 0));
			rule2_b_1.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
			rule2_b_1.setBounds(44, 189, 469, 25);
			contentPanel.add(rule2_b_1);
		}
		
		JLabel rule3 = new JLabel("3.shut all the 12 boxes to win the game!");
		rule3.setForeground(new Color(0, 128, 0));
		rule3.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		rule3.setBounds(24, 234, 451, 25);
		contentPanel.add(rule3);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Rules.class.getResource("/images/leaderboard img.jpg")));
			lblNewLabel.setBounds(0, 0, 311, 361);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JavaPrj jp=new JavaPrj(username);
						jp.setVisible(true);
						dispose();
					
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
