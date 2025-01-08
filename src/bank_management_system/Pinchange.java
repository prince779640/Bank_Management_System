package bank_management_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener{
    
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    Pinchange(String pinnumber){
        
        this.pinnumber=pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 680,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 680);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(265, 210, 700, 35);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,12));
        pintext.setBounds(155, 260, 200, 25);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD,12));
        pin.setBounds(330,260,180,20);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,12));
        repintext.setBounds(155, 290, 200, 25);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD,12));
        repin.setBounds(330,290,180,20);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setFont(new Font("Raleway",Font.BOLD,12));
        change.setBounds(415, 369, 100, 19);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setFont(new Font("Raleway",Font.BOLD,12));
        back.setBounds(415, 395, 100, 19);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        setLayout(null);
        setSize(900,680);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        
        if (ae.getSource()==change){
            try{
            
            
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not matched.");
                return;
            }
        
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter  new PIN");
            }
            
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
            }
            
            Conn c = new Conn();
            //we have to update pin in every table so we need to run 3 queries
            String query1 = "update bank set pin='"+rpin+"' where pin="+pinnumber+"'";
            String query2 = "update login set pin='"+rpin+"' where pin="+pinnumber+"'";
            String query3 = "update signupthree set pin='"+rpin+"' where pin="+pinnumber+"'";
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            
            setVisible(false);
            new Transaction(rpin).setVisible(true);
            
            }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            }
            
        }else {
                setVisible(false);
                new Transaction(pinnumber).setVisible(false);
            }
        }
    
    public static void main(String[] args) {
        new Pinchange("").setVisible(true);
    }
    
}
