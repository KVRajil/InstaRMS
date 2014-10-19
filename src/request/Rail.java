/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package request;


import JDBCcodes.Railway_db;
import JDBCcodes.Student_login;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.Locale;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JPanel;
import static request.Documnt.date;
public class Rail extends JFrame{
     public static String name_text;
     public static String gender_text;
     public static String from_text;
     public static String to_text;
     public static String branch_text;
     public static String semester_text;
     public static int id_num;
     public static int age_num;
     public static Date date;

    public Rail() 
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
        
        jb6.setBounds(28,23,47,45);
        jb6.setOpaque(false);
        jb6.setFocusPainted(false);
        jb6.setBorderPainted(false);
        jb6.setContentAreaFilled(false);
        jb6.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jb6.setFont( new Font("Arial",Font.BOLD,30) );
        
        jl.setBorder(new LineBorder(Color.black));
        
        
        JLabel raillabel=new JLabel(new ImageIcon(getClass().getResource("railform.jpg")));
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
         
         JRadioButton male=new JRadioButton("male");
         raillabel.add(male);
         male.setBounds(150,152,25,25);
         male.setSelected(true);
         
         JRadioButton female=new JRadioButton("female");
         raillabel.add(female);
         female.setBounds(260,152,25,25);
         
         final ButtonGroup gendergroup=new ButtonGroup();
         gendergroup.add(male);
         gendergroup.add(female);
         
         branch.setSelectedItem(Student_login.vbranch_text);
         semester.setSelectedItem(Student_login.vsemester_text);
         sid.setText(Integer.toString(Student_login.vid_num));
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
        
        JButton submit=new JButton(new ImageIcon(getClass().getResource("submit.jpg")));
        jl.add(submit);
        submit.setBounds(410,520,180,45);
         submit.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
            String id_text=sid.getText();
             id_num=Integer.parseInt(id_text);
             name_text=sname.getText();
             gender_text=SelectedButton(gendergroup);
            String age_text=age.getText();
            age_num=Integer.parseInt(age_text);
            
             date = dobchooser.getDate();
             from_text=from.getText();
             to_text=to.getText();
             branch_text=(String)branch.getSelectedItem();
            semester_text=(String)semester.getSelectedItem();
             
            new Railway_db();
            age.setText(null);
            from.setText(null);
            to.setText(null);
            sname.setText(null);
            sid.setText(null);

           
            
            
        }

           
        });
        
        
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
    
     public void RailwayDB() 
            {
               
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
            Request_type std = new Request_type();
            std.setVisible(true);
            
        }
    };
    
}
