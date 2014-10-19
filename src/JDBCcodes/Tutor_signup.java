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
import request.Documnt;
import request.Tutor;

/**
 *
 * @author RAJIL KV
 */
public class Tutor_signup 
{

    public Tutor_signup() 
    {
        String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
        String uName="root";
        String uPass="";
        String selectqry="select branch,semester from tutorsignup"; 
        String insertqry="insert into tutorsignup(username,password,branch,semester) values(?,?,?,?)";
        PreparedStatement ps1=null;
        try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      ps1=con.prepareStatement(selectqry);
                      ResultSet rs=ps1.executeQuery();
                      int flag=1;
                      while(rs.next())
                      {
                       String brnch=rs.getString("branch");
                       String sem=rs.getString("semester");
                       if(Tutor.semester_text.equals(sem)&&Tutor.branch_text.equals(brnch)) 
                       {
                           flag=0;
                            JOptionPane.showMessageDialog(null, "Already exist");
                       }
                      }
                      if(flag!=0)
                      { 
                           ps1=con.prepareStatement(insertqry);
                           ps1.setString(1,Tutor.username_text);
                           ps1.setString(2,Tutor.password_text);
                           ps1.setString(3,Tutor.branch_text);
                           ps1.setString(4,Tutor.semester_text);
                          
                        
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
