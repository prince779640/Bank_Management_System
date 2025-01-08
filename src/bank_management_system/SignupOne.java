package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male,female,otherGender,married,unmarried,marriedOther;
    JDateChooser dateChooser;
    ButtonGroup maritalgroup,gendergroup;
    
    SignupOne(){
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L + 1000L);
        
        JLabel formno = new JLabel("Application Form No. Page 2"+ random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 700, 40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400 ,30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400 ,30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100, 290, 100, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        otherGender = new JRadioButton("Others");
        otherGender.setBounds(610, 290, 120, 30);
        otherGender.setBackground(Color.WHITE);
        add(otherGender);
        
        gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(otherGender);
        
        JLabel email = new JLabel("E-Mail Id:");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100, 340, 100, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400 ,30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100, 390, 100, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        marriedOther = new JRadioButton("Others");
        marriedOther.setBounds(610, 390, 100, 30);
        marriedOther.setBackground(Color.WHITE);
        add(marriedOther);
        
        maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(marriedOther);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100, 440, 100, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400 ,30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100, 490, 100, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400 ,30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100, 540, 100, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400 ,30);
        add(stateTextField);
        
        JLabel pinCode = new JLabel("Pin Code:");
        pinCode.setFont(new Font("Raleway", Font.BOLD,20));
        pinCode.setBounds(100, 590, 100, 30);
        add(pinCode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400 ,30);
        add(pinTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(620,630,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        
        setSize(800,750);
        setLocation(200,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random; //Since it is a long number so convert string into long
        String name = nameTextField.getText();//
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        
        //validation and selection for gender radio button
        if (gendergroup.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Gender is Required");
            return;
        } else {
            if (male.isSelected()) gender = "Male";
            else if (female.isSelected()) gender = "Female";
            else if (otherGender.isSelected()) gender = "Others";
        }
        
        String email = emailTextField.getText();
        String marital = null;
        
        
        //validation and selection for Marital radio button
        if (maritalgroup.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Marital Status is Required");
            return;
        } else {
            if (married.isSelected()) marital = "Married";
            else if (unmarried.isSelected()) marital = "Unmarried";
            else if (marriedOther.isSelected()) marital = "Others";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            } else if (fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father's Name is Required");
            }else if (dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date Of Birth is Required");
            }else if (email.equals("")){
                JOptionPane.showMessageDialog(null,"E-mail is Required");
            }else if (address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is Required");
            }else if (city.equals("")){
                JOptionPane.showMessageDialog(null,"City is Required");
            }else if (state.equals("")){
                JOptionPane.showMessageDialog(null,"State is Required");
            }else if (!pin.matches("\\d{6}")) {
                JOptionPane.showMessageDialog(null, "Invalid Pin Code. It must be 6 digits.");
                return;
            }else{
                Conn c = new Conn();
                String query = "insert into signupone values ('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
                setVisible(false);//for closing current frame.
                new SignupTwo(formno).setVisible(true);//passing current application for page two of application
                
            }
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());//improved handling my return message
        }
    }
    public static void main (String[] args){
        new SignupOne();
    }
}
