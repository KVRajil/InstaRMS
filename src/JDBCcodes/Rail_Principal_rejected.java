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
import request.Railway_Hod_Accept;
import request.Railway_Principal_Accept;

/**
 *
 * @author RAJIL KV
 */
public class Rail_Principal_rejected {

    public Rail_Principal_rejected() {
    int flag=0;   
        String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
        String uName="root";
        String uPass="";
        String  query="insert into railprincipalrejectdb(ID) values(?)";
        String selectqry="select id from railprincipalrejectdb ";
        try{
                        Connection con=DriverManager.getConnection(host,uName,uPass);
                        PreparedStatement ps1=con.prepareStatement(selectqry);
                        ResultSet rs=ps1.executeQuery();
                        while(rs.next())
                        {   int id=rs.getInt("id");
                            if(id==Railway_Principal_Accept.id_num)
                            {
                                flag=1;
                            }
                            
                        }
                        if(flag!=1)
                        {
                            PreparedStatement ps=con.prepareStatement(query);
                            ps.setInt(1,Railway_Principal_Accept.id_num);
                            ps.executeUpdate();   
                        }
                        
                         JOptionPane.showMessageDialog(null, "Success");
                      con.close();
                     
            }
            catch (Exception er ) {
            er.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
            }      
    }
    
}


