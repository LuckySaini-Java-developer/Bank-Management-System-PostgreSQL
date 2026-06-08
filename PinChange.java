import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.*;
import java.sql.*;
public class PinChange extends JFrame implements ActionListener {
    String cardnumber;
    JTextField  pintext;
    JButton confirm, back;
    PinChange(String cardnumber){
        
       this.cardnumber=cardnumber;
       setLayout(null);
        // setLayout(null);
      //  JFrame frame = new JFrame();
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
        JLabel Heading =new JLabel("Set New PIN: ");
        Heading.setForeground(Color.white);
        Heading.setBounds(180, 350, 350, 30);
        Heading.setFont(new Font("oswar",Font.BOLD,15));
        label.add(Heading);
        pintext=new JTextField();
        pintext.setForeground(Color.black);
        pintext.setBounds(310,350, 150, 30);
        pintext.setFont(new Font("oswar",Font.BOLD,15));
        label.add(pintext);
        
        confirm=new JButton("Confirm");
        confirm.setBounds(360,490,150,25);
        confirm.setBackground(Color.white);
        confirm.setForeground(Color.black);
        confirm.setFont(new Font("oswar",Font.BOLD,12));
        label.add(confirm);
        confirm.addActionListener(this);
        confirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirm.setBackground(Color.RED);
            }
             public void mouseExited(java.awt.event.MouseEvent evt1) {
                confirm.setBackground(Color.white);
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }
        
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
           new Transactions(cardnumber).setVisible(true);
       }
        
        else if(ae.getSource()==confirm){
            String amount=pintext.getText();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please Set New PIN");
            }
            else{
               try{ 
                   String newpin = pintext.getText();
                    Conn conn =new Conn();
                 String query1 = "UPDATE users SET pin='"+newpin+"' WHERE card_no='"+cardnumber+"'";
                    conn.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"PIN Changeed  Succesfully");
                    new Transactions(cardnumber).setVisible(true);
               }
               catch(Exception e){
                   e.printStackTrace();
               }
            }
        }}
    public static void main(String args[]){
        new PinChange("");
    }
    }
    
