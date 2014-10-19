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
/**
 *
 * @author RAJIL KV
 */
public class Railway_db {

    public Railway_db() 
    {
        String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
                String uName="root";
                String uPass="";
                try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      String  query="insert into raildb(ID,NAME,SEX,AGE,DATE1,RFROM,RTO,BRANCH,SEMESTER) values(?,?,?,?,?,?,?,?,?)";
                      String selectqry="select id from raildb";
                      PreparedStatement ps1=con.prepareStatement(selectqry);
                        PreparedStatement ps=con.prepareStatement(query);
                        ResultSet rs=ps1.executeQuery();
                        ps.setInt(1,Rail.id_num);
                        ps.setString(2,Rail.name_text);
                        ps.setString(3,Rail.gender_text);
                        ps.setInt(4,Rail.age_num);
                        
                        java.sql.Date date1 = new java.sql.Date(Rail.date.getTime());
                        ps.setDate(5,date1);
                        ps.setString(6,Rail.from_text);
                        ps.setString(7,Rail.to_text);
                        ps.setString(8,Rail.branch_text);
                        ps.setString(9,Rail.semester_text);
                        int flag=0;
                      while(rs.next())
                      {
                          int id=rs.getInt("id");
                          if(id==Rail.id_num) 
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
