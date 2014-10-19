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
import request.Rail;
import request.Student_Choice;
import request.StudentLogin;
import static request.Tutor.login_password_text;

/**
 *
 * @author RAJIL KV
 */
public class Student_login {
    public static String vbranch_text;
    public static String vsemester_text;
    public static int vid_num;
    public Student_login()
    {
         String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
        String uName="root";
        String uPass="";
        String selectqry="select username,password,semester,branch,userid from studentsignup"; 
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
                       
                        if(uname.equals(StudentLogin.login_username_text)&&pword.equals(StudentLogin.login_password_text)) 
                        {
                            flag=1;
                            vbranch_text=rs.getString("branch");
                            vsemester_text=rs.getString("semester");
                            vid_num=rs.getInt("userid");
                            new Student_Choice();
                          
                        }
                        
                         
                      }
                      if(flag==0)
                        {
                            JOptionPane.showMessageDialog(null, "invalid username or password");
                            new StudentLogin();
                        }
                       
                      con.close();      
                      
                   }
            catch (Exception er ) {
            er.printStackTrace();
            } 
    }
    
}
