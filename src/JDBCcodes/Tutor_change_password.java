/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JDBCcodes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import request.Tutor;
import request.Tutor_Choice;

/**
 *
 * @author RAJIL KV
 */
public class Tutor_change_password {

    public Tutor_change_password() 
    {
        String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
        String uName="root";
        String uPass="";
        String updateqry="update tutorsignup set password=?"+"where username=? and password=?"; 
        
        PreparedStatement ps1=null;
        try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      ps1=con.prepareStatement(updateqry);
                      
                           
                           ps1.setString(1,Tutor_Choice.newpassword_text);
                           ps1.setString(2,Tutor_Choice.username_text);
                           ps1.setString(3,Tutor_Choice.password_text);
                           
                           
                          
                        
                          ps1.executeUpdate();
                         con.close();
                         String username=Tutor.login_username_text;
                         String pass=Tutor.login_password_text;
                       if(username.equals(Tutor_Choice.username_text)&&pass.equals(Tutor_Choice.password_text))
                       {
                        JOptionPane.showMessageDialog(null, "Success");
                       }
                       else
                       {
                         JOptionPane.showMessageDialog(null, "Error");  
                       }
                      
                    }
            catch (Exception er ) {
            er.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
            } 
    }
    
}
 

    
    

