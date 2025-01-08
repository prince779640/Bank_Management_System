package bank_management_system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    JLabel text;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 680,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 680);
        add(image);
        
        back = new JButton("BACK");
        back.setFont(new Font("Raleway",Font.BOLD,12));
        back.setBounds(370, 390, 100, 22);
        back.setForeground(Color.black);
        
        image.add(back);
        
        
        int balance = 0;
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        
        back.addActionListener(this);
        
        text = new JLabel("Your Current Account Balance is Rs "+balance);
        text.setForeground(Color.white);
        text.setBounds(215,250,700,35);
        image.add(text);
        
        setLayout(null);
        setSize(900,680);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    
    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
//
//
//
//
//
//
//