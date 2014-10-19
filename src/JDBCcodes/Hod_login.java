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
import request.Student_Choice;
import request.Hod;
import request.Hod_Choice;


/**
 *
 * @author RAJIL KV
 */
public class Hod_login {
    public static String branch_text;
    public Hod_login() 
    {
         String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
        String uName="root";
        String uPass="";
        String selectqry="select username,password,branch from hodsignup"; 
        PreparedStatement ps1=null;
        try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      ps1=con.prepareStatement(selectqry);
                      ResultSet rs=ps1.executeQuery();
                      int flag=0;
                      while(rs.next())
                      {
                          String uname=rs.getString("username");
                          String pword=rs.getString("password");
                          
                       
                        if(uname.equals(Hod.login_username_text)&&pword.equals(Hod.login_password_text)) 
                        {
                            flag=1;
                            branch_text=rs.getString("branch");
                            new Hod_Choice();
                          
                        }
                        
                         
                      }
                      if(flag==0)
                        {
                            JOptionPane.showMessageDialog(null, "invalid username or password");
                            new Hod();
                        }
                       
                      con.close();      
                      
                   }
            catch (Exception er ) {
            er.printStackTrace();
            } 
    }
    
    
}
