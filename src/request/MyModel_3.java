/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package request;

import JDBCcodes.Delete_Tutor_account;
import JDBCcodes.Delete_student_account;
import JDBCcodes.Hod_login;
import JDBCcodes.Tutor_login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RAJIL KV
 */
public class MyModel_3 extends AbstractTableModel {
      
      public static String idname;

    private String[] columnNames = {"NAME", "SEMESTER","DELETE"};
    private ArrayList semester = new ArrayList();
    private ArrayList name = new ArrayList();
   
    MyModel_3() {
        
       String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
                String uName="root";
                String uPass="";
                String selectqry="select username,semester from tutorsignup where branch='"+Hod_login.branch_text+"'";
                try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      Statement stm = con.createStatement();
                      PreparedStatement ps1=con.prepareStatement(selectqry);
                      ResultSet rs=ps1.executeQuery();
                       ResultSet res = stm.executeQuery(selectqry);
                      while(res.next())
                      {
                          name.add(res.getString("username"));
                          semester.add(res.getString("semester"));
                          
                      }
            }
            catch (Exception er ) {
            er.printStackTrace();
            }      
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    public int getRowCount() {
        return name.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        if (col == 0) {
            return name.get(row);
            
        }
        else if(col==1) {
            return semester.get(row); // dummy string
        }
        else {
            return "Delete"; // dummy string
        }
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        if (col == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setValueAt(Object value, int row, int col) {
        if (col == 0) {
            name.set(row, (String) value);
            
            
        }
        else if (col == 1) {
            semester.set(row, (String) value);
       
        }
        fireTableCellUpdated(row, col);
    }

    void deleteRow(int row) {
           
            idname=(String)name.get(row);
            int dialogButton = JOptionPane.YES_NO_OPTION; 
        int dialogResult = JOptionPane.showConfirmDialog(null, 
            "Really delete this row?", "Delete can't be undone", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
             new Delete_Tutor_account();
            name.remove(row); // remove element from arraylist
            fireTableRowsDeleted(row, row);
        }
    
}}
