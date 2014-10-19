/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package request;

import JDBCcodes.Delete_print_rail;
import JDBCcodes.Delete_print_sem;
import JDBCcodes.Semester_db;
import JDBCcodes.Semester_tutor_accepted;
import JDBCcodes.Semester_tutor_rejected;
import JDBCcodes.Student_login;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import static request.Semester.admissionnumber_text;
import static request.Semester.branch_text;
import static request.Semester.deodues_text;
import static request.Semester.feecon_text;
import static request.Semester.libdue_text;
import static request.Semester.name_text;
import static request.Semester.officedues_text;
import static request.Semester.parent_address_text;
import static request.Semester.parent_name_text;
import static request.Semester.residence_place_text;
import static request.Semester.rollno_text;
import static request.Semester.semester_text;
import static request.Semester.workshopdues_text;
import static request.Semester.year_text;

/**
 *
 * @author RAJIL KV
 */

public class Student_view_Sem extends JFrame{
    
    public static String  branch_text;
    public static String semester_text;
    public static int rollno_text;
    public static String name_text;
    public static int admissionnumber_text;
    public static int year_text;
    public static String parent_name_text;
    public static String parent_address_text;
    public static String residence_place_text;
    public static String feecon_text;
    public static int libdue_text;
    public static int officedues_text;
    public static int workshopdues_text;
    public static int deodues_text;
    public Student_view_Sem() throws ClassNotFoundException, SQLException 
    {
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        JButton jb=new JButton(exitAction);
        JButton jb1=new JButton(minimizeAction);
        JLabel jl=new JLabel(new ImageIcon(getClass().getResource("imagebk2.jpg")));
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
        
        JButton print=new JButton(new ImageIcon(getClass().getResource("p.png")));
        jl.add(print);
        print.setBounds(280,530,120,42);
        
         
           
        
      final JLabel jln= new JLabel(new ImageIcon(getClass().getResource("w.gif")));
        
       JScrollPane jsp=new JScrollPane();
         
       jsp.setViewportView(jln);
       jl.add(jsp);
       jsp.setBounds(110,60,800,460);
     
             
      String branch[]={"CSE","ME","EEE","IT","EC","CE"};
         final JComboBox jcb2=new JComboBox(branch);
         jln.add(jcb2);
       
         jcb2.setBounds(340,120,180,30);
         
          String semester[]={"S1&S2","S3","S4","S5","S6","S7","S8"};
         final JComboBox jcb3=new JComboBox(semester);
         jln.add(jcb3);
         jcb3.setBounds(340,170,180,30);
         
         final JTextField srn=new JTextField();
        jln.add(srn);
        srn.setBounds(340,220,180,30);
        srn.setFont( new Font("Arial",Font.BOLD,18) );
        srn.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
        final JTextField sname=new JTextField();
        jln.add(sname);
        sname.setBounds(340,270,180,30);
        sname.setFont( new Font("Arial",Font.BOLD,18) );
        sname.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
        final JTextField san=new JTextField();
        jln.add(san);
        san.setBounds(340,320,180,30);
        san.setFont( new Font("Arial",Font.BOLD,18) );
        san.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
         final JTextField sadmnyr=new JTextField();
        jln.add(sadmnyr);
        sadmnyr.setBounds(340,370,180,30);
        sadmnyr.setFont( new Font("Arial",Font.BOLD,18) );
        sadmnyr.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
        
        
         final JTextField sparentname=new JTextField();
        jln.add(sparentname);
        sparentname.setBounds(340,420,180,30);
        sparentname.setFont( new Font("Arial",Font.BOLD,18) );
        sparentname.setBorder(BorderFactory.createLineBorder(Color.black, 2));;
        
           
        //sparentaddress.setBounds(340,550,180,150);
        
        JScrollPane addresspane=new JScrollPane();
        jln.add(addresspane);
        addresspane.setBounds(340,520,180,80);
       
        final JTextArea sparentaddress=new JTextArea();
        addresspane.setViewportView(sparentaddress);
        sparentaddress.setFont( new Font("Arial",Font.BOLD,18) );
        sparentaddress.setBorder(new LineBorder(Color.black));
        
         JScrollPane resaddresspane=new JScrollPane();
        jln.add(resaddresspane);
        resaddresspane.setBounds(340,640,180,80);
       
        final JTextArea residentaddress=new JTextArea();
        resaddresspane.setViewportView(residentaddress);
        residentaddress.setFont( new Font("Arial",Font.BOLD,18) );
        residentaddress.setBorder(new LineBorder(Color.black));
        
          final JTextField fee=new JTextField();
        jln.add(fee);
        fee.setBounds(340,780,180,30);
        fee.setFont( new Font("Arial",Font.BOLD,18) );
        fee.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
          final JTextField library=new JTextField();
        jln.add(library);
        library.setBounds(340,925,180,30);
        library.setFont( new Font("Arial",Font.BOLD,18) );
        library.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
        final JTextField workshop=new JTextField();
        jln.add(workshop);
        workshop.setBounds(340,975,180,30);
        workshop.setFont( new Font("Arial",Font.BOLD,18) );
        workshop.setBorder(BorderFactory.createLineBorder(Color.black, 2));
       
        final JTextField office=new JTextField();
        jln.add(office);
        office.setBounds(340,1025,180,30);
        office.setFont( new Font("Arial",Font.BOLD,18) );
        office.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
         final JTextField department=new JTextField();
        jln.add(department);
        department.setBounds(340,1075,180,30);
        department.setFont( new Font("Arial",Font.BOLD,18) );
        department.setBorder(BorderFactory.createLineBorder(Color.black, 2)); 
        Get();
        jcb2.setSelectedItem(branch_text);
        jcb3.setSelectedItem(semester_text);
        srn.setText(Integer.toString(rollno_text));
        sname.setText(name_text);
        san.setText(Integer.toString(admissionnumber_text));
        sadmnyr.setText(Integer.toString(year_text));
        sparentname.setText(parent_name_text);
        sparentaddress.setText(parent_address_text);
        residentaddress.setText(residence_place_text);
        fee.setText(feecon_text);
        library.setText(Integer.toString(libdue_text));
        office.setText(Integer.toString(officedues_text));
        workshop.setText(Integer.toString(workshopdues_text));
        department.setText(Integer.toString(deodues_text));
        print.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
                new Semester_tutor_accepted();
                PrintUtilities.printComponent(jln);
                setVisible(false);
                
                srn.setText(null);
                sname.setText(null);
                san.setText(null);
                sadmnyr.setText(null);
                sparentname.setText(null);
                sparentaddress.setText(null);
                residentaddress.setText(null);
                fee.setText(null);
                library.setText(null);
                office.setText(null);
                workshop.setText(null);
                department.setText(null);
                new Delete_print_sem();
                new Student_view_Status();

            
        }});
        
       
        
         
       srn.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        e.consume();
      }
    }
  });
 
         san.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        e.consume();
      }
    }
  });
           department.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        e.consume();
      }
    }
  });
             workshop.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        e.consume();
      }
    }
  });
               office.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        e.consume();
      }
    }
  });
        

       
       library.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        e.consume();
      }
    }
  });
       sadmnyr.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        e.consume();
      }
    }
  });
       
       
       
       
       jl.setBorder(new LineBorder(Color.black));
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
        {   
            Request_type std = new Request_type();
            std.setVisible(true);
            setVisible(false);
            
        }
    };

   void Get() {
        String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
        String uName="root";
        String uPass="";
        String selectqry="select * from semesterprincipalacceptdb " + "WHERE ROLLNUMBER=?"; 
        PreparedStatement ps1=null;
        try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      
                      ps1=con.prepareStatement(selectqry);
                      ps1.setInt(1,Student_login.vid_num);
                      
                      ResultSet rs=ps1.executeQuery();
                      while(rs.next())
                      {
                            branch_text=rs.getString("BRANCH");
                            semester_text=rs.getString("SEMESTER");
                            rollno_text=rs.getInt("ROLLNUMBER");
                            name_text=rs.getString("NAME");
                            admissionnumber_text=rs.getInt("ADMISSIONNUMBER");
                            year_text=rs.getInt("YEAROFADMISSION");
                            parent_name_text=rs.getString("PARENT");
                            parent_address_text=rs.getString("ADDRESS");
                            residence_place_text=rs.getString("RESIDENCE");
                            feecon_text=rs.getString("FEE");
                            libdue_text=rs.getInt("LIBRARY");
                            officedues_text=rs.getInt("WORKSHOP");
                            workshopdues_text=rs.getInt("OFFICE");
                            deodues_text=rs.getInt("DEPARTMENT");

                      }
            }
            catch (Exception er ) {
            er.printStackTrace();
            }
}
}