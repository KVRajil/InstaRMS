/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package request;

import JDBCcodes.Hod_change_password;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
public class Hod_Choice extends JFrame{
    
    public static String username_text;
    public static String password_text;
    public static String newpassword_text;

    public Hod_Choice() 
    {
        
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        JButton jb=new JButton(exitAction);
        JButton jb1=new JButton(minimizeAction);
        final JLabel jl=new JLabel(new ImageIcon(getClass().getResource("imagebk2.jpg")));
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
        final JLabel jl2=new JLabel(new ImageIcon(getClass().getResource("change.png")));
        final JButton savet=new JButton(new ImageIcon(getClass().getResource("save.jpg")));
        final JButton cancelt=new JButton(new ImageIcon(getClass().getResource("cancel.jpg")));
        JButton view_request=new JButton(new ImageIcon(getClass().getResource("vewr.png")));
        final JTextField user_sign=new JTextField();
        final JPasswordField newrepass_sign=new JPasswordField();
        final JPasswordField newpass_sign=new JPasswordField();
        final JPasswordField pass_sign=new JPasswordField();
        jl.add(view_request);
        view_request.setBounds(200,100,395,63);
        
        JButton manage_tutor=new JButton(new ImageIcon(getClass().getResource("managet.png")));
        jl.add(manage_tutor);
        manage_tutor.setBounds(200,200,381,58);
        
        JButton change_password=new JButton(new ImageIcon(getClass().getResource("changep.png")));
        jl.add(change_password);
        change_password.setBounds(200,298,298,44);
       
        JButton logout=new JButton(new ImageIcon(getClass().getResource("logt.png")));
        jl.add(logout);
        logout.setBounds(200,400,156,46);
        
        jl.setBorder(new LineBorder(Color.black));
        
        
        view_request.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
          setVisible(false);
          new Hod_view_Request();
          } 
        } );
        
        manage_tutor.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
          setVisible(false);
          new Manage_Tutor();
          } 
        } );
        
        logout.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
          setVisible(false);
          new Hod();
          } 
        } );
       
       change_password.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
         jl2.setVisible(true);;
            jl.add(jl2);
            jl2.setLayout(null);
            jl2.setBounds(560,100,410,400);
            jl2.setBorder(new LineBorder(Color.black));
            
            
            jl2.add(user_sign);
            user_sign.setBounds(185,60,180,30);
            user_sign.setFont( new Font("Arial",Font.BOLD,15) );
            user_sign.setBorder(new LineBorder(Color.black));
            
            
            jl2.add(pass_sign);
            pass_sign.setBounds(185,120,180,30);
            pass_sign.setFont( new Font("Arial",Font.BOLD,18) );
            pass_sign.setBorder(new LineBorder(Color.black));
            
            
            jl2.add(newpass_sign);
            newpass_sign.setBounds(185,183,180,30);
            newpass_sign.setFont( new Font("Arial",Font.BOLD,18) );
            newpass_sign.setBorder(new LineBorder(Color.black));
            
            jl2.add(newrepass_sign);
            newrepass_sign.setBounds(185,244,180,30);
            newrepass_sign.setFont( new Font("Arial",Font.BOLD,18) );
            newrepass_sign.setBorder(new LineBorder(Color.black));
            
            
            
            
            jl2.add(savet);
            savet.setBounds(50,350,110,35);
        
        
        jl2.add(cancelt);
        cancelt.setBounds(200,350,110,35);
          } 
        } );
        
               cancelt.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            
            jl2.setVisible(false);
            user_sign.setText(null);
            pass_sign.setText(null);
            newpass_sign.setText(null);
            newrepass_sign.setText(null);
        }});
        
           savet.addActionListener(new ActionListener() { 
           
        private String renewpassword_text;
        public void actionPerformed(ActionEvent e) { 
          
            username_text=user_sign.getText();
            password_text=pass_sign.getText();
            renewpassword_text=newrepass_sign.getText();
            newpassword_text=newpass_sign.getText();
            
            if(renewpassword_text.equals(newpassword_text))
            {
                
                jl2.setVisible(false);
                new Hod_change_password();
                user_sign.setText(null);
                pass_sign.setText(null);
                newrepass_sign.setText(null);
                newpass_sign.setText(null);
            }
            else
            {
              JOptionPane.showMessageDialog(cancelt, "Both password should be same");
            }
            
        }});
   
        
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
            Hod std = new Hod();
            std.setVisible(true);
            
        }
    };
}
