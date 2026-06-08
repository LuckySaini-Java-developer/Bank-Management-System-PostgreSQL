import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.*;
import java.sql.*;
public class Deposit extends JFrame implements ActionListener {
    String cardnumber;
    JTextField amounttext, pintext;
    JButton deposit, back;
    Deposit(String cardnumber){
        
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
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));    
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(320,0,900,900);
        whitePanel.add(label);
        JLabel Heading =new JLabel("Enter the amount you want to deposit");
        Heading.setForeground(Color.white);
        Heading.setBounds(180, 350, 350, 30);
        Heading.setFont(new Font("oswar",Font.BOLD,15));
        label.add(Heading);
        amounttext=new JTextField();
        amounttext.setForeground(Color.black);
        amounttext.setBounds(180,400, 250, 30);
        amounttext.setFont(new Font("oswar",Font.BOLD,15));
        label.add(amounttext);
        deposit =new JButton("Deposit");
        deposit.setBounds(360,490,150,25);
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
        
        else if(ae.getSource()==deposit){
            String amount=amounttext.getText();
           try {
    Conn conn = new Conn();

    String query = "INSERT INTO transactions(card_no, type, amount) VALUES(?, ?, ?)";

    PreparedStatement ps = conn.c.prepareStatement(query);

    ps.setString(1, cardnumber);    
    ps.setString(2, "deposit");      
    ps.setInt(3, Integer.parseInt(amount)); 

    ps.executeUpdate();

    JOptionPane.showMessageDialog(null, "Amount Deposited Successfully");

} catch(Exception e) {
    e.printStackTrace();
}
            }
        }
    public static void main(String args[]){
      
    }
    }
    
