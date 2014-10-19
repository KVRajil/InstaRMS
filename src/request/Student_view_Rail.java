/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package request;

import JDBCcodes.Delete_print_rail;
import JDBCcodes.Rail_tutor_accepted;
import JDBCcodes.Rail_tutor_rejected;
import JDBCcodes.Student_login;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import static request.Railway_Tutor_Accept.age_num;
import static request.Railway_Tutor_Accept.branch_text;
import static request.Railway_Tutor_Accept.date;
import static request.Railway_Tutor_Accept.from_text;
import static request.Railway_Tutor_Accept.gender_text;
import static request.Railway_Tutor_Accept.id_num;
import static request.Railway_Tutor_Accept.name_text;
import static request.Railway_Tutor_Accept.semester_text;
import static request.Railway_Tutor_Accept.to_text;

/**
 *
 * @author RAJIL KV
 */
class Student_view_Rail extends JFrame{
    public static String name_text;
     public static String gender_text;
     public static String from_text;
     public static String to_text;
     public static String branch_text;
     public static String semester_text;
     public static int id_num;
     public static int age_num;
     public static Date date;
    private int n;

    public Student_view_Rail() {
        
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
        
        jb6.setBounds(28,23,47,45);
        jb6.setOpaque(false);
        jb6.setFocusPainted(false);
        jb6.setBorderPainted(false);
        jb6.setContentAreaFilled(false);
        jb6.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jb6.setFont( new Font("Arial",Font.BOLD,30) );
        
        jl.setBorder(new LineBorder(Color.black));
        
        
        final JLabel raillabel=new JLabel(new ImageIcon(getClass().getResource("railform_2.jpg")));
        raillabel.setLayout(null);;
        jl.add(raillabel);
        raillabel.setBounds(200,100,600,400);
        raillabel.setBorder(new LineBorder(Color.black));
        
        final JTextField sid=new JTextField();
        raillabel.add(sid);
        sid.setBounds(200,60,180,30);
        sid.setFont( new Font("Arial",Font.BOLD,18) );
        sid.setBorder(new LineBorder(Color.black));
        
        final JTextField sname=new JTextField();
        raillabel.add(sname);
        sname.setBounds(200,100,180,30);
        sname.setFont( new Font("Arial",Font.BOLD,18) );
        sname.setBorder(new LineBorder(Color.black));
        
        final JTextField sex=new JTextField();
        raillabel.add(sex);
        sex.setBounds(200,140,90,30);
        sex.setFont( new Font("Arial",Font.BOLD,18) );
        sex.setBorder(new LineBorder(Color.black));
        
        final JTextField from=new JTextField();
        raillabel.add(from);
        from.setBounds(130,260,180,30);
        from.setFont( new Font("Arial",Font.BOLD,18) );
        from.setBorder(new LineBorder(Color.black));
        
        final JTextField to=new JTextField();
        raillabel.add(to);
        to.setBounds(400,260,180,30);
        to.setFont( new Font("Arial",Font.BOLD,18) );
        to.setBorder(new LineBorder(Color.black));
        
         final String branches[]={"CSE","ME","EEE","IT","EC1","EC2","CE"};
         final JComboBox branch =new JComboBox(branches);
         raillabel.add(branch);
         branch.setBounds(130,300,180,30);
            
         String semesters[]={"S1&S2","S3","S4","S5","S6","S7","S8"};
         final JComboBox semester=new JComboBox(semesters);
         raillabel.add(semester);
         semester.setBounds(130,350,180,30);
     
         
        final JTextField age=new JTextField();
        raillabel.add(age);
        age.setBounds(130,186,50,30);
        age.setFont( new Font("Arial",Font.BOLD,18) );
        age.setBorder(new LineBorder(Color.black));
        
        final JDateChooser dobchooser=new JDateChooser();
        //dob.setLocale(Locale.US);
        //JLabel date1=new JLabel();
        raillabel. add(dobchooser);
        dobchooser.setBounds(270,186,150,30);
        setVisible(true);
        
        JButton print=new JButton(new ImageIcon(getClass().getResource("p.png")));
        jl.add(print);
        print.setBounds(380,520,120,42);
       
            Get();
            sid.setText(Integer.toString(id_num));
            sname.setText(name_text);
            sex.setText(gender_text);
            age.setText(Integer.toString(age_num));
            dobchooser.setDate(date);
            from.setText(from_text);
            to.setText(to_text);
            branch.setSelectedItem(branch_text);
            semester.setSelectedItem(semester_text);
            sid.setEditable(false);
            sname.setEditable(false);
            age.setEditable(false);
            dobchooser.setEnabled(false);
            from.setEditable(false);
            to.setEditable(false);
            branch.setEnabled(false);
            semester.setEnabled(false);
         print.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
            
            PrintUtilities.printComponent(raillabel);
            setVisible(false);
            
            age.setText(null);
            from.setText(null);
            to.setText(null);
            sname.setText(null);
            sid.setText(null);
            new Delete_print_rail();
            new Student_view_Status();
        }});
         
        
        
        
       age.addKeyListener(new KeyAdapter() {
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
       sid.addKeyListener(new KeyAdapter() {
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
        
        
    }
    void Get()
    {
        String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
        String uName="root";
        String uPass="";
        String selectqry="select * from railprincipalacceptdb " + " WHERE id=? "; 
        
        PreparedStatement ps=null;
        try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      ps=con.prepareStatement(selectqry);
                      ps.setInt(1,Student_login.vid_num);
                     
                      ResultSet rs=ps.executeQuery();
                      while(rs.next())
                      {
                      name_text=rs.getString("NAME");
                      gender_text=rs.getString("SEX");
                      from_text=rs.getString("RFROM");
                      to_text=rs.getString("RTO");
                      branch_text=rs.getString("BRANCH");
                      semester_text=rs.getString("SEMESTER");
                      id_num=rs.getInt("ID");
                      age_num=rs.getInt("AGE");
                      date=rs.getDate("DATE1");
                      }
        }
            catch (Exception er ) {
            er.printStackTrace();
            } 
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
            Student_view_Status m;
            m = new Student_view_Status();
            m.setVisible(true);
            
            
        }
    };
    
}
