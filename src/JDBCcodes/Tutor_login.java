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
import request.Tutor;
import static request.Tutor.login_password_text;
import static request.Tutor.login_username_text;
import request.Tutor_Choice;

/**
 *
 * @author RAJIL KV
 */
public class Tutor_login {
    public static String branch_text;
    public static String semester_text;
    public Tutor_login() 
    {
        String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
        String uName="root";
        String uPass="";
        String selectqry="select username,password,semester,branch from tutorsignup"; 
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
                           
                          
                       
                        if(uname.equals(Tutor.login_username_text)&&pword.equals(Tutor.login_password_text)) 
                        {
                            branch_text=rs.getString("branch");
                           semester_text=rs.getString("semester");
                            flag=1;
                            new Tutor_Choice();
                          
                        }
                        
                         
                      }
                      if(flag==0)
                        {
                            JOptionPane.showMessageDialog(null, "invalid username or password");
                            new Tutor();
                        }
                       
                      con.close();      
                      
                   }
            catch (Exception er ) {
            er.printStackTrace();
            } 
    }
    
}
