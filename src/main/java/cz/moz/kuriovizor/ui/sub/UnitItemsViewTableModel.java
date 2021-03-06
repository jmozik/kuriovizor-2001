/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.ui.sub;

import cz.moz.kuriovizor.domain.ItemUnit;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author moz
 */
public class UnitItemsViewTableModel extends AbstractTableModel {
    private List<ItemUnit> list;
    private final String[] columnNames = new String[]{
        "Id", "Name", "Req. count"
    };

    public UnitItemsViewTableModel() {
    }
    
    public UnitItemsViewTableModel(List<ItemUnit> list) {
        this.list = list;
    }

    public void setList(List<ItemUnit> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
       if(list != null)
        return list.size();
       else
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemUnit item = list.get(rowIndex);
        Object obj = null;
         switch (columnIndex) {
             case 0:
                 obj = (Object) item.getItem().getId();
                 break;
             case 1:
                 obj = (Object) item.getItem().getProductName();
                 break;    
             case 2:
                 obj = (Object) item.getRequiredCount();
                 break;
         }
         return obj;
    }
    
     @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
    }
    
}
