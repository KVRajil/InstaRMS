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
import java.sql.Statement;
import javax.swing.JOptionPane;
import request.Documnt;
import request.Request_type;


/**
 *
 * @author RAJIL KV
 */
public class Document_db
{

    public Document_db() 
    {
                String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
                String uName="root";
                String uPass="";
                try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      String  query="insert into documentdb(ID,NAME,SEX,DOB,BRANCH,SEMESTER,DOCTYPE) values(?,?,?,?,?,?,?)";
                      String selectqry="select id from documentdb";
                      PreparedStatement ps1=con.prepareStatement(selectqry);
                      ResultSet rs=ps1.executeQuery();
                        PreparedStatement ps=con.prepareStatement(query);
                        ps.setInt(1,Documnt.studentid);
                        ps.setString(2,Documnt.student_name);
                        ps.setString(3,Documnt.gender_text);
                        java.sql.Date dob = new java.sql.Date((Documnt.date).getTime());
                        ps.setDate(4,dob);
                        
                        ps.setString(5,Documnt.branch_text);
                        ps.setString(6,Documnt.semester_text);
                        ps.setString(7,Documnt.document_type);
                        
                        int flag=0;
                      while(rs.next())
                      {
                          int id=rs.getInt("id");
                          if(id==Documnt.studentid) 
                        {
                            flag=1;
                        }
                      }
                      if(flag==0)
                      {
                        ps.executeUpdate();
                      con.close();
                     JOptionPane.showMessageDialog(null, "Success");
                      }
                      else
                      {
                         JOptionPane.showMessageDialog(null, "Already have a pending request"); 
                      }
            }
            catch (Exception er ) {
            er.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
            }      
    }
    
}
