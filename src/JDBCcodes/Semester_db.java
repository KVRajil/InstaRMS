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
import request.Rail;
import request.Semester;
import static request.Semester.deodues_text;
import static request.Semester.feecon_text;
import static request.Semester.libdue_text;
import static request.Semester.name_text;
import static request.Semester.officedues_text;
import static request.Semester.parent_address_text;
import static request.Semester.parent_name_text;
import static request.Semester.residence_place_text;
import static request.Semester.workshopdues_text;

/**
 *
 * @author RAJIL KV
 */
public class Semester_db {
ResultSet rs=null;
    public Semester_db() {
        
   String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
                String uName="root";
                String uPass="";
                try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      String  query="insert into semesterdb(BRANCH,SEMESTER,ROLLNUMBER,NAME,ADMISSIONNUMBER,YEAROFADMISSION,PARENT,ADDRESS,RESIDENCE,LIBRARY,WORKSHOP,OFFICE,DEPARTMENT,FEE) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                      String selectqry="select ROLLNUMBER from semesterdb";
                        PreparedStatement ps=con.prepareStatement(query);
                        PreparedStatement ps1=con.prepareStatement(selectqry);
                        ResultSet rs=ps1.executeQuery();
                        ps.setString(1,Semester.branch_text);
                        ps.setString(2,Semester.semester_text);
                        ps.setInt(3,Semester.rollno_text);
                        ps.setString(4,Semester.name_text);
                        ps.setString(5,Semester.admissionnumber_text);
                        ps.setInt(6,Semester.year_text);
                        ps.setString(7,Semester.parent_name_text);
                        ps.setString(8,Semester.parent_address_text);
                        ps.setString(9,Semester.residence_place_text);
                        ps.setInt(10,Semester.deodues_text);
                        ps.setInt(11,Semester.libdue_text);
                        ps.setInt(12,Semester.officedues_text);
                        ps.setInt(13,Semester.workshopdues_text);
                        ps.setString(14,Semester.feecon_text);
                        
                      int flag=0;
                      while(rs.next())
                      {
                          int id=rs.getInt("ROLLNUMBER");
                          if(id==Semester.rollno_text) 
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
    
