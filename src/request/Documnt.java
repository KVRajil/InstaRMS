package request;

import JDBCcodes.Document_db;
import JDBCcodes.Student_login;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import static request.Rail.id_num;

/**
 *
 * @author RAJIL KV
 */
public class Documnt extends JFrame{
    
    public static int studentid;
       public static String student_id;
    public static String student_name;
   public static String gender_text;
   
   public static String branch_text;
   public static String semester_text;
   public static String document_type;
   public static Date date;
    public Documnt() 
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
        
        JLabel docs=new JLabel(new ImageIcon(getClass().getResource("white.gif")));
        docs.setLayout(null);;
        jl.add(docs);
        docs.setBounds(200,80,650,460);
        
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
        
         JRadioButton male=new JRadioButton("male");
         docs.add(male);
         male.setBounds(120,205,25,25);
         male.setSelected(true);
         
         JRadioButton female=new JRadioButton("female");
         docs.add(female);
         female.setBounds(300,205,25,25);
         
         
         final ButtonGroup gendergroup=new ButtonGroup();
         gendergroup.add(male);
         gendergroup.add(female);
         
        final JDateChooser dobchooser=new JDateChooser();
        dobchooser.setLocale(Locale.US);
        //JLabel datel=new JLabel();
        docs. add(dobchooser);
        dobchooser.setBounds(200,250,150,30);
        
          String branch[]={"CSE","ME","EEE","IT","EC","CE","EC2","EC2"};
         final JComboBox jcb2=new JComboBox(branch);
         docs.add(jcb2);
         jcb2.setBounds(200,297,180,30);
         
         String semester[]={"S1&S2","S3","S4","S5","S6","S7","S8"};
         final JComboBox jcb3=new JComboBox(semester);
         docs.add(jcb3);
         jcb3.setBounds(200,350,180,30);
         
         jcb2.setSelectedItem(Student_login.vbranch_text);
         jcb3.setSelectedItem(Student_login.vsemester_text);
         sid.setText(Integer.toString(Student_login.vid_num));
        
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
        

         
       
        JButton submit=new JButton(new ImageIcon(getClass().getResource("submit.jpg")));
        jl.add(submit);
        submit.setBounds(410,535,180,45);
        submit.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            
             student_id=sid.getText();
             studentid=Integer.parseInt(student_id);
             student_name=sname.getText();
             gender_text=SelectedButton(gendergroup);
             document_type=(String)jcb1.getSelectedItem();
         
           
            date = dobchooser.getDate();
            
            
             branch_text=(String)jcb2.getSelectedItem();
             semester_text=(String)jcb3.getSelectedItem();
            System.out.print(gender_text);
            Document_db document_db = new Document_db();
            sname.setText(null);
            sid.setText(null);
            
            
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
     private final Action minimizeAction = new AbstractAction("?")
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
    public static void main(String[] args){
        new Documnt();
        
    }
}
