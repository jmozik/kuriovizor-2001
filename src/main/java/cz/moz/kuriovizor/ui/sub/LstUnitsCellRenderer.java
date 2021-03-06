/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.moz.kuriovizor.ui.sub;

import cz.moz.kuriovizor.domain.Unit2;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author moz
 */
public class LstUnitsCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof Unit2) {
            Unit2 unit = (Unit2) value;
            String name = unit.getUnitName();
            if (name.length() > 35) {
                name = name.substring(0, 32) + "...";
            }
            setText(String.valueOf(unit.getId()) + ".   " + name);
        }

        return this;
    }
}
