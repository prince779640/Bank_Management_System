package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    JComboBox religionBox,categoryBox,incomeBox,qualificationBox,occupationBox;
    JTextField panNo,aadharNo;
    JButton next;
    JRadioButton seniorYes,seniorNo,existingNo,existingYes;
    ButtonGroup seniorGroup,existingGroup;
    String formno;//taking Form No globally because we have to use to connect 1st databae to second page.
    
    @SuppressWarnings("empty-statement")
    SignupTwo(String formno){
        
        this.formno = formno;
        
        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 23));
        additionaldetails.setBounds(260, 20, 500, 40);
        add(additionaldetails);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(80, 100, 200, 25);
        add(religion);
        
        String valueReligion[]= {"Hindu","Muslim","Sikh","Christian","Jain","Others"};
        religionBox = new JComboBox(valueReligion);
        religionBox.setBounds(260, 100, 400, 25);
        religion.setBackground(Color.WHITE);
        add(religionBox);
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(80, 150, 200, 25);
        add(category);
        
        String valueCategory[]= {"General","OBC","ST","SC","Others"};
        categoryBox = new JComboBox(valueCategory);
        categoryBox.setBounds(260, 150, 400, 25);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(80, 200, 200, 25);
        add(income);
        
        String valueIncome[]= {"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000","more than 10,00,000"};
        incomeBox = new JComboBox(valueIncome);
        incomeBox.setBounds(260, 200, 400, 25);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);
        
        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway",Font.BOLD,20));
        educational.setBounds(80, 250, 200, 25);
        add(educational);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(80, 270, 200, 25);
        add(qualification);
        
        String valueEducation[]= {"SSC","HSC","Diploma","Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        qualificationBox = new JComboBox(valueEducation);
        qualificationBox.setBounds(260, 270, 400, 25);
        qualificationBox.setBackground(Color.WHITE);
        add(qualificationBox);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(80, 320, 200, 25);
        add(occupation);
        
        String valueOccupation[]= {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupationBox = new JComboBox(valueOccupation);
        occupationBox.setBounds(260, 320, 400, 25);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);
        
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(80, 370, 200, 25);
        add(pan);
        
        panNo = new JTextField();
        panNo.setFont(new Font("Raleway",Font.BOLD,18));
        panNo.setBounds(260, 370, 400, 25);
        add(panNo);
        
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(80, 420, 200, 25);
        add(aadhar);
        
        aadharNo = new JTextField();
        aadharNo.setFont(new Font("Raleway",Font.BOLD,18));
        aadharNo.setBounds(260, 420, 400, 25);
        add(aadharNo);
        
        JLabel seniorcitizen = new JLabel("Senior Citizen:");
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorcitizen.setBounds(80, 470, 200, 25);
        add(seniorcitizen);
        
        seniorYes = new JRadioButton("Yes");
        seniorYes.setFont(new Font("Raleway",Font.BOLD,20));
        seniorYes.setBounds(300, 470, 100, 20);
        add(seniorYes);
        
        seniorNo = new JRadioButton("No");
        seniorNo.setFont(new Font("Raleway",Font.BOLD,20));
        seniorNo.setBounds(400, 470, 100, 20);
        add(seniorNo);
        
        seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);
        
        JLabel existingaccount = new JLabel("Existing Account:");
        existingaccount.setFont(new Font("Raleway",Font.BOLD,20));
        existingaccount.setBounds(80, 520, 200, 25);
        add(existingaccount);
        
        existingYes = new JRadioButton("Yes");
        existingYes.setFont(new Font("Raleway",Font.BOLD,20));
        existingYes.setBounds(300, 520, 100, 20);
        add(existingYes);
        
        existingNo = new JRadioButton("No");
        existingNo.setFont(new Font("Raleway",Font.BOLD,20));
        existingNo.setBounds(400, 520, 100, 20);
        add(existingNo);
        
        existingGroup = new ButtonGroup();
        existingGroup.add(existingYes);
        existingGroup.add(existingNo);
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,20));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setBounds(560, 590, 100, 25);
        next.addActionListener(this);
        add(next);
        
        setTitle("Application Form No. Page 2");
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        setSize(800,750);
        setLocation(200,0);
    }
    
    public void actionPerformed(ActionEvent ae){
        String religion = (String) religionBox.getSelectedItem();//Type caste is used otherwise getSelected item was returning the object
        String category = (String) categoryBox.getSelectedItem();
        String income = (String) incomeBox.getSelectedItem();
        String qualification = (String) qualificationBox.getSelectedItem();
        String occupation = (String) occupationBox.getSelectedItem();
        String panno = panNo.getText();
        String aadharno = aadharNo.getText();
        String SeniorCitizen = null;
        String ExistingAccount = null;
        
        //validation for senior Citizen
        if(seniorGroup.getSelection() == null){
            JOptionPane.showMessageDialog(null, "Senior Citizen Field is Required.");
            return;
        }else {
            if(seniorYes.isSelected()) SeniorCitizen = "yes";
            else if(seniorNo.isSelected()) SeniorCitizen = "No";
        }
        
        //validation for existing Account
        if(existingGroup.getSelection() == null){
            JOptionPane.showMessageDialog(null, "Existing Account Field is Required.");
            return;
        }else {
            if(existingYes.isSelected()) ExistingAccount = "yes";
            else if(existingNo.isSelected()) ExistingAccount = "No";
        }
        
        try{
            if (religion.equals("")){
                JOptionPane.showMessageDialog(null, "Religion Must be selected");
            }else if (category.equals("")){
                JOptionPane.showMessageDialog(null, "Category Must be selected");
            }else if (income.equals("")){
                JOptionPane.showMessageDialog(null, "Income Must be selected");
            }else if (qualification.equals("")){
                JOptionPane.showMessageDialog(null, "qualification Must be selected");
            }else if (occupation.equals("")){
                JOptionPane.showMessageDialog(null, "occupation Must be selected");
            }else if (panno.equals("")){
                JOptionPane.showMessageDialog(null, "PAN Number is to be filled");
            }else if (!aadharno.matches("\\d{12}")){
                JOptionPane.showMessageDialog(null, "AADHAR Number is to be filled correctly");
            }
            
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+qualification+"','"+occupation+"','"+panno+"','"+aadharno+"','"+SeniorCitizen+"','"+ExistingAccount+"')";
            c.s.executeUpdate(query);
            
            //SignUp 3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    
    
    
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
