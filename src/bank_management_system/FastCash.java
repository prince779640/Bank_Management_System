package bank_management_system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton b1,b2,b3,b4,b5,b6,back;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 680,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 680);
        add(image);
        
        JLabel text = new JLabel("Select withdrawl amount");
        text.setBounds(235, 210, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        b1 = new JButton("Rs 100");
        b1.setBounds(153, 315, 150, 22);
        b1.setForeground(Color.black);
        b1.setFont(new Font("System",Font.BOLD,14));
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Rs 500");
        b2.setBounds(370, 315, 150, 22);
        b2.setForeground(Color.black);
        b2.setFont(new Font("System",Font.BOLD,14));
        b2.addActionListener(this);
        image.add(b2);
        
        b3 = new JButton("Rs 1000");
        b3.setBounds(153, 340, 150, 22);
        b3.setForeground(Color.black);
        b3.setFont(new Font("System",Font.BOLD,14));
        b3.addActionListener(this);
        image.add(b3);
        
        b4 = new JButton("Rs 2000");
        b4.setBounds(370, 340, 150, 22);
        b4.setForeground(Color.black);
        b4.setFont(new Font("System",Font.BOLD,14));
        b4.addActionListener(this);
        image.add(b4);
        
        b5 = new JButton("Rs 5000");
        b5.setBounds(153, 365, 150, 22);
        b5.setForeground(Color.black);
        b5.setFont(new Font("System",Font.BOLD,14));
        b5.addActionListener(this);
        image.add(b5);
        
        b6 = new JButton("Rs 10,000");
        b6.setBounds(370, 365, 150, 22);
        b6.setForeground(Color.black);
        b6.setFont(new Font("System",Font.BOLD,14));
        b6.addActionListener(this);
        image.add(b6);
        
        back = new JButton("Back ");
        back.setBounds(370, 390, 150, 22);
        back.setForeground(Color.black);
        back.setFont(new Font("System",Font.BOLD,14));
        back.addActionListener(this);
        image.add(back);
        
        
        setLayout(null);
        setSize(900,680);
        setLocation(200,4);
        setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } 
        //dynamic way for all button
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);//text= RS 100 to remover "RS " we have use substring
            Conn c = new Conn();
            try{
                //check balance
                //Result Set is used for to calculate result of a column
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -=Integer.parseInt(rs.getString("amount"));
                    }
                }
                
             //check amount is less or greater than the balance
             if(ae.getSource() != back && balance < Integer.parseInt("amount")){
                 JOptionPane.showMessageDialog(null, "Insufficient Balance");
                 return;
             }
             
             Date date = new Date();
             String query = "insert into bank values(,'"+pinnumber+"','"+date+"', 'withdrawl','"+amount+"')";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
            
             setVisible(false);
             new Transaction(pinnumber).setVisible(true);
             
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
            }
        }
    }
   public static void main(String[] args) {
        new FastCash("");
    }
}
