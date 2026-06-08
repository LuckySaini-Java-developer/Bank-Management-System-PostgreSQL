import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.*;
import java.sql.*;
public class Withdrawal extends JFrame implements ActionListener {
    String cardnumber;
    JTextField amounttext;
    JButton withdraw, back;
    Withdrawal(String cardnumber){
        
       this.cardnumber=cardnumber;
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
        setUndecorated(true);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));    
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(320,0,900,900);
        whitePanel.add(label);
        JLabel Heading =new JLabel("Enter the amount you want to Withdraw ");
        Heading.setForeground(Color.white);
        Heading.setBounds(180, 350, 350, 30);
        Heading.setFont(new Font("oswar",Font.BOLD,15));
        label.add(Heading);
        amounttext=new JTextField();
        amounttext.setForeground(Color.black);
        amounttext.setBounds(180,400, 250, 30);
        amounttext.setFont(new Font("oswar",Font.BOLD,15));
        label.add(amounttext);
        
        
        withdraw =new JButton("wihdraw");
        withdraw.setBounds(360,490,150,25);
        withdraw.setBackground(Color.white);
        withdraw.setForeground(Color.black);
        withdraw.setFont(new Font("oswar",Font.BOLD,12));
        label.add(withdraw);
        withdraw.addActionListener(this);
        withdraw.setCursor(new Cursor(Cursor.HAND_CURSOR));
        withdraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                withdraw.setBackground(Color.RED);
            }
             public void mouseExited(java.awt.event.MouseEvent evt1) {
                withdraw.setBackground(Color.white);
            }
        });
        back =new JButton("Back");
        back.setBounds(360,525,150,25);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setFont(new Font("oswar",Font.BOLD,12));
        label.add(back);
        back.addActionListener(this);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back.setBackground(Color.RED);
            }
             public void mouseExited(java.awt.event.MouseEvent evt1) {
                back.setBackground(Color.white);
            }
        });
        setUndecorated(true);
        setVisible(true);
    }
        
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
           new Transactions(cardnumber).setVisible(true);
       }
        
        else if(ae.getSource()==withdraw){
            String amount=amounttext.getText();
           try {
    Conn conn = new Conn();
    PreparedStatement ps1 = conn.c.prepareStatement(
        "SELECT SUM(CASE WHEN type='deposit' THEN amount ELSE 0 END) - " +
        "SUM(CASE WHEN type='withdraw' THEN amount ELSE 0 END) AS balance " +
        "FROM transactions WHERE card_no = ?"
    );

    ps1.setString(1, cardnumber);
    ResultSet rs = ps1.executeQuery();

    int balance = 0;
    if(rs.next()){
        balance = rs.getInt("balance");
    }

    int amountInt = Integer.parseInt(amount);
    if(balance < amountInt){
        JOptionPane.showMessageDialog(null, "Insufficient Balance");
        return;
    }
    PreparedStatement ps2 = conn.c.prepareStatement(
        "INSERT INTO transactions(card_no, type, amount) VALUES(?, ?, ?)"
    );

    ps2.setString(1, cardnumber);
    ps2.setString(2, "withdraw");
    ps2.setInt(3, amountInt);

    ps2.executeUpdate();
PreparedStatement ps = conn.c.prepareStatement(
    "SELECT SUM(CASE WHEN type='deposit' THEN amount ELSE 0 END) - " +
    "SUM(CASE WHEN type='withdraw' THEN amount ELSE 0 END) AS balance " +
    "FROM transactions WHERE card_no = ?"
);

ps.setString(1, cardnumber);
ResultSet rs1 = ps.executeQuery();

if(rs1.next()){
    balance = rs1.getInt("balance");
}

JOptionPane.showMessageDialog(null, 
    "Please collect your cash\nCurrent Balance is " + balance
);
} catch(Exception e){
    e.printStackTrace();
}
            }
        }
    public static void main(String args[]){
    }
    }
    
