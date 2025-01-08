package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
Deposit(String pinnumber){
    this.pinnumber = pinnumber;
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 680,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 680);
        add(image);
    
    JLabel text = new JLabel("Enter the amount you want to Deposit");
    text.setFont(new Font("System",Font.BOLD,16));
    text.setForeground(Color.white);
    text.setBounds(190, 230, 400, 20);
    image.add(text);
    
    amount = new JTextField();
    amount.setFont(new Font("System",Font.BOLD,16));
    amount.setBounds(190,280,300,25);
    amount.addActionListener(this);
    image.add(amount);
    
    deposit = new JButton("Deposit ");
    deposit.setBounds(418, 366, 100, 23);
    deposit.addActionListener(this);
    image.add(deposit);
    
    back = new JButton("Back ");
    back.setBounds(418, 393, 100, 23);
    deposit.addActionListener(this);
    image.add(back);
        
    setLayout(null);
    setSize(900,680);
    setLocation(200,0);
    setVisible(true);
    getContentPane().setBackground(Color.white);
    
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number = amount.getText();//amount of transaction
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }else{
                try{
                    Conn conn = new Conn();
                    String query1="Insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
                    conn.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Rs "+ number +"Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Error "+ e.getMessage());
                }
                }
        }else if (ae.getSource()==back){
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
        }
    }
 public static void main(String[] args){
     new Deposit("");
 }
  
}
