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
import request.Document_Hod_Accept;
import request.Document_Principal_Accept;

/**
 *
 * @author RAJIL KV
 */
public class Document_principal_accepted {

    public Document_principal_accepted() {
        
     String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
                String uName="root";
                String uPass="";
                try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      String  query="insert into documentprincipalacceptdb(ID,NAME,SEX,DOB,BRANCH,SEMESTER,DOCTYPE) values(?,?,?,?,?,?,?)";

                        PreparedStatement ps=con.prepareStatement(query);
                        ps.setInt(1,Document_Hod_Accept.studentid);
                        ps.setString(2,Document_Principal_Accept.student_name);
                        ps.setString(3,Document_Principal_Accept.gender_text);
                        java.sql.Date dob = new java.sql.Date((Document_Principal_Accept.date).getTime());
                        ps.setDate(4,dob);
                        
                        ps.setString(5,Document_Principal_Accept.branch_text);
                        ps.setString(6,Document_Principal_Accept.semester_text);
                        ps.setString(7,Document_Principal_Accept.document_type);
                        
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

