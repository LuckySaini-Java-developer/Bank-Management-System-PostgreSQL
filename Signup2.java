import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class Signup2 extends JFrame implements ActionListener 
{
    JTextField  pannumbertext, adharnotext, seniortext,existingAtext;
    JButton next;
    JComboBox religiontext, categorytext, incometext, educationtext, occupationtext;
    JRadioButton yes1, no1, yes2, no2;
    String formno, name, fname,  dob, gender, email, martial, address, city, state, pincode;
    
    Signup2(String formno, String name, String fname, String dob, String gender, String email, String martial, String address, String city, String state, String pincode){
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
        JLabel PersonlaD = new JLabel("Page 2: Additional Details #"+formno);
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
         PersonlaD.setBounds(500,50,500,50);
         PersonlaD.setFont(new Font("oswar",Font.BOLD,25));
         whitePanel.add(PersonlaD);
         JLabel religion = new JLabel("Religion: ");
         religion.setBounds(480,160,300,20);
         religion.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(religion);
         String valreligion[] ={ "Select religion","Hindu", "Muslim", "Christians", "Sikh", "Other"};
         religiontext= new JComboBox(valreligion);
         religiontext.setBounds(680,160,300,20);
         religiontext.setFont(new Font("oswar",Font.BOLD,12));
         religiontext.setBackground(Color.white);
         whitePanel.add(religiontext);
         JLabel category = new JLabel("Category: ");
         category.setBounds(480,200,300,20);
         category.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(category);
         String valcategory[] ={"Select category","General", "OBC", "SC", "ST", "Other"};
         categorytext= new JComboBox(valcategory);
         categorytext.setBounds(680,200,300,20);
         categorytext.setFont(new Font("oswar",Font.BOLD,12));
         categorytext.setBackground(Color.white);
         whitePanel.add(categorytext);
         JLabel income = new JLabel("Income: ");
         income.setBounds(480,240,300,20);
         income.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(income);
         String valincome[] ={"Select income","Null", "<=150000", "<=250000", ">=500000"};
         incometext =new JComboBox(valincome);
         incometext.setBounds(680,240,300,20);
         incometext.setBackground(Color.white);
         whitePanel.add(incometext);
         JLabel education = new JLabel("<html>Educational <br> Qualifcation: </html>");
         education.setBounds(480,280,150,40);
         education.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(education);
         String valeducation[] = {"Select education","Null", "High School", "Graduate", "Post Graduate"};
         educationtext =new JComboBox(valeducation);
         educationtext.setBounds(680,280,300,20);
         educationtext.setFont(new Font("oswar",Font.BOLD,12));
         educationtext.setBackground(Color.white);
         whitePanel.add(educationtext);
         JLabel occupation = new JLabel("Occupation: ");
         occupation.setBounds(480,320,300,20);
         occupation.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(occupation);
         String valoccupation[] = { "Select occupation","Null", "Student", "Private Job", "Business","Government"};
         occupationtext= new JComboBox(valoccupation);
         occupationtext.setBounds(680,320,300,20);
         occupationtext.setFont(new Font("oswar",Font.BOLD,12));
         occupationtext.setBackground(Color.white);
         whitePanel.add(occupationtext);
         JLabel pannumber = new JLabel("PAN Number");
         pannumber.setBounds(480,360,300,20);
         pannumber.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(pannumber);
         pannumbertext= new JTextField();
         pannumbertext.setBounds(680,360,300,20);
         pannumbertext.setFont(new Font("oswar",Font.BOLD,12));
         whitePanel.add(pannumbertext);
         JLabel adharnumber = new JLabel("Aadhar Number: ");
         adharnumber.setBounds(480,400,300,20);
         adharnumber.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(adharnumber);
         adharnotext= new JTextField();
         adharnotext.setBounds(680,400,300,20);
         adharnotext.setFont(new Font("oswar",Font.BOLD,12));
         whitePanel.add(adharnotext);
         JLabel seniorc = new JLabel("Senior Citizen: ");
         seniorc.setBounds(480,440,300,20);
         seniorc.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(seniorc);
         yes1 =new JRadioButton("Yes");
         yes1.setBackground(Color.white);
         yes1.setBounds(680,440,100, 20);
         whitePanel.add(yes1);
         no1 =new JRadioButton("No");
         no1.setBackground(Color.white);
         no1.setBounds(800,440,100, 20);
         whitePanel.add(no1);
         ButtonGroup seniorcgroup = new ButtonGroup();
         seniorcgroup.add(yes1);
         seniorcgroup.add(no1);
         JLabel existinga = new JLabel("Existing Account:");
         existinga.setBounds(480,480,300,20);
         existinga.setFont(new Font("oswar",Font.BOLD,15));
         whitePanel.add(existinga);
         yes2 =new JRadioButton("Yes");
         yes2.setBackground(Color.white);
         yes2.setBounds(680,480,100, 20);
         whitePanel.add(yes2);
         no2 =new JRadioButton("No");
         no2.setBackground(Color.white);
         no2.setBounds(800,480,100, 20);
         whitePanel.add(no2);
         ButtonGroup ExistingAgroup = new ButtonGroup();
         ExistingAgroup.add(yes2);
         ExistingAgroup.add(no2);
         next = new JButton("Next");
         next.setBounds(880,550,100,20);
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
         setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String religion=(String)religiontext.getSelectedItem();
        String category=(String)categorytext.getSelectedItem();
        String income= (String)incometext.getSelectedItem();
        String education= (String)religiontext.getSelectedItem();
        String occupation=(String)occupationtext.getSelectedItem();
        String pan=pannumbertext.getText();
        String adhar=adharnotext.getText();
        String senior=null;
        if(yes1.isSelected()){
            senior="yes";
        }
        else if(no1.isSelected()){
            senior="no1";
        }
        String existingA=null;
        if(yes2.isSelected()){
            existingA="yes";
        }
        else if(no2.isSelected()){
            existingA="no";
        }
        new Signup3(formno, name, fname, dob, gender, email, martial, address, city, state, pincode, religion, category, income, education, occupation, pan, adhar, senior, existingA).setVisible(true);
       
    }
    
     public static void main(String args[]){
        }
}
   

    
