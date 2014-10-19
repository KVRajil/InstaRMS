/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JDBCcodes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import request.MyModel_4;
import request.MyModel_7;

/**
 *
 * @author RAJIL KV
 */
public class Delete_document_hod {

    public Delete_document_hod() {
  String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
        String uName="root";
        String uPass="";
        String deleteqry="delete from documenttutoracceptdb "+ "WHERE id=?";
        PreparedStatement ps1=null;
        try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      ps1=con.prepareStatement(deleteqry);
                      ps1.setInt(1,MyModel_7.idno);
                      ps1.executeUpdate();
                         con.close();
                     
                      
                    }
            catch (Exception er ) {
            er.printStackTrace();
            } 
    }
    
}

