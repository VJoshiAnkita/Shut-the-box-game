package java_prj;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
class RoundedButton extends JButton {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int radius;

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }
}

public class JavaPrj extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private final DicePanel dicePanel1;
    private final DicePanel dicePanel2;
    private final JButton rollButton;
    private final ArrayList<Integer> no;
    private final ArrayList<RoundedButton> button_name,b;
    int sum = 0,r=0;
    public JavaPrj(String username) {
    	
        setTitle("Two Dice Roll Animation");
        setSize(1026, 549);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 62, 31));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        no = new ArrayList<>();
        button_name=new ArrayList<>();
        b=new ArrayList<>();
        
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 15, 10));
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(128, 128, 128)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 62, 31)));
        panel.setBounds(96, 58, 828, 235);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel numbers = new JPanel();
        numbers.setBounds(36, 34, 757, 163);
        panel.add(numbers);
        numbers.setBackground(new Color(154, 74, 9));
        numbers.setLayout(null);

        RoundedButton b2 = new RoundedButton("2", 10);
        b2.setBackground(new Color(252, 191, 73));
        b2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		b2.setBackground(new Color(44, 161, 60));
        	}
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int buttonValue = Integer.parseInt(b2.getText());
                if(!(no.contains(buttonValue)))
                	no.add(buttonValue);
                b.add(b2);
                button_name.add(b2);
                
            }
        });

        RoundedButton b1 = new RoundedButton("1", 10);
        b1.setBackground(new Color(252, 191, 73));
        b1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		b1.setBackground(new Color(44, 161, 60));
        	}
        });
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int buttonValue = Integer.parseInt(b1.getText());
                if(!(no.contains(buttonValue)))	
                	no.add(buttonValue);
                b.add(b1);
                button_name.add(b1);
                
            }
        });
        b1.setText("1");
        b1.setBounds(25, 26, 60, 110);
        numbers.add(b1);
        b2.setBounds(83, 26, 60, 110);
        numbers.add(b2);

        RoundedButton b3 = new RoundedButton("3", 10);
        b3.setBackground(new Color(252, 191, 73));
        b3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		b3.setBackground(new Color(44, 161, 60));
        	}
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int buttonValue = Integer.parseInt(b3.getText());
                if(!(no.contains(buttonValue)))
                	no.add(buttonValue);
                b.add(b3);
                button_name.add(b3);
                
            }
        });
        b3.setBounds(143, 26, 60, 110);
        numbers.add(b3);

        RoundedButton b4 = new RoundedButton("4", 10);
        b4.setBackground(new Color(252, 191, 73));
        b4.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		b4.setBackground(new Color(44, 161, 60));
        	}
        });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int buttonValue = Integer.parseInt(b4.getText());
                if(!(no.contains(buttonValue)))no.add(buttonValue);
                b.add(b4);
                button_name.add(b4);
                
            }
        });
        b4.setBounds(201, 26, 60, 110);
        numbers.add(b4);

        RoundedButton b5 = new RoundedButton("5", 10);
        b5.setBackground(new Color(252, 191, 73));
        b5.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		b5.setBackground(new Color(44, 161, 60));
        	}
        });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int buttonValue = Integer.parseInt(b5.getText());
                if(!(no.contains(buttonValue)))no.add(buttonValue);
                b.add(b5);
                button_name.add(b5);
                
            }
        });
        b5.setBounds(261, 26, 60, 110);
        numbers.add(b5);

        RoundedButton b6 = new RoundedButton("6", 10);
        b6.setBackground(new Color(252, 191, 73));
        b6.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		b6.setBackground(new Color(44, 161, 60));
        	}
        });
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int buttonValue = Integer.parseInt(b6.getText());
                if(!(no.contains(buttonValue)))no.add(buttonValue);
                b.add(b6);
                button_name.add(b6);
                
            }
        });
        b6.setBounds(321, 26, 60, 110);
        numbers.add(b6);

        RoundedButton b7 = new RoundedButton("7", 10);
        b7.setBackground(new Color(252, 191, 73));
        b7.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		b7.setBackground(new Color(44, 161, 60));
        	}
        });
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int buttonValue = Integer.parseInt(b7.getText());
                if(!(no.contains(buttonValue)))no.add(buttonValue);
                b.add(b7);
                button_name.add(b7);
                
            }
        });
        b7.setBounds(380, 26, 60, 110);
        numbers.add(b7);

        RoundedButton b8 = new RoundedButton("8", 10);
        b8.setBackground(new Color(252, 191, 73));
        b8.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		b8.setBackground(new Color(44, 161, 60));
        	}
        });
        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int buttonValue = Integer.parseInt(b8.getText());
                if(!(no.contains(buttonValue)))no.add(buttonValue);
                b.add(b8);
                button_name.add(b8);
                
            }
        });
        b8.setBounds(439, 26, 60, 110);
        numbers.add(b8);

        RoundedButton b9 = new RoundedButton("9", 10);
        b9.setBackground(new Color(252, 191, 73));
        b9.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		b9.setBackground(new Color(44, 161, 60));
        	}
        });
        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int buttonValue = Integer.parseInt(b9.getText());
                if(!(no.contains(buttonValue)))
                	no.add(buttonValue);
                b.add(b9);
                button_name.add(b9);
               
            }
        });
        b9.setBounds(497, 26, 60, 110);
        numbers.add(b9);

        RoundedButton b10 = new RoundedButton("10", 10);
        b10.setBackground(new Color(252, 191, 73));
        b10.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		b10.setBackground(new Color(44, 161, 60));
        	}});
        b10.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
                int buttonValue = Integer.parseInt(b10.getText());
                if(!(no.contains(buttonValue)))no.add(buttonValue);
                b.add(b10);
                button_name.add(b10);
                
                
            }
        });
        b10.setBounds(555, 26, 60, 110);
        numbers.add(b10);
        
        RoundedButton b11 = new RoundedButton("11", 10);
        b11.setBackground(new Color(252, 191, 73));
        b11.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		b11.setBackground(new Color(44, 161, 60));
        	}
        });
        b11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int buttonValue = Integer.parseInt(b11.getText());
                if(!(no.contains(buttonValue)))no.add(buttonValue);
                b.add(b11);
                button_name.add(b11);
               
            }
        });
        b11.setBounds(614, 26, 60, 110);
        numbers.add(b11);

        RoundedButton b12 = new RoundedButton("12", 10);
        b12.setBackground(new Color(252, 191, 73));
        b12.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		b12.setBackground(new Color(44, 161, 60));
        	}
        });
        b12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int buttonValue = Integer.parseInt(b12.getText());
                if(!(no.contains(buttonValue)))no.add(buttonValue);
                b.add(b12);
                button_name.add(b12);
                
            }
        });
        b12.setBounds(673, 26, 60, 110);
        numbers.add(b12);

        JPanel button_panel = new JPanel();
        button_panel.setBackground(new Color(51, 15, 10));
        button_panel.setBounds(609, 320, 242, 179);
        contentPane.add(button_panel);
        button_panel.setLayout(null);

        JPanel buttons = new JPanel();
        buttons.setBackground(new Color(154, 74, 9));
        buttons.setBounds(10, 11, 222, 157);
        button_panel.add(buttons);
        buttons.setLayout(null);

        RoundedButton submit = new RoundedButton("submit", 30);
        submit.setBackground(new Color(253, 223, 130));
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int num : no) {
                    sum += num;
                }
                rollButton.setEnabled(true);
                if(r==sum) {//System.out.println("yes");
                			for(RoundedButton a:button_name) {
                				a.setEnabled(false);
                				a.setBackground(new Color(154, 74, 9));
                			}
                			}
                else {int c=0;
                	for(RoundedButton a:b) {
                		if(!(a.isEnabled()))
                			c++;
                		//System.out.println("Score = "+c);
                	}//System.out.println("Score = "+c);
                	if (c==12)
                	JOptionPane.showMessageDialog(null, "Score : "+c+"\nYOU WON!!", "Game ", JOptionPane.PLAIN_MESSAGE);
                	else {JOptionPane.showMessageDialog(null, "Score : "+c+"\nGame Over!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                	try {Date currentDate = new Date();
                		
                    // Format the date for printing in "dd-MM" format
                    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM");
                    	String formattedDate = dateFormat.format(currentDate);

                        // Step 1: Connect to the Database
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaprj", "root", "");
                        String sql = "INSERT INTO score (name,score,date) VALUES (?, ?, ?)";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, username);
                        statement.setInt(2, c);
                        statement.setString(3, formattedDate);
                        
                        int rowsInserted = statement.executeUpdate();
                        statement.close();
                        connection.close();
                        
                    } catch (Exception d) {
                        d.printStackTrace();
                    }
                	System.exit(0);
                }
                }
            }
        });
        submit.setBounds(39, 11, 144, 52);
        buttons.add(submit);

        RoundedButton reset = new RoundedButton("reset", 30);
        reset.setBackground(new Color(253, 223, 130));
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sum=0;
                for(RoundedButton a:button_name) {
    				a.setBackground(new Color(252,191,73));
    			}button_name.clear();
    			no.clear();
    			
            }
        });
        reset.setBounds(39, 94, 144, 52);
        buttons.add(reset);

        dicePanel1 = new DicePanel();
        dicePanel2 = new DicePanel();
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(51, 15, 10));
        panel_1.setBorder(null);
        panel_1.setBounds(185, 320, 248, 179);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JPanel dice_panel = new JPanel();
        dice_panel.setBackground(new Color(154, 74, 9));
        dice_panel.setBounds(10, 11, 228, 157);
        panel_1.add(dice_panel);
        dice_panel.setLayout(null);
        
                JPanel dicePanelContainer = new JPanel();
                dicePanelContainer.setBounds(39, 11, 148, 70);
                dice_panel.add(dicePanelContainer);
                dicePanelContainer.setLayout(new GridLayout(1, 2));
                dicePanelContainer.add(dicePanel1);
                dicePanelContainer.add(dicePanel2);
                
                        rollButton = new JButton("Roll Dice");
                        rollButton.setBackground(new Color(252, 191, 73));
                        rollButton.setBounds(71, 92, 91, 43);
                        dice_panel.add(rollButton);
                        
                        JButton leader_board = new JButton("Leader Board");
                        leader_board.setBackground(new Color(253, 223, 130));
                        leader_board.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		leaderboard lb=new leaderboard(username);
                        		lb.setVisible(true);
                        	}
                        });
                        leader_board.setBounds(744, 11, 107, 23);
                        contentPane.add(leader_board);
                        
                        JButton logout = new JButton("logout");
                        logout.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		login lg = new login();
                        		dispose();
                        	}
                        });
                        logout.setBackground(new Color(253, 223, 130));
                        logout.setBounds(871, 11, 89, 23);
                        contentPane.add(logout);
                        
                        JLabel lblNewLabel = new JLabel("");
                        lblNewLabel.setIcon(new ImageIcon(JavaPrj.class.getResource("/images/a.png")));
                        lblNewLabel.setBounds(0, 0, 1063, 590);
                        contentPane.add(lblNewLabel);
                        rollButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                            	no.clear();
                            	button_name.clear();
                            	sum=0;
                                r = rollDice();
                                rollButton.setEnabled(false); 
                                //System.out.print(r);
                            }
                        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public int rollDice() {
        int r1 = dicePanel1.rollDice();
        int r2 = dicePanel2.rollDice();
        return (r1 + r2);
    }

    public static void main(String[] args,String username) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JavaPrj javaPrj = new JavaPrj(username);
                javaPrj.setVisible(true);
            }
        });
    }

    public class DicePanel extends JPanel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int diceValue;

        public int rollDice() {
            Random random = new Random();
            diceValue = random.nextInt(6) + 1;
            repaint();
            return diceValue;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawDice(g);
        }

        private void drawDice(Graphics g) {
            int x = getWidth() / 2 - 30;
            int y = getHeight() / 2 - 30;

            g.setColor(Color.WHITE);
            g.fillRect(x, y, 60, 60);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 60, 60);

            drawDiceDots(g, x, y);
        }

        private void drawDiceDots(Graphics g, int x, int y) {
            g.setColor(Color.BLACK);

            //int dotSize = 12;
            int mid = 30;

            // Draw dots based on the dice value
            switch (diceValue) {
                case 1:
                    drawDot(g, x + mid, y + mid);
                    break;
                case 2:
                    drawDot(g, x + mid - 20, y + mid + 20);
                    drawDot(g, x + mid + 20, y + mid - 20);
                    break;
                case 3:
                    drawDot(g, x + mid - 20, y + mid + 20);
                    drawDot(g, x + mid, y + mid);
                    drawDot(g, x + mid + 20, y + mid - 20);
                    break;
                case 4:
                    drawDot(g, x + mid - 20, y + mid - 20);
                    drawDot(g, x + mid + 20, y + mid - 20);
                    drawDot(g, x + mid - 20, y + mid + 20);
                    drawDot(g, x + mid + 20, y + mid + 20);
                    break;
                case 5:
                    drawDot(g, x + mid - 20, y + mid - 20);
                    drawDot(g, x + mid + 20, y + mid - 20);
                    drawDot(g, x + mid, y + mid);
                    drawDot(g, x + mid - 20, y + mid + 20);
                    drawDot(g, x + mid + 20, y + mid + 20);
                    break;
                case 6:
                    drawDot(g, x + mid - 20, y + mid - 20);
                    drawDot(g, x + mid + 20, y + mid - 20);
                    drawDot(g, x + mid - 20, y + mid);
                    drawDot(g, x + mid + 20, y + mid);
                    drawDot(g, x + mid - 20, y + mid + 20);
                    drawDot(g, x + mid + 20, y + mid + 20);
                    break;
            }
        }

        private void drawDot(Graphics g, int x, int y) {
            g.fillOval(x - 6, y - 6, 12, 12);
        }
    }
}