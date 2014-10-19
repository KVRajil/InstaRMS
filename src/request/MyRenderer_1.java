/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package request;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author RAJIL KV
 */
 class MyRenderer_1 extends JLabel implements TableCellRenderer {

    static ImageIcon icon;

    static { // load image
        java.net.URL imageURL = MyRenderer.class.getResource("del.jpg");
        if (imageURL != null) {
            icon = new ImageIcon(imageURL); 
        } 
    }

    MyRenderer_1() {
        super(icon);             
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) { // border selected cell in red
            setBorder(BorderFactory.createLineBorder(Color.red));
        } else {
            setBorder(null);
        }
        return this; 
    }
}