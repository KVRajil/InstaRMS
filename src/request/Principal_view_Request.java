/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package request;

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
import javax.swing.border.LineBorder;

/**
 *
 * @author RAJIL KV
 */
class Principal_view_Request extends JFrame{
    public static Railway_display_principal railway_display_principal;
    public static Document_display_principal document_display_principal;
    public static Semester_display_principal semester_display_principal;
    public Principal_view_Request()
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
        
        JButton rail_con=new JButton(new ImageIcon(getClass().getResource("r4.png")));
        
        jl.add(rail_con);
        rail_con.setContentAreaFilled(false);
        rail_con.setBounds(230,150,537,60);
        rail_con.setFont( new Font("Arial",Font.BOLD,30) );
        
        
        JButton doc_ret=new JButton(new ImageIcon(getClass().getResource("r5.png")));
        jl.add(doc_ret);
        doc_ret.setBounds(240,250,515,60);
        doc_ret.setFont( new Font("Arial",Font.BOLD,30) );
        doc_ret.setContentAreaFilled(false);
      
        JButton sem_reg=new JButton(new ImageIcon(getClass().getResource("r6.png")));
        jl.add(sem_reg);
        sem_reg.setBounds(190,350,621,60);
        sem_reg.setFont( new Font("Arial",Font.BOLD,30) );
        sem_reg.setContentAreaFilled(false);
        
        setVisible(true);
        
         rail_con.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            railway_display_principal = new Railway_display_principal();
        }});

doc_ret.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            setVisible(false);
            document_display_principal = new Document_display_principal(); 
        }});

sem_reg.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
           setVisible(false);
           semester_display_principal = new Semester_display_principal();
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
        {   setVisible(false);
            Principal_Choice request2 = new Principal_Choice();
            request2.setVisible(true);
            
        }
    };
    
   
    
}
