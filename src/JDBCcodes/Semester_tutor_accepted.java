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
import request.Document_Tutor_Accept;
import request.Semester;
import request.Semester_Tutor_Accept;

/**
 *
 * @author RAJIL KV
 */
public class Semester_tutor_accepted {

    public Semester_tutor_accepted() {
        
String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
                String uName="root";
                String uPass="";
                try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      String  query="insert into semestertutoracceptdb(BRANCH,SEMESTER,ROLLNUMBER,NAME,ADMISSIONNUMBER,YEAROFADMISSION,PARENT,ADDRESS,RESIDENCE,LIBRARY,WORKSHOP,OFFICE,DEPARTMENT,FEE) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                      String selectqry="select ROLLNUMBER from semesterdb";
                        PreparedStatement ps=con.prepareStatement(query);
                        PreparedStatement ps1=con.prepareStatement(selectqry);
                        ResultSet rs=ps1.executeQuery();
                        ps.setString(1,Semester_Tutor_Accept.branch_text);
                        ps.setString(2,Semester_Tutor_Accept.semester_text);
                        ps.setInt(3,Semester_Tutor_Accept.rollno_text);
                        ps.setString(4,Semester_Tutor_Accept.name_text);
                        ps.setInt(5,Semester_Tutor_Accept.admissionnumber_text);
                        ps.setInt(6,Semester_Tutor_Accept.year_text);
                        ps.setString(7,Semester_Tutor_Accept.parent_name_text);
                        ps.setString(8,Semester_Tutor_Accept.parent_address_text);
                        ps.setString(9,Semester_Tutor_Accept.residence_place_text);
                        ps.setInt(10,Semester_Tutor_Accept.deodues_text);
                        ps.setInt(11,Semester_Tutor_Accept.libdue_text);
                        ps.setInt(12,Semester_Tutor_Accept.officedues_text);
                        ps.setInt(13,Semester_Tutor_Accept.workshopdues_text);
                        ps.setString(14,Semester_Tutor_Accept.feecon_text);

                        
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
