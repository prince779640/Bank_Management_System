package bank_management_system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton savingRadioButton,currentRadioButton,fixedDepositRadioButton,recurringDepositRadioButton;
    ButtonGroup accountype;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
   
  SignupThree(String formno){
      this.formno = formno;
      setLayout(null);
      
      JLabel l1 = new JLabel("Page 3: Account Details");
      l1.setFont(new Font("Raleway",Font.BOLD,24));
      l1.setBounds(290, 0, 400, 40);
      add(l1);
      
      JLabel accountType = new JLabel("Account Type");
      accountType.setFont(new Font("Raleway",Font.BOLD,22));
      accountType.setBounds(120,60, 300, 30);
      add(accountType);
      
      savingRadioButton = new JRadioButton("Saving Account");
      savingRadioButton.setFont(new Font("Raleway",Font.BOLD,18));
      savingRadioButton.setBounds(110, 100, 200, 30);
      savingRadioButton.setBackground(Color.white);
      add(savingRadioButton);
      
      fixedDepositRadioButton = new JRadioButton("Fixed Deposit Account");
      fixedDepositRadioButton.setFont(new Font("Raleway",Font.BOLD,18));
      fixedDepositRadioButton.setBounds(350, 100, 300, 30);
      fixedDepositRadioButton.setBackground(Color.white);
      add(fixedDepositRadioButton);
      
      currentRadioButton = new JRadioButton("Current Account");
      currentRadioButton.setFont(new Font("Raleway",Font.BOLD,18));
      currentRadioButton.setBounds(110, 130,200, 30);
      currentRadioButton.setBackground(Color.white);
      add(currentRadioButton);
      
      recurringDepositRadioButton = new JRadioButton("Recurring Deposit Account");
      recurringDepositRadioButton.setFont(new Font("Raleway",Font.BOLD,18));
      recurringDepositRadioButton.setBounds(350, 130, 300, 30);
      recurringDepositRadioButton.setBackground(Color.white);
      add(recurringDepositRadioButton);
      
      accountype = new ButtonGroup();
      accountype.add(savingRadioButton);
      accountype.add(fixedDepositRadioButton);
      accountype.add(currentRadioButton);
      accountype.add(recurringDepositRadioButton);
      
      
      //It's a dummy card number..
      JLabel cardNumber = new JLabel("Card Number");
      cardNumber.setFont(new Font("Raleway",Font.BOLD,22));
      cardNumber.setBounds(120,200, 300, 30);
      add(cardNumber);
      
      JLabel cardNumberExample = new JLabel("XXXX-XXXX-XXXX-2495");
      cardNumberExample.setFont(new Font("Raleway",Font.BOLD,22));
      cardNumberExample.setBounds(400,200, 300, 30);
      add(cardNumberExample);
      
      JLabel digit16 = new JLabel("Your 16 Digit Card Number");
      digit16.setFont(new Font("Raleway",Font.BOLD,16));
      digit16.setBounds(120,230, 300, 30);
      add(digit16);
      
      JLabel cardpin = new JLabel("PIN:");
      cardpin.setFont(new Font("Raleway",Font.BOLD,22));
      cardpin.setBounds(120,300, 300, 30);
      add(cardpin);
      
      JLabel cardPinExample = new JLabel("XXXX");
      cardPinExample.setFont(new Font("Raleway",Font.BOLD,22));
      cardPinExample.setBounds(400,300, 300, 30);
      add(cardPinExample);
      
      JLabel pass4 = new JLabel("Your 4 Digit Password");
      pass4.setFont(new Font("Raleway",Font.BOLD,16));
      pass4.setBounds(120,330, 300, 30);
      add(pass4);
      
      JLabel serviceRequired = new JLabel("Service Required:");
      serviceRequired.setFont(new Font("Raleway",Font.BOLD,22));
      serviceRequired.setBounds(120,400, 300, 30);
      add(serviceRequired);
      
      c1 = new JCheckBox("ATM CARD");
      c1.setBackground(Color.white);
      c1.setFont(new Font("Raleway",Font.BOLD,18));
      c1.setBounds(110, 440, 200, 20);
      add(c1);
      
      c2 = new JCheckBox("Internet Banking");
      c2.setBackground(Color.white);
      c2.setFont(new Font("Raleway",Font.BOLD,18));
      c2.setBounds(350, 440, 200, 20);
      add(c2);
      
      c3 = new JCheckBox("Mobile Banking");
      c3.setBackground(Color.white);
      c3.setFont(new Font("Raleway",Font.BOLD,18));
      c3.setBounds(110, 480, 200, 20);
      add(c3);
      
      c4 = new JCheckBox("Email & SMS Alerts");
      c4.setBackground(Color.white);
      c4.setFont(new Font("Raleway",Font.BOLD,18));
      c4.setBounds(350, 480, 200, 20);
      add(c4);
      
      c5 = new JCheckBox("Cheque Book");
      c5.setBackground(Color.white);
      c5.setFont(new Font("Raleway",Font.BOLD,18));
      c5.setBounds(110, 520, 200, 20);
      add(c5);
      
      c6 = new JCheckBox("E-Statement");
      c6.setBackground(Color.white);
      c6.setFont(new Font("Raleway",Font.BOLD,18));
      c6.setBounds(350, 520, 200, 20);
      add(c6);
      
      //hereby chechbox
      c7 = new JCheckBox("I Hereby declares that the above entered details are correct.");
      c7.setBackground(Color.white);
      c7.setFont(new Font("Raleway",Font.BOLD,18));
      c7.setBounds(110, 570, 550, 20);
      add(c7);
      
      submit = new JButton("SUBMIT");
      submit.setFont(new Font("Raleway",Font.BOLD,18));
      submit.setBounds(290, 610, 120, 30);
      submit.setBackground(Color.black);
      submit.setForeground(Color.white);
      submit.addActionListener(this);
      add(submit);
      
      cancel = new JButton("CANCEL");
      cancel.setFont(new Font("Raleway",Font.BOLD,18));
      cancel.setBounds(450, 610, 120, 30);
      cancel.setBackground(Color.black);
      cancel.setForeground(Color.white);
      cancel.addActionListener(this);
      add(cancel);
      
      
      setSize(850,820);
      setVisible(true);
      setLocation(200,0);
      setTitle("Application Form No. Page 3");
      getContentPane().setBackground(Color.white);
      
      
  }
  
  public void actionPerformed(ActionEvent ae){
      if(ae.getSource()== submit){
          String AccountType = null;
          
          
          if(accountype.getSelection()==null){
              JOptionPane.showMessageDialog(null, "Account type is required.");
              return;
          }else {
              if(savingRadioButton.isSelected()) AccountType = "Saving Account";
              else if(currentRadioButton.isSelected()) AccountType = "Current Account";
              else if(fixedDepositRadioButton.isSelected()) AccountType = "Fixed Deposit Account";
              else if(recurringDepositRadioButton.isSelected()) AccountType = "Recurring Deposit Account";
          }
          
          //16 digit card number
           Random random = new Random();
           String cardnumber ="" + Math.abs((random.nextLong() % 90000000L) + 5920101000000000L);
           
           String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
           
           String service = "";
           if (c1.isSelected()){
               service = service + " ATM Card";
           }else if(c2.isSelected()){
               service = service + " Internet Banking";
           }else if(c3.isSelected()){
               service = service + " Mobile Banking";
           }else if(c4.isSelected()){
               service = service + " EMAIL & SMS Alerts";
           }else if(c5.isSelected()){
               service = service + " Cheque Book";
           }else if(c6.isSelected()){
               service = service + " E-Statement";
           }
           
           if (!c7.isSelected()) {
            JOptionPane.showMessageDialog(null, "You must agree to the declaration to proceed.");
            return;
            }

           
           try{
               Conn conn = new Conn();
               String query1 = "insert into signupthree values('"+formno+"','"+AccountType+"','"+cardnumber+"','"+pinnumber+"','"+service+"')";
               String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
               conn.s.executeUpdate(query1);
               conn.s.executeUpdate(query2);
               
               JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pinnumber);
               setVisible(false);
               new Deposit(pinnumber).setVisible(true);
           }catch (Exception e){
               JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
           }
      }else if(ae.getSource()==cancel){
          setVisible(false);
          new Login().setVisible(true);
      }
  }
    
  public static void main(String[] args){
      new SignupThree("");
  }
}
