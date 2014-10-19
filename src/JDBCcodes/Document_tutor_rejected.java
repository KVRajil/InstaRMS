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
public class Document_tutor_rejected {

    public Document_tutor_rejected() {
     String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
                String uName="root";
                String uPass="";
                try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      String  query="insert into documenttutorrejectdb(ID) values(?)";

                        PreparedStatement ps=con.prepareStatement(query);
                        ps.setInt(1,Document_Tutor_Accept.studentid);
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

