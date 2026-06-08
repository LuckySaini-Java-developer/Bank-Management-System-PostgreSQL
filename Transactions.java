import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
public class Transactions extends JFrame implements ActionListener {
    String cardnumber;
    JTextField pintext;
    JButton deposit,  pinchange, cashwithdrawal, ministatement,  exit;
    Transactions(String cardnumber){
        
        this.cardnumber=cardnumber;
       setLayout(null);
        setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize(width, height);
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setBounds(0, 0, width, height);
        whitePanel.setLayout(null); 
        add(whitePanel);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));    
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(320,0,900,900);
        whitePanel.add(label);
        JLabel Heading =new JLabel("Please Select Your Transaction");
        Heading.setForeground(Color.white);
        Heading.setBounds(180, 350, 350, 30);
        Heading.setFont(new Font("oswar",Font.BOLD,20));
        label.add(Heading);
        deposit =new JButton("Deposit");
        deposit.setBounds(160,416,150,25);
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.black);
        deposit.setFont(new Font("oswar",Font.BOLD,12));
        label.add(deposit);
        deposit.addActionListener(this);
        deposit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deposit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deposit.setBackground(Color.RED);
            }
             public void mouseExited(java.awt.event.MouseEvent evt1) {
                deposit.setBackground(Color.white);
            }
        });
        cashwithdrawal =new JButton("Cash Withdrawal");
        cashwithdrawal.setBounds(360,416,150,25);
        cashwithdrawal.setBackground(Color.white);
        cashwithdrawal.setForeground(Color.black);
        cashwithdrawal.setFont(new Font("oswar",Font.BOLD,12));
        label.add(cashwithdrawal);
        cashwithdrawal.addActionListener(this);
        cashwithdrawal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cashwithdrawal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cashwithdrawal.setBackground(Color.RED);
            }
             public void mouseExited(java.awt.event.MouseEvent evt1) {
                cashwithdrawal.setBackground(Color.white);
            }
        });
        
       
        
        pinchange =new JButton("Pin Change");
        pinchange.setBounds(160,455,150,25);
        pinchange.setBackground(Color.white);
        pinchange.setForeground(Color.black);
        pinchange.setFont(new Font("oswar",Font.BOLD,12));
        label.add(pinchange);
        pinchange.addActionListener(this);
        pinchange.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pinchange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pinchange.setBackground(Color.RED);
            }
             public void mouseExited(java.awt.event.MouseEvent evt1) {
                pinchange.setBackground(Color.white);
            }
        });
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(360,455,150,25);
        ministatement.setBackground(Color.white);
        ministatement.setForeground(Color.black);
        ministatement.setFont(new Font("oswar",Font.BOLD,12));
        label.add(ministatement);
        ministatement.addActionListener(this);  // ❗ missing
        ministatement.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ministatement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ministatement.setBackground(Color.RED);
            }
             public void mouseExited(java.awt.event.MouseEvent evt1) {
                ministatement.setBackground(Color.white);
            }
        });
        
  
        
        exit =new JButton("Exit");
        exit.setBounds(360,525,150,25);
        exit.setBackground(Color.white);
        exit.setForeground(Color.black);
        exit.setFont(new Font("oswar",Font.BOLD,12));
        label.add(exit);
        exit.addActionListener(this);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit.setBackground(Color.RED);
            }
             public void mouseExited(java.awt.event.MouseEvent evt1) {
                exit.setBackground(Color.white);
            }
        });
        setUndecorated(true);
        setVisible(true);
    }
        
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
           System.exit(0);
       }
       else if(ae.getSource()==deposit){
          new Deposit(cardnumber).setVisible(true);
            
        }
    
        else if(ae.getSource()==pinchange){
            new PinChange(cardnumber).setVisible(true);
        }
         else if(ae.getSource()==cashwithdrawal){
            new Withdrawal(cardnumber).setVisible(true);
        }
         else if(ae.getSource()==ministatement){
            try {
    Conn conn = new Conn();
    PreparedStatement ps1 = conn.c.prepareStatement(
        "SELECT SUM(CASE WHEN type='deposit' THEN amount ELSE 0 END) - " +
        "SUM(CASE WHEN type='withdraw' THEN amount ELSE 0 END) AS balance " +
        "FROM transactions WHERE card_no = ?"
    );

    ps1.setString(1, cardnumber);
    ResultSet rs1 = ps1.executeQuery();

    int balance = 0;
    if(rs1.next()){
        balance = rs1.getInt("balance");
    }

    String query = "SELECT * FROM transactions WHERE card_no=? ORDER BY date DESC LIMIT 5";
    PreparedStatement ps2 = conn.c.prepareStatement(query);
    ps2.setString(1, cardnumber);
     ResultSet rs2 = ps2.executeQuery();
     StringBuilder mini = new StringBuilder();
    mini.append("Current Balance: ").append(balance).append("\n\n");
    mini.append("Date        Type        Amount\n");
    mini.append("-----------------------------------\n");

    while(rs2.next()){
        String date = rs2.getString("date");
        String type = rs2.getString("type");
        int amount = rs2.getInt("amount");

        mini.append(date)
            .append("   ")
            .append(type)
            .append("   ")
            .append(amount)
            .append("\n");
    }

    JOptionPane.showMessageDialog(null, mini.toString());

} catch(Exception e){
    e.printStackTrace();
}}
        }
    public static void main(String args[]){
        new Transactions("");
    }
    }
    
