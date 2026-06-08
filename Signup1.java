import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
public class Signup1 extends JFrame implements ActionListener 
{
    int random;
    String formnomain;
    JTextField nametext, fnametext, citytext, dobtext, emailtext,  pincodetext, addresstext;
    JComboBox statetext;
    JDateChooser dateChooser;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    Signup1(){
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
         random = ran.nextInt(9000) + 1000;
         formnomain=""+random;
         JLabel formno = new JLabel("<html><u>PAGE 1: APPLICATION FORM NO. " + random + "</u></html>");
         formno.setBounds(500,50,500,50);
         formno.setFont(new Font("oswar",Font.BOLD,25));
         whitePanel.add(formno);
         JLabel PersonlaD = new JLabel("Page 1: Personal Details");
         PersonlaD.setBounds(600,100,300,30);
         PersonlaD.setFont(new Font("oswar",Font.BOLD,25));
         whitePanel.add(PersonlaD);
         JLabel name = new JLabel("Name: ");
         name.setBounds(480,160,300,20);
         name.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(name);
         nametext= new JTextField();
         nametext.setBounds(680,160,300,20);
         nametext.setFont(new Font("oswar",Font.BOLD,12));
         whitePanel.add(nametext);
         JLabel fname = new JLabel("Father's Name: ");
         fname.setBounds(480,200,300,20);
         fname.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(fname);
         fnametext= new JTextField();
         fnametext.setBounds(680,200,300,20);
         fnametext.setFont(new Font("oswar",Font.BOLD,12));
         whitePanel.add(fnametext);
         JLabel dob = new JLabel("Date of Birth: ");
         dob.setBounds(480,240,300,20);
         dob.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(dob);
         dateChooser = new JDateChooser();
         dateChooser.setBounds(680,240,300,20);
         whitePanel.add(dateChooser);
         JLabel gender = new JLabel("Gender: ");
         gender.setBounds(480,280,300,20);
         gender.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(gender);
         male =new JRadioButton("Male");
         male.setBackground(Color.white);
         male.setBounds(680,280,100, 20);
         whitePanel.add(male);
         female =new JRadioButton("Female");
         female.setBackground(Color.white);
         female.setBounds(780,280,100, 20);
         whitePanel.add(female);
         other =new JRadioButton("Other");
         other.setBackground(Color.white);
         other.setBounds(890,280,100, 20);
         whitePanel.add(other);
         ButtonGroup gendergroup = new ButtonGroup();
         gendergroup.add(male);
         gendergroup.add(female);
         gendergroup.add(other);
         JLabel email = new JLabel("Email Address: ");
         email.setBounds(480,320,300,20);
         email.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(email);
         emailtext= new JTextField();
         emailtext.setBounds(680,320,300,20);
         emailtext.setFont(new Font("oswar",Font.BOLD,12));
         whitePanel.add(emailtext);
         JLabel mstatus = new JLabel("Martial Status:");
         mstatus.setBounds(480,360,300,20);
         mstatus.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(mstatus);
         married =new JRadioButton("Married");
         married.setBackground(Color.white);
         married.setBounds(680,360,100, 20);
         whitePanel.add(married);
         unmarried =new JRadioButton("Unmarried");
         unmarried.setBackground(Color.white);
         unmarried.setBounds(780,360,100, 20);
         whitePanel.add(unmarried);
         ButtonGroup marriagegroup = new ButtonGroup();
         marriagegroup.add(married);
         marriagegroup.add(unmarried);
         JLabel Address = new JLabel("Address");
         Address.setBounds(480,400,300,20);
         Address.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(Address);
         addresstext= new JTextField();
         addresstext.setBounds(680,400,300,20);
         whitePanel.add(addresstext);
         addresstext.setFont(new Font("oswar",Font.BOLD,12));
         JLabel city = new JLabel("City: ");
         city.setBounds(480,440,300,20);
         city.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(city);
         citytext= new JTextField();
         citytext.setBounds(680,440,300,20);
         citytext.setFont(new Font("oswar",Font.BOLD,12));
         whitePanel.add(citytext);
         JLabel state = new JLabel("State: ");
         state.setBounds(480,480,300,20);
         state.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(state);
         String valstate[] = {"Select State","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
         statetext= new JComboBox(valstate);
         statetext.setBounds(680,480,300,20);
         statetext.setFont(new Font("oswar",Font.BOLD,12));
         statetext.setBackground(Color.white);
         whitePanel.add(statetext);
         JLabel pincode = new JLabel("Pin Code:");
         pincode.setBounds(480,520,300,20);
         pincode.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(pincode);
         pincodetext= new JTextField();
         pincodetext.setBounds(680,520,300,20);
         pincodetext.setFont(new Font("oswar",Font.BOLD,12));
         whitePanel.add(pincodetext);
         next = new JButton("Next");
         next.setBounds(880,610,100,20);
         next.setFont(new Font("oswar",Font.BOLD,15));
         next.setBackground(Color.BLACK);
         next.setForeground(Color.WHITE);
         next.setCursor(new Cursor(Cursor.HAND_CURSOR));
         next.addActionListener(this);
         whitePanel.add(next);
         next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                next.setBackground(Color.RED);
                next.setFont(new Font("oswar",Font.BOLD,18));
            }
             public void mouseExited(java.awt.event.MouseEvent evt1) {
                next.setBackground(new Color(40, 150, 200));
                next.setFont(new Font("oswar",Font.BOLD,16));
            }
        });
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String name=nametext.getText();
        String fname=fnametext.getText();
        String dob= ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        else{
            gender="other";
        }
        String email=emailtext.getText();
        String martial=null;
        if(married.isSelected()){
            martial="Married";
        }
        else{
            martial="Unmarried";
        }
        String address=addresstext.getText();
        String city =citytext.getText();
        String state=(String)statetext.getSelectedItem();
        String pincode=pincodetext.getText();
        new Signup2(formno, name, fname, dob, gender, email, martial, address, city, state, pincode ).setVisible(true);
      
    }
    public static void main(String args[]){
        new Signup1().setVisible(true);
        }
}
   

    
