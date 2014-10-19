/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JDBCcodes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import request.Document_Tutor_Accept;

/**
 *
 * @author RAJIL KV
 */
public class Document_tutor_accepted {

    public Document_tutor_accepted() {
        
    String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
                String uName="root";
                String uPass="";
                try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      String  query="insert into documenttutoracceptdb(ID,NAME,SEX,DOB,BRANCH,SEMESTER,DOCTYPE) values(?,?,?,?,?,?,?)";

                        PreparedStatement ps=con.prepareStatement(query);
                        ps.setInt(1,Document_Tutor_Accept.studentid);
                        ps.setString(2,Document_Tutor_Accept.student_name);
                        ps.setString(3,Document_Tutor_Accept.gender_text);
                        java.sql.Date dob = new java.sql.Date((Document_Tutor_Accept.date).getTime());
                        ps.setDate(4,dob);
                        
                        ps.setString(5,Document_Tutor_Accept.branch_text);
                        ps.setString(6,Document_Tutor_Accept.semester_text);
                        ps.setString(7,Document_Tutor_Accept.document_type);
                        
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

