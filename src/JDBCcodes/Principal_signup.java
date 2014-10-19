/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JDBCcodes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import request.Hod;
import request.Principal;

/**
 *
 * @author RAJIL KV
 */
public class Principal_signup {

    public Principal_signup()
    {
        String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
        String uName="root";
        String uPass="";
        String selectqry="select count(*) from principalsignup"; 
        String insertqry="insert into principalsignup(username,password) values(?,?)";
        PreparedStatement ps1=null;
        try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      ps1=con.prepareStatement(selectqry);
                      ResultSet rs=ps1.executeQuery();
                      int count=0;
                      while( rs.next() ) 
                        {
                            count = rs.getInt(1);
                         }
                      
                       if(count==1) 
                       {
                           
                            JOptionPane.showMessageDialog(null, "Already exist");
                       }
                     
                      else
                      { 
                           ps1=con.prepareStatement(insertqry);
                           ps1.setString(1,Principal.username_text);
                           ps1.setString(2,Principal.password_text);
                           
                           
                          
                        
                          ps1.executeUpdate();
                         con.close();
                         
                        JOptionPane.showMessageDialog(null, "Success");
                        count=1;
                      }
                      
                    }
            catch (Exception er ) {
            er.printStackTrace();
            }
    }
    
    
}
