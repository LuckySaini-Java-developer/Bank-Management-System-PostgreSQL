import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JTextField cardtext, pintext;
    JButton signup, login, clear,exit;
    Login(){
         setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setBounds(0, 0, width, height);
        whitePanel.setLayout(null); 
        add(whitePanel);
        setUndecorated(true);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/bitcoin.png"));    
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(580,220,100,100);
        JLabel Heading =new JLabel("Welcome To ATM");
        Heading.setForeground(new Color(40, 150, 200));
        whitePanel.add(Heading);
        Heading.setBounds(700, 260, 330, 30);
        Heading.setFont(new Font("oswar",Font.BOLD,30));
        whitePanel.add(label);
        JLabel cardno =new JLabel("Card no.");
        cardno.setBounds(600, 340, 230, 30);
        cardno.setFont(new Font("oswar",Font.BOLD,20));
        cardno.setForeground(new Color(40, 150, 200));
        whitePanel.add(cardno);
        JLabel pin =new JLabel("PIN");
        pin.setBounds(600, 390, 230, 30);
        pin.setFont(new Font("oswar",Font.BOLD,20));
        pin.setForeground(new Color(40, 150, 200));
        whitePanel.add(pin);
        cardtext=new JTextField();
        cardtext.setFont(new Font("oswar",Font.BOLD,16));
        add(cardtext);
        cardtext.setBounds(800,340,160,30);
        pintext=new JPasswordField();
        add(pintext);
        pintext.setBounds(800,390,160,30);
        signup=new JButton("Signup");
        signup.setBounds(650, 455, 100, 30);
        signup.setBackground(new Color(40, 150, 200));
        signup.setForeground(Color.white);
        signup.setFont(new Font("oswar",Font.BOLD,16));
        signup.addActionListener(this);
        signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signup.setBackground(Color.RED);
                signup.setFont(new Font("oswar",Font.BOLD,18));
            }
             public void mouseExited(java.awt.event.MouseEvent evt1) {
                signup.setBackground(new Color(40, 150, 200));
                signup.setFont(new Font("oswar",Font.BOLD,16));
            }
        });
        whitePanel.add(signup);
        clear=new JButton("Clear");
        clear.setBounds(790, 455, 100, 30);
        clear.setBackground(new Color(40, 150, 200));
        clear.setForeground(Color.white);
        clear.setFont(new Font("oswar",Font.BOLD,16));
        clear.addActionListener(this);
        clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clear.setBackground(Color.RED);
                clear.setFont(new Font("oswar",Font.BOLD,18));
            }
             public void mouseExited(java.awt.event.MouseEvent evt1) {
                clear.setBackground(new Color(40, 150, 200));
                clear.setFont(new Font("oswar",Font.BOLD,16));
            }
        });
        whitePanel.add(clear);
        login=new JButton("Login");
        login.setBounds(650,520, 240, 30);
        login.setBackground(new Color(40, 150, 200));
        login.setForeground(Color.white);
        login.setFont(new Font("oswar",Font.BOLD,16));
        login.addActionListener(this);
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login.setBackground(Color.RED);
                login.setFont(new Font("oswar",Font.BOLD,18));

            }
             public void mouseExited(java.awt.event.MouseEvent evt1) {
                login.setBackground(new Color(40, 150, 200));
                login.setFont(new Font("oswar",Font.BOLD,16));
            }
        });
         whitePanel.add(login);
         whitePanel.add(clear);
        exit=new JButton("Exit");
        exit.setBounds(650,600, 240, 30);
        exit.setBackground(new Color(40, 150, 200));
        exit.setForeground(Color.white);
        exit.setFont(new Font("oswar",Font.BOLD,16));
        exit.addActionListener(this);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit.setBackground(Color.RED);
                exit.setFont(new Font("oswar",Font.BOLD,18));

            }
             public void mouseExited(java.awt.event.MouseEvent evt1) {
                exit.setBackground(new Color(40, 150, 200));
                exit.setFont(new Font("oswar",Font.BOLD,16));
            }
        });
        whitePanel.add(exit);
        JLabel AlreadyR=new JLabel("<html><u>Already registered customer?</u></html>");
        AlreadyR.setBounds(685, 550, 220,30);
        AlreadyR.setForeground(Color.red);
        AlreadyR.setFont(new Font("oswar",Font.ITALIC,12));
        whitePanel.add(AlreadyR);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardtext.setText("");
            pintext.setText("");
        }
        else if(ae.getSource()==login){
            Conn conn =new Conn();
            String cardnumber = cardtext.getText();
            String pinnumber = pintext.getText();
            String query = "select * from users where card_no='"+cardnumber+"' and pin='"+pinnumber+"'";
            try{
            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Transactions(cardnumber).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
            }
        }
            catch(Exception e){
               e.printStackTrace();
                
            }
            }
        else if(ae.getSource()==signup){
        
            new Signup1().setVisible(true);
        }
        else if(ae.getSource()==exit){
           System.exit(0);
        }
        }
    public static void main(String args[]){
        new Login();
    }
    }
    
