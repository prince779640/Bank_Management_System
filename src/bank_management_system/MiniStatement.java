package bank_management_system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        JLabel text = new JLabel();
        add(text);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        JLabel mini = new JLabel("Indian Bank");
        mini.setBounds(20, 140, 400, 200);
        add(mini);
        
        JLabel card = new JLabel("Indian Bank");
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        
        //First Hit
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
             while(rs.next()){
                 card.setText("Card Number:"+ rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
             }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 320, 20);
        add(balance);
        
        
        //second HIT
        try {
            Conn c = new Conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs.next()){
                //we can use HTML tag in JAVA directly
                mini.setText(mini.getText()+ "<html>" + rs.getString(pinnumber) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br></html>");
                if (rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs "+bal);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        
        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(200,0);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
        
    }
    
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
