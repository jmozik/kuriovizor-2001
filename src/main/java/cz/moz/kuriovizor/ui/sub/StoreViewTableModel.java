/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.moz.kuriovizor.ui.sub;

import cz.moz.kuriovizor.domain.StoreEntity;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author moz
 */
public class StoreViewTableModel extends AbstractTableModel {

    private List<StoreEntity> list;
    private int rowCount = 0;
    private int colCount = 5;
    private String[] columnNames = new String[]{
        "Id", "Name", "Count", "MinCount", "Price"
    };

    public StoreViewTableModel(List<StoreEntity> list) {
        this.list = list;
    }
        
    public void setList(List<StoreEntity> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    @Override
    public int getColumnCount() {
        return colCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StoreEntity entity = list.get(rowIndex);
        Object obj = null;
        switch (columnIndex) {
            case 0:
                obj = (Object) entity.getId();
                break;
            case 1:
                obj = (Object) entity.getProductName();
                break;
            case 2:
                obj = (Object) entity.getCount();
                break;
            case 3:
                obj = (Object) entity.getMinCount();
                break;
            case 4:
                obj = (Object) entity.getPrice();
                break;
            default:
                obj = (Object) new String("-");
                break;
        }
        return obj;
    }

    @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
    }
    
}
