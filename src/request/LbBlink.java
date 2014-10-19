/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package request;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author RAJIL KV
 */
public class LbBlink implements ActionListener {  

        private javax.swing.JLabel label;
        private java.awt.Color cor1 = java.awt.Color.red;
        private java.awt.Color cor2 = java.awt.Color.gray;
        private int count;

        public LbBlink(javax.swing.JLabel label){
            this.label = label;
        }

    
     
        @Override
        public void actionPerformed(ActionEvent e) {
            if(count % 2 == 0)
                label.setForeground(cor1);
            else
                label.setForeground(cor2);
            count++;
        }  

}
    