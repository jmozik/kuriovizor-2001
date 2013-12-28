/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.ui.sub;

import cz.moz.kuriovizor.domain.Unit;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author moz
 */
public class UnitViewTableModel extends AbstractTableModel {
    private List<Unit> data;
    private int rowCount = 0;
    private int colCount = 3;
    private String[] columnNames = new String[]{
        "Id", "Name", "Code"
    };

    public void setData(List<Unit> data) {
        this.data = data;
    }

    public List<Unit> getData() {
        return data;
    }
    
    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Unit unit = data.get(rowIndex);
        Object obj = null;
        switch (columnIndex) {
            case 0:
                obj = (Object) unit.getId();
                break;
            case 1:
                obj = (Object) unit.getUnitName();
                break;
            case 2:
                obj = (Object) unit.getCode();
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
