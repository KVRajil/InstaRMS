/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JDBCcodes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author RAJIL KV
 */
public class Delete_print_sem {

    public Delete_print_sem() {
    String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
        String uName="root";
        String uPass="";
        String deleteqry="delete from semesterprincipalacceptdb "+ "WHERE rollnumber=?";
        PreparedStatement ps1=null;
        try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      ps1=con.prepareStatement(deleteqry);
                      ps1.setInt(1,Student_login.vid_num);
                      ps1.executeUpdate();
                         con.close();
                     
                      
                    }
            catch (Exception er ) {
            er.printStackTrace();
            } 
    }
    
}
