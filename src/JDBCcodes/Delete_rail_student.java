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
import request.MyModel;
import request.MyModel_1;

/**
 *
 * @author RAJIL KV
 */
public class Delete_rail_student {

    public Delete_rail_student() 
    {
        System.out.println("hgj");
        String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
        String uName="root";
        String uPass="";
        String deleteqry="delete from raildb "+ "WHERE id=?";
        PreparedStatement ps1=null;
        try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      ps1=con.prepareStatement(deleteqry);
                      ps1.setInt(1,MyModel.idno);
                      ps1.executeUpdate();
                         con.close();
                     
                      
                    }
            catch (Exception er ) {
            er.printStackTrace();
            } 
    }
    
}