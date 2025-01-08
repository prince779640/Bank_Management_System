package bank_management_system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber=pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 680,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 680);
        add(image);
        
        JLabel text = new JLabel("Please Select your Transaction");
        text.setBounds(235, 210, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit ");
        deposit.setBounds(153, 315, 150, 22);
        deposit.setForeground(Color.black);
        deposit.setFont(new Font("System",Font.BOLD,14));
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl ");
        withdrawl.setBounds(370, 315, 150, 22);
        withdrawl.setForeground(Color.black);
        withdrawl.setFont(new Font("System",Font.BOLD,14));
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fastcash ");
        fastcash.setBounds(153, 340, 150, 22);
        fastcash.setForeground(Color.black);
        fastcash.setFont(new Font("System",Font.BOLD,14));
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Ministatement ");
        ministatement.setBounds(370, 340, 150, 22);
        ministatement.setForeground(Color.black);
        ministatement.setFont(new Font("System",Font.BOLD,14));
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pinchange ");
        pinchange.setBounds(153, 365, 150, 22);
        pinchange.setForeground(Color.black);
        pinchange.setFont(new Font("System",Font.BOLD,14));
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry ");
        balanceenquiry.setBounds(370, 365, 150, 22);
        balanceenquiry.setForeground(Color.black);
        balanceenquiry.setFont(new Font("System",Font.BOLD,14));
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("Exit ");
        exit.setBounds(370, 390, 150, 22);
        exit.setForeground(Color.black);
        exit.setFont(new Font("System",Font.BOLD,14));
        exit.addActionListener(this);
        image.add(exit);
        
        
        setLayout(null);
        setSize(900,680);
        setLocation(200,4);
        setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource()== fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if(ae.getSource()==pinchange){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
            
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    
    
    
    
    public static void main(String[] args) {
        new Transaction("");
    }
}
