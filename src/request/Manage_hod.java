/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package request;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author RAJIL KV
 */
class Manage_hod extends JFrame{
    public ResultSet res;
    public JTable table ;
    JLabel jl;
    public Manage_hod () 
    {
        
         setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        JButton jb=new JButton(exitAction);
        JButton jb1=new JButton(minimizeAction);
        jl=new JLabel(new ImageIcon(getClass().getResource("imagebk2.jpg")));
        jl.setLayout(null);
        add(jl);
        jl.add(jb);
        jl.add(jb1);
        JButton jb6=new JButton(back);
        jl.add(jb6);
        jb.setBounds(950,10,30,50);
        jb.setOpaque(false);
        jb.setFocusPainted(false);
        jb.setBorderPainted(false);
        jb.setContentAreaFilled(false);
        jb.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jb.setFont( new Font("Arial",Font.BOLD,30) );
        jb1.setBounds(910,12,30,50);
        jb1.setOpaque(false);
        jb1.setFocusPainted(false);
        jb1.setBorderPainted(false);
        jb1.setContentAreaFilled(false);
        jb1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jb1.setFont( new Font("Arial",Font.BOLD,30) );
        
        jb6.setBounds(50,23,30,30);
        jb6.setOpaque(false);
        jb6.setFocusPainted(false);
        jb6.setBorderPainted(false);
        jb6.setContentAreaFilled(false);
        jb6.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jb6.setFont( new Font("Arial",Font.BOLD,30) );
        
        jl.setBorder(new LineBorder(Color.black));
        
        Display();
         
        setVisible(true);
    }
    
      
     private final Action exitAction = new AbstractAction("X")
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    };
     private final Action minimizeAction = new AbstractAction("−")
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            setState(JFrame.ICONIFIED);
        }

         
    };
    private final Action back = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {   setVisible(false);
            Principal_Choice std = new Principal_Choice();
            std.setVisible(true);
            
        }
    };
    
    public static void main(String[] args) throws SQLException {
        Manage_hod rd = new Manage_hod();
    }

    private void Display() {
        MyModel_5 data = new MyModel_5();
        table = new JTable(data); 
         table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // only allow single cell selection, not rows or columns
        table.setCellSelectionEnabled(true);
        //set a list selection listener
        ListSelectionModel tableSelectionModel = table.getSelectionModel();
        table.addMouseListener(new MouseAdapter() {
  public void mouseClicked(MouseEvent e) {
    if (e.getClickCount() == 1) {
      JTable target = (JTable)e.getSource();
      int row = target.getSelectedRow();
      
      ((MyModel_5) table.getModel()).deleteRow(row);
    }
  }
});
        table.setRowHeight(45); // match image height
       
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn column = table.getColumnModel().getColumn(2);
        column.setPreferredWidth(70);
        column = table.getColumnModel().getColumn(1);
        column.setPreferredWidth(110);
        column = table.getColumnModel().getColumn(0);
        column.setPreferredWidth(110);
        // set renderer for control column..
        column = table.getColumnModel().getColumn(2);
        column.setCellRenderer(new MyRenderer_1());
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  
        dtcr.setHorizontalTextPosition(DefaultTableCellRenderer.CENTER);
        JScrollPane sp = new JScrollPane();
        sp.setBounds(200,150,300,400);
        jl.add(sp); 
        sp.setViewportView(table);
    }
}