/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package request;

import JDBCcodes.Delete_document_hod;
import JDBCcodes.Delete_document_student;
import JDBCcodes.Hod_login;
import JDBCcodes.Tutor_login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import static request.Hod_view_Request.railway_display_hod;

/**
 *
 * @author RAJIL KV
 */public class MyModel_7 extends AbstractTableModel {
      public static int []a=new int[10000];
      public static int []b=new int[10000];
      public static int lim;
      public static int idno;

    private String[] columnNames = {"ID", "NAME","VIEW"};
    private ArrayList id = new ArrayList();
    private ArrayList name = new ArrayList();
   
    MyModel_7() {
        lim=0;
       String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
                String uName="root";
                String uPass="";
                String selectqry="select id,name from documenttutoracceptdb where branch='"+Hod_login.branch_text+"'";
                try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      Statement stm = con.createStatement();
                      PreparedStatement ps1=con.prepareStatement(selectqry);
                      ResultSet rs=ps1.executeQuery();
                       ResultSet res = stm.executeQuery(selectqry);
                      while(res.next())
                      {
                          id.add(res.getInt("id"));
                          name.add(res.getString("name"));
                          
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
        return id.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        if (col == 0) {
            return id.get(row);
            
        }
        else if(col==1) {
            return name.get(row); // dummy string
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
            id.set(row, (Integer) value);
            
            
        }
        else if (col == 1) {
            name.set(row, (String) value);
       
        }
        fireTableCellUpdated(row, col);
    }

    void deleteRow(int row) throws SQLException {
           
            idno=(Integer)id.get(row);
            
            Hod_view_Request.document_display_hod.setVisible(false);
            new Document_Hod_Accept();
          
            id.remove(row); // remove element from arraylist
            fireTableRowsDeleted(row, row);
            new Delete_document_hod();
    
}}