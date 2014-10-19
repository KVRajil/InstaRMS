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
import request.Semester_Hod_Accept;
import request.Semester_Tutor_Accept;

/**
 *
 * @author RAJIL KV
 */
public class Semester_hod_accepted {

    public Semester_hod_accepted() {
            
String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
                String uName="root";
                String uPass="";
                try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      String  query="insert into semesterhodacceptdb(BRANCH,SEMESTER,ROLLNUMBER,NAME,ADMISSIONNUMBER,YEAROFADMISSION,PARENT,ADDRESS,RESIDENCE,LIBRARY,WORKSHOP,OFFICE,DEPARTMENT,FEE) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                      
                        PreparedStatement ps=con.prepareStatement(query);
                        
                        
                        ps.setString(1,Semester_Hod_Accept.branch_text);
                        ps.setString(2,Semester_Hod_Accept.semester_text);
                        ps.setInt(3,Semester_Hod_Accept.rollno_text);
                        ps.setString(4,Semester_Hod_Accept.name_text);
                        ps.setInt(5,Semester_Hod_Accept.admissionnumber_text);
                        ps.setInt(6,Semester_Hod_Accept.year_text);
                        ps.setString(7,Semester_Hod_Accept.parent_name_text);
                        ps.setString(8,Semester_Hod_Accept.parent_address_text);
                        ps.setString(9,Semester_Hod_Accept.residence_place_text);
                        ps.setInt(10,Semester_Hod_Accept.deodues_text);
                        ps.setInt(11,Semester_Hod_Accept.libdue_text);
                        ps.setInt(12,Semester_Hod_Accept.officedues_text);
                        ps.setInt(13,Semester_Hod_Accept.workshopdues_text);
                        ps.setString(14,Semester_Hod_Accept.feecon_text);

                        
                        ps.executeUpdate();
                      con.close();
                    JOptionPane.showMessageDialog(null, "Success");
                    
            }
            catch (Exception er ) {
                JOptionPane.showMessageDialog(null, "Error"); 
            er.printStackTrace();
            } 
    }
    
    
}