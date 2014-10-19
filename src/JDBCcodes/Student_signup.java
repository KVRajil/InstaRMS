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
import request.StudentLogin;

/**
 *
 * @author RAJIL KV
 */
public class Student_signup {

    public Student_signup() 
    {
        String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
        String uName="root";
        String uPass="";
        String selectqry="select userid from studentsignup"; 
        String insertqry="insert into studentsignup(userid,username,password,branch,semester) values(?,?,?,?,?)";
        PreparedStatement ps1=null;
        try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      ps1=con.prepareStatement(selectqry);
                      ResultSet rs=ps1.executeQuery();
                      int flag=1;
                      while(rs.next())
                      {
                       String id=rs.getString("userid");
                       
                       if(StudentLogin.userid_text.equals(id)) 
                       {
                           flag=0;
                            JOptionPane.showMessageDialog(null, "Already exist");
                       }
                      }
                      if(flag!=0)
                      { 
                           ps1=con.prepareStatement(insertqry);
                           ps1.setString(1,StudentLogin.userid_text);
                           ps1.setString(2,StudentLogin.username_text);
                           ps1.setString(3,StudentLogin.password_text);
                           ps1.setString(4,StudentLogin.branch_text);
                           ps1.setString(5,StudentLogin.semester_text);
                          
                        
                          ps1.executeUpdate();
                         con.close();
                         
                        JOptionPane.showMessageDialog(null, "Success");
                      }
                      
                    }
            catch (Exception er ) {
            er.printStackTrace();
            } 
    }
    
}
