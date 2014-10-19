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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Student_view_Status extends JFrame{
    public static String rail_status_text;

    public Student_view_Status() 
    {
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        JButton jb=new JButton(exitAction);
        JButton jb1=new JButton(minimizeAction);
        JLabel jl=new JLabel(new ImageIcon(getClass().getResource("view_status.jpg")));
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
        JButton rail_print=new JButton(new ImageIcon(getClass().getResource("print.jpg")));
        rail_print.setBounds(700,70,75,70);
        jl.add(rail_print);
        JButton doc_print=new JButton(new ImageIcon(getClass().getResource("print.jpg")));
        doc_print.setBounds(700,220,75,70);
        jl.add(doc_print);
        JButton sem_print=new JButton(new ImageIcon(getClass().getResource("print.jpg")));
        sem_print.setBounds(700,370,75,70);
        jl.add(sem_print);
        rail_print.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
          setVisible(false);
          new Student_view_Rail();
          } 
        } );
        doc_print.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
          setVisible(false);
          new Student_view_Doc();
          } 
        } );
        sem_print.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
          setVisible(false);
            try {
                new Student_view_Sem();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Student_view_Status.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Student_view_Status.class.getName()).log(Level.SEVERE, null, ex);
            }
          } 
        } );
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
            Student_Choice std = new Student_Choice();
            std.setVisible(true);
            
        }
    };
    
}
