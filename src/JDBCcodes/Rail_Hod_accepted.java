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
import request.Railway_Hod_Accept;

/**
 *
 * @author RAJIL KV
 */
public class Rail_Hod_accepted {

    public Rail_Hod_accepted() 
    {
        
                String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
                String uName="root";
                String uPass="";
                try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      String  query="insert into railhodacceptdb(ID,NAME,SEX,AGE,DATE1,RFROM,RTO,BRANCH,SEMESTER) values(?,?,?,?,?,?,?,?,?)";

                        PreparedStatement ps=con.prepareStatement(query);
                        ps.setInt(1,Railway_Hod_Accept.id_num);
                        ps.setString(2,Railway_Hod_Accept.name_text);
                        ps.setString(3,Railway_Hod_Accept.gender_text);
                        ps.setInt(4,Railway_Hod_Accept.age_num);
                        
                        java.sql.Date date1 = new java.sql.Date(Railway_Hod_Accept.date.getTime());
                        ps.setDate(5,date1);
                        ps.setString(6,Railway_Hod_Accept.from_text);
                        ps.setString(7,Railway_Hod_Accept.to_text);
                        ps.setString(8,Railway_Hod_Accept.branch_text);
                        ps.setString(9,Railway_Hod_Accept.semester_text);
                        ps.executeUpdate();
                      con.close();
                     JOptionPane.showMessageDialog(null, "Success");
            }
            catch (Exception er ) {
            er.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
            }      
    }
    
}

