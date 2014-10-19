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
import request.Semester_Tutor_Accept;

/**
 *
 * @author RAJIL KV
 */
public class Semester_tutor_rejected {

    public Semester_tutor_rejected() {
        
   String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
                String uName="root";
                String uPass="";
                try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      String  query="insert into semestertutorrejectdb(ROLLNUMBER) values(?)";
                     
                        PreparedStatement ps=con.prepareStatement(query);
                        
                        
                        
                        ps.setInt(3,Semester_Tutor_Accept.rollno_text);
                        
                        
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