/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package request;

import JDBCcodes.Hod_login;
import JDBCcodes.Hod_signup;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


/**
 *
 * @author RAJIL KV
 */
public class Hod extends JFrame {
    
    JComboBox jcb2;
    JComboBox jcb1;
    public static String username_text;
    public static String password_text;
    public static String branch_text;
     public static String login_username_text;
    public static String login_password_text;

    public Hod () 
    {
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        JButton jb=new JButton(exitAction);
        JButton jb1=new JButton(minimizeAction);
        final JLabel jl=new JLabel(new ImageIcon(getClass().getResource("imm.jpg")));
        final JTextField user_sign=new JTextField();
        final JPasswordField repass_sign=new JPasswordField();
        final JPasswordField pass_sign=new JPasswordField();
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
        
        jl.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
        final JTextField user1=new JTextField();
        


       final JPasswordField pass1 = new JPasswordField();
        jl.add(user1);
        user1.setBounds(400,215,180,40);
        user1.setFont( new Font("Arial",Font.BOLD,20) );
        user1.setBorder(new LineBorder(Color.black));
        jl.add(pass1);
        pass1.setBounds(400,295,180,40);
        pass1.setFont( new Font("Arial",Font.BOLD,20) );
        pass1.setBorder(new LineBorder(Color.black));
        JButton login1=new JButton(new ImageIcon(getClass().getResource("images (4).jpg")));
        jl.add(login1);
        login1.setBounds(400,380,180,45);
        
        final JButton jb7=new JButton(new ImageIcon(getClass().getResource("signup.jpg")));
        jl.add(jb7);
        jb7.setBounds(830,150,152,40);
        final JLabel jl2=new JLabel(new ImageIcon(getClass().getResource("sign_up1.jpg")));
        final JButton savet=new JButton(new ImageIcon(getClass().getResource("save.jpg")));
        final JButton cancelt=new JButton(new ImageIcon(getClass().getResource("cancel.jpg")));
        
        login1.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            login_username_text=user1.getText();
            login_password_text=pass1.getText();
            new Hod_login();
            setVisible(false);
            
            
        } 
        } );
        
        setVisible(true);
        
        jb7.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
           
          
            jl2.setVisible(true);;
            jl.add(jl2);
            jl2.setLayout(null);
            jl2.setBounds(600,100,350,400);
            jl2.setBorder(new LineBorder(Color.black));
            jb7.setVisible(false);
            
            jl2.add(user_sign);
            user_sign.setBounds(130,28,180,30);
            user_sign.setFont( new Font("Arial",Font.BOLD,15) );
            user_sign.setBorder(new LineBorder(Color.black));
            
            
            jl2.add(pass_sign);
            pass_sign.setBounds(130,75,180,30);
            pass_sign.setFont( new Font("Arial",Font.BOLD,18) );
            pass_sign.setBorder(new LineBorder(Color.black));
            
            
            jl2.add(repass_sign);
            repass_sign.setBounds(130,123,180,30);
            repass_sign.setFont( new Font("Arial",Font.BOLD,18) );
            repass_sign.setBorder(new LineBorder(Color.black));
            
            String branch[]={"CSE","ME","EEE","IT","EC1","EC2","CE"};
            jcb1=new JComboBox(branch);
            jl2.add(jcb1);
            jcb1.setBounds(130,176,180,30);
            
            
            
            
            jl2.add(savet);
            savet.setBounds(50,350,110,35);
        
        
        jl2.add(cancelt);
        cancelt.setBounds(200,350,110,35);
       
            
        } 
        } );
           savet.addActionListener(new ActionListener() { 
            private String repassword_text;
        public void actionPerformed(ActionEvent e) { 
          
            username_text=user_sign.getText();
            password_text=pass_sign.getText();
            repassword_text=repass_sign.getText();
            branch_text=(String)jcb1.getSelectedItem();
            
            if(repassword_text.equals(password_text))
            {
                new Hod_signup();
                jl2.setVisible(false);
                jb7.setVisible(true);
                user_sign.setText(null);
                pass_sign.setText(null);
                repass_sign.setText(null);
                
            }
            else
            {
              JOptionPane.showMessageDialog(cancelt, "Both password should be same");
            }
            
        }});
   
        
             cancelt.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            
            jl2.setVisible(false);
            jb7.setVisible(true);
            user_sign.setText(null);
            pass_sign.setText(null);
            repass_sign.setText(null);
        }});
  
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
            Request request2 = new Request();
            request2.setVisible(true);
            setVisible(false);
            
        }
    };
    
}
