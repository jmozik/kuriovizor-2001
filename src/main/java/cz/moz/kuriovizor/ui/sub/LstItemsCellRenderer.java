/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.ui.sub;

import cz.moz.kuriovizor.domain.Item;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author moz
 */
public class LstItemsCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if(value instanceof Item) {
            Item item = (Item) value;
            String name = item.getProductName();
            if(name.length() > 35)
                name = name.substring(0, 32) + "...";
            setText(String.valueOf(item.getId()) + ".   " + name);
        }
        
        return this;
    }
}
