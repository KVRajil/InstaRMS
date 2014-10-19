
package request;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
public class Request extends JFrame{

    public Request()
    {
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        JButton jb=new JButton(exitAction);
        JButton jb1=new JButton(minimizeAction);
        JButton jb2=new JButton(student);
        JButton jb3=new JButton(tutor);
        JButton jb4=new JButton(hod);
        JButton jb5=new JButton(principal);
        JLabel jl=new JLabel(new ImageIcon(getClass().getResource("image2.jpg")));
        jl.setLayout(null);
        add(jl);
        jl.add(jb);
        jl.add(jb1);
        jl.add(jb2);
        jl.add(jb3);
        jl.add(jb4);
        jl.add(jb5);
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
        jl.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
        jb2.setBounds(110,270,100,100);
        jb2.setOpaque(false);
        jb2.setFocusPainted(false);
        jb2.setBorderPainted(false);
        jb2.setContentAreaFilled(false);
        jb2.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jb2.setFont( new Font("Arial",Font.BOLD,30) );
        
        jb3.setBounds(330,270,100,100);
        jb3.setOpaque(false);
        jb3.setFocusPainted(false);
        jb3.setBorderPainted(false);
        jb3.setContentAreaFilled(false);
        jb3.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jb3.setFont( new Font("Arial",Font.BOLD,30) );
        
        jb4.setBounds(530,270,100,100);
        jb4.setOpaque(false);
        jb4.setFocusPainted(false);
        jb4.setBorderPainted(false);
        jb4.setContentAreaFilled(false);
        jb4.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jb4.setFont( new Font("Arial",Font.BOLD,30) );
        
        jb5.setBounds(750,270,100,100);
        jb5.setOpaque(false);
        jb5.setFocusPainted(false);
        jb5.setBorderPainted(false);
        jb5.setContentAreaFilled(false);
        jb5.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jb5.setFont( new Font("Arial",Font.BOLD,30) );
        
        setIconImage(new ImageIcon(getClass().getResource("download.jpg")).getImage());
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
     
    private final Action student = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {   
            new StudentLogin();
            setVisible(false);
            
       //new StudentLogin();
            
        }

         
    };
       private final Action tutor = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {   
            new Tutor();
            setVisible(false);
        }

         
    };
          private final Action hod = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {   
            new Hod();
            setVisible(false);
        }

         
    };
             private final Action principal = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {   
            new Principal();
            setVisible(false);
        }

         
    };
          
    public static void main(String[] args) {
        Request request = new Request();
    }
}
