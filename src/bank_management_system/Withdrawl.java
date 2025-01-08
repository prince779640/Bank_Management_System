package bank_management_system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900, 680, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0, 0, 900, 680);
            add(image);
            
        JLabel text = new JLabel("Enter the amount you want to Withdraw.");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        text.setBounds(190, 230, 400, 20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("System",Font.BOLD,16));
        amount.setForeground(Color.white);
        amount.setBounds(190, 280, 300, 25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw ");
        withdraw.setBounds(418, 366, 100, 23);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Withdraw ");
        back.setBounds(418, 393, 100, 23);
        back.addActionListener(this);
        image.add(back);
        
        
        setLayout(null);
        setSize(900,680);
        setLocation(200,0);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource()==withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            } else {
                try{
                    Conn conn = new Conn();
                    String query1="insert into bank values('"+pinnumber+"','"+date+"','"+withdraw+"','"+number+"')";
                    conn.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Withdraw Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
                }
            }
            
        }
    }
    
    
    public static void main(String[] args){
        new Withdrawl("");
    }
    
}
