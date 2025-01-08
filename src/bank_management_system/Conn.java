package bank_management_system;
import java.sql.*;
public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try{
            // now no need to write this because we have imported a libraby mysql Connecter Class.forName(com.mysql.cj.jdbc.Driver);Step 1 Registering Driver
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Maverik@99");//Step 2 Creating Connection  1. Default localhost:3306 no need to write for that
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
        
    }
}
