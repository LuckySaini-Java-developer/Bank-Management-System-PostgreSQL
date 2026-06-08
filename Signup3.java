import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
public class Signup3 extends JFrame implements ActionListener 
{
    long cardNumber;
    long pinnotext;
    JButton submit,cancel;
    JRadioButton savingA, fixedA, currentA, recurringA;
    JCheckBox atm, mobile, cheque, internet, emailS, estate, declaration;
    String formno, name, fname,  dob, gender, email, martial, address, city, state, pincode,religion, category, income, education, occupation, pan, adhar, senior, existingA;
    Signup3(String formno, String name, String fname, String dob, String gender, String email, String martial, String address, String city, String state, String pincode, String religion, String category, String income, String education, String occupation, String pan, String adhar, String senior, String existingA){
         this.formno=formno;
         this.name=name;
         this.fname=fname;
         this.dob=dob;
         this.gender=gender;
         this.email=email;
         this.martial=martial;
         this.address=address;
         this.city=city;
         this.state=state;
         this.pincode=pincode;
         this.religion=religion;
         this.category=category;
         this.income=income;
         this.education=education;
         this.occupation=occupation;
         this.pan=pan;
         this.adhar=adhar;
         this.senior=senior;
         this.existingA=existingA;
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
        Random ran = new Random();
         cardNumber = (long)(Math.random() * 9000000000000000L) + 1000000000000000L;
         pinnotext = ran.nextLong(9000L) + 1000L;
         long tempcardno=cardNumber%10000;
         JLabel PersonlaD = new JLabel("Page 3: Account Details #"+formno);
         PersonlaD.setBounds(500,50,500,50);
         PersonlaD.setFont(new Font("oswar",Font.BOLD,28));
         whitePanel.add(PersonlaD);
         JLabel accounttype = new JLabel("Account type ");
         accounttype.setBounds(550,100,300,32);
         accounttype.setFont(new Font("oswar",Font.BOLD,25));
         whitePanel.add(accounttype);
         savingA =new JRadioButton("Saving Account");
         savingA.setBackground(Color.white);
         savingA.setBounds(600,140,200,30);
         whitePanel.add(savingA);
         currentA =new JRadioButton("Current Account");
         currentA.setBackground(Color.white);
         currentA.setBounds(600,180,200,30);
         whitePanel.add(currentA);
         fixedA =new JRadioButton("Fixed Deposit Account");
         fixedA.setBackground(Color.white);
         fixedA.setBounds(800,140,200,30);
         whitePanel.add(fixedA);
         recurringA =new JRadioButton("Recurring Deposit Account");
         recurringA.setBackground(Color.white);
         recurringA.setBounds(800,180,200,30);
         whitePanel.add(recurringA);
         ButtonGroup accounttypegroup = new ButtonGroup();
         accounttypegroup.add(savingA);
         accounttypegroup.add(currentA);
         accounttypegroup.add(fixedA);
         accounttypegroup.add(recurringA);
         System.out.println(cardNumber);
         JLabel cardno = new JLabel("Card Number ");
         cardno.setBounds(550,260,300,22);
         cardno.setFont(new Font("oswar",Font.BOLD,25));
         whitePanel.add(cardno);
         JLabel cardnotext = new JLabel("XXXX-XXXX-XXXX-"+tempcardno);
         cardnotext.setBounds(800,260,300,22);
         cardnotext.setFont(new Font("oswar",Font.BOLD,20));
         whitePanel.add(cardnotext);
         JLabel extrainfo = new JLabel("Your 16 Digit Card Number ");
         extrainfo.setBounds(570,280,300,32);
         extrainfo.setFont(new Font("oswar",Font.ITALIC,10));
         whitePanel.add(extrainfo);
         JLabel pin = new JLabel("PIN ");
         pin.setBounds(550,320,300,22);
         pin.setFont(new Font("oswar",Font.BOLD,25));
         whitePanel.add(pin);
         JLabel pintext = new JLabel("XXXX");
         pintext.setBounds(800,320,300,22);
         pintext.setFont(new Font("oswar",Font.BOLD,20));
         whitePanel.add(pintext);
         JLabel extrainfo2 = new JLabel("Your 4 Digit Password ");
         extrainfo2.setBounds(570,340,300,32);
         extrainfo2.setFont(new Font("oswar",Font.ITALIC,10));
         whitePanel.add(extrainfo2);
         JLabel servicesrequired = new JLabel("Services Required:");
         servicesrequired.setBounds(550,380,300,32);
         servicesrequired.setFont(new Font("oswar",Font.BOLD,25));
         whitePanel.add(servicesrequired);
         atm=new JCheckBox("ATM CARD");
         atm.setBackground(Color.white);
         atm.setBounds(580,420,150,30);
         atm.setFont(new Font("oswar", Font.BOLD,15));
         whitePanel.add(atm);
         mobile=new JCheckBox("Mobile Banking");
         mobile.setBackground(Color.white);
         mobile.setBounds(580,460,150,30);
         mobile.setFont(new Font("oswar", Font.BOLD,15));
        whitePanel.add(mobile);
         cheque=new JCheckBox("Cheque Book");
         cheque.setBackground(Color.white);
         cheque.setBounds(580,500,150,30);
         cheque.setFont(new Font("oswar", Font.BOLD,15));
         whitePanel.add(cheque);
         internet=new JCheckBox("Internet Banking");
         internet.setBackground(Color.white);
         internet.setBounds(750,420,150,30);
         internet.setFont(new Font("oswar", Font.BOLD,15));
         whitePanel.add(internet);
         emailS=new JCheckBox("Email & SMS Alerts");
         emailS.setBackground(Color.white);
         emailS.setBounds(750,460,250,30);
         emailS.setFont(new Font("oswar", Font.BOLD,15));
         whitePanel.add(emailS);
         estate=new JCheckBox("E-Statement");
         estate.setBackground(Color.white);
         estate.setBounds(750,500,150,30);
         estate.setFont(new Font("oswar", Font.BOLD,15));
         whitePanel.add(estate);
         declaration=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
         declaration.setBackground(Color.white);
         declaration.setBounds(550,580,550,30);
         declaration.setFont(new Font("oswar", Font.ITALIC,11));
         whitePanel.add(declaration);
         submit = new JButton("Submit");
         submit.setBounds(800,700,100,20);
         submit.setFont(new Font("oswar",Font.BOLD,12));
         submit.setBackground(Color.BLACK);
         submit.setForeground(Color.WHITE);
         submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
         submit.addActionListener(this);
         whitePanel.add(submit);
         submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submit.setBackground(Color.RED);
                submit.setFont(new Font("oswar",Font.BOLD,18));
            }
             public void mouseExited(java.awt.event.MouseEvent evt1) {
                submit.setBackground(new Color(40, 150, 200));
                submit.setFont(new Font("oswar",Font.BOLD,16));
            }
        }); 
         
         cancel = new JButton("Cancel");
        cancel.setBounds(950,700,100,20);
        cancel.setFont(new Font("oswar",Font.BOLD,15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        whitePanel.add(cancel);
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseEntered(java.awt.event.MouseEvent evt) {
        cancel.setBackground(Color.RED);
        cancel.setFont(new Font("oswar",Font.BOLD,18));
        }
        public void mouseExited(java.awt.event.MouseEvent evt1) {
        cancel.setBackground(new Color(40, 150, 200));
        cancel.setFont(new Font("oswar",Font.BOLD,16));
        }
        });
         setVisible(true);
        }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
          if(!declaration.isSelected()){
        JOptionPane.showMessageDialog(null, "Please accept declaration");
        return;
         }
          String AccountType=null;
        if(savingA.isSelected()){
            AccountType="Saving Account";
        }
        else if(currentA.isSelected()){
            AccountType="Current Account";
        }
        else if(fixedA.isSelected()){
            AccountType="Fixed Deposit Account";
        }
        else if(recurringA.isSelected()){
            AccountType="Recurring Deposit Account";
        }
        String CardNumber=""+cardNumber;
        String PinNumber=""+pinnotext;
        String facility="";
        if(atm.isSelected()){
            facility=facility+"ATM CARD     ";
        }
        if(internet.isSelected()){
            facility=facility+"Internet Banking     ";
        }
        if(mobile.isSelected()){
            facility=facility+"Mobile Banking       ";
        }
        if(emailS.isSelected()){
            facility=facility+"EMAIL & SMS Alerts       ";
        }
        if(cheque.isSelected()){
            facility=facility+"Cheque Book      ";
        }
        if(estate.isSelected()){
            facility=facility+"E-Statement      "
                    + "";
        }
        try{
            Conn c =new Conn();
            String query = "INSERT INTO users(form_no, name, card_no, pin, fname, dob, gender, email, martial, address, city, state, pincode, religion, category, income, education, occupation, pan, adhar, senior, existing_account, account_type, facility) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.c.prepareStatement(query);

ps.setString(1, formno);
ps.setString(2, name);
ps.setString(3, CardNumber);
ps.setString(4, PinNumber);

ps.setString(5, fname);
ps.setString(6, dob);
ps.setString(7, gender);
ps.setString(8, email);
ps.setString(9, martial);
ps.setString(10, address);
ps.setString(11, city);
ps.setString(12, state);
ps.setString(13, pincode);

ps.setString(14, religion);
ps.setString(15, category);
ps.setString(16, income);
ps.setString(17, education);
ps.setString(18, occupation);
ps.setString(19, pan);
ps.setString(20, adhar);
ps.setString(21, senior);
ps.setString(22, existingA);

ps.setString(23, AccountType);
ps.setString(24, facility);

ps.executeUpdate();
           JOptionPane.showMessageDialog(null, " Congratulations ! "+name+" your Accout Created successfully! \n    your  Card No is    "+cardNumber+"\n    PIN  is   "+pinnotext+"\n Please Deposit Initial amount ");
             setVisible(false);
             String tempcardNumber=""+cardNumber;
             new Deposit(tempcardNumber).setVisible(true);
        }
        
        
        catch(Exception e){
            System.out.println(e);
        }
        }
        if(ae.getSource()==cancel){
            setVisible(false);
        System.exit(0);
        }
        
        
        
}
    public static void main(String args[]){
       new Signup3("","","","","","","","","","","","","","","","","","","","");
        }

     }

   

    
