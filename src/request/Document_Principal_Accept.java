/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package request;

import JDBCcodes.Document_hod_accepted;
import JDBCcodes.Document_principal_accepted;
import JDBCcodes.Document_tutor_accepted;
import com.toedter.calendar.JDateChooser;
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
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author RAJIL KV
 */
public class Document_Principal_Accept extends JFrame{
        public static int studentid;
        public static String student_id;
        public static String student_name;
        public static String gender_text;

        public static String branch_text;
        public static String semester_text;
        public static String document_type;
        public static Date date;

    public Document_Principal_Accept() 
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
        
        JLabel docs=new JLabel(new ImageIcon(getClass().getResource("white1.gif")));
        docs.setLayout(null);;
        jl.add(docs);
        docs.setBounds(180,50,650,460);
        
        final JTextField sid=new JTextField();
        docs.add(sid);
        sid.setBounds(200,100,180,30);
        sid.setFont( new Font("Arial",Font.BOLD,18) );
        sid.setBorder(new LineBorder(Color.black));
        
        final JTextField sname=new JTextField();
        docs.add(sname);
        sname.setBounds(200,150,180,30);
        sname.setFont( new Font("Arial",Font.BOLD,18) );
        sname.setBorder(new LineBorder(Color.black));
        
        final JTextField sex=new JTextField();
        docs.add(sex);
        sex.setBounds(200,200,70,30);
        sex.setFont( new Font("Arial",Font.BOLD,18) );
        sex.setBorder(new LineBorder(Color.black));
        
         
        final JDateChooser dobchooser=new JDateChooser();
        dobchooser.setLocale(Locale.US);
        //JLabel datel=new JLabel();
        docs. add(dobchooser);
        dobchooser.setBounds(200,250,150,30);
        
          String branch[]={"CSE","ME","EEE","IT","EC","CE"};
         final JComboBox jcb2=new JComboBox(branch);
         docs.add(jcb2);
         jcb2.setBounds(200,297,180,30);
         
         String semester[]={"S1&S2","S3","S4","S5","S6","S7","S8"};
         final JComboBox jcb3=new JComboBox(semester);
         docs.add(jcb3);
         jcb3.setBounds(200,350,180,30);
         
        
        
        String docmnt[]={"SSLC","HSE","CBSE X ","CBSE XII "};
         final JComboBox jcb1=new JComboBox(docmnt);
         docs.add(jcb1);
         jcb1.setBounds(200,405,180,30);
         
        
         
         
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
        

         
       
        JButton approve=new JButton(new ImageIcon(getClass().getResource("approve.png")));
        jl.add(approve);
        approve.setBounds(280,520,162,42);
        JButton reject=new JButton(new ImageIcon(getClass().getResource("reject.png")));
        jl.add(reject);
        reject.setBounds(550,520,150,42);
        Get();
        sid.setText(Integer.toString(studentid));
        sname.setText(student_name);
        sex.setText(gender_text);
        dobchooser.setDate(date);
        jcb2.setSelectedItem(branch_text);
        jcb3.setSelectedItem(semester_text);
        jcb1.setSelectedItem(semester_text);
        sid.setEditable(false);
        sex.setEditable(false);
        sname.setEditable(false);
        dobchooser.setEnabled(false);
        jcb1.setEnabled(false);
        jcb2.setEnabled(false);
        jcb3.setEnabled(false);
        
        approve.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            
             
            new Document_principal_accepted();
            setVisible(false);
            Hod_view_Request.document_display_hod.setVisible(true);
            sex.setText(null);
            sname.setText(null);
            sid.setText(null);

            
            setVisible(false);
            
            
        }});
        
        jl.setBorder(new LineBorder(Color.black));
        setVisible(true);
    }
    
     public String SelectedButton(ButtonGroup gendergroup)
     {
        for (Enumeration<AbstractButton> buttons = gendergroup.getElements(); buttons.hasMoreElements();) 
        {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) 
            {
                return button.getText();
            }
        }

        return null;
    } 
    
     private   Action exitAction = new AbstractAction("X")
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    };
     private final Action minimizeAction = new AbstractAction("-")
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
            Principal_view_Request std = new Principal_view_Request();
            std.setVisible(true);
            
        }
    };
    
    void Get()
    {
        String host="jdbc:mysql://localhost:3306/requestdb?zeroDateTimeBehavior=convertToNull";
        String uName="root";
        String uPass="";
        String selectqry="select * from documenthodaccept " + "WHERE id=?"; 
        PreparedStatement ps1=null;
        try {
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con=DriverManager.getConnection(host,uName,uPass);
                      
                      ps1=con.prepareStatement(selectqry);
                      ps1.setInt(1,MyModel_8.idno);
                      
                      ResultSet rs=ps1.executeQuery();
                      while(rs.next())
                      {
                      student_name=rs.getString("NAME");
                      gender_text=rs.getString("SEX");
                      document_type=rs.getString("DOCTYPE");
                      branch_text=rs.getString("BRANCH");
                      semester_text=rs.getString("SEMESTER");
                      studentid=rs.getInt("ID");
                      date=rs.getDate("DOB");
                      }
        }
            catch (Exception er ) {
            er.printStackTrace();
            } 
    }
    public static void main(String[] args){
        new Document_Principal_Accept();
        
    }
}
