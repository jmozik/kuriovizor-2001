/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.ui.sub;

import cz.moz.kuriovizor.domain.UnitToProduce;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author moz
 */
public class TblUnitsToProduceModel extends AbstractTableModel {
    private List<UnitToProduce> list;
    private int colCount = 3;
    private final String[] columnNames = new String[]{
        "Id", "Name", "Quantity"
    };

    public TblUnitsToProduceModel(List<UnitToProduce> list) {
        this.list = list;
    }

    public List<UnitToProduce> getList() {
        if(list == null)
            this.list = new ArrayList<UnitToProduce>();
        return list;
    }
    
    @Override
    public int getRowCount() {
        return getList().size();
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UnitToProduce u2p = list.get(rowIndex);
        Object obj = null;
        switch (columnIndex) {
            case 0:
                obj = (Object) u2p.getUnit().getId();
                break;
            case 1:
                obj = (Object) u2p.getUnit().getUnitName();
                break;
            case 2:
                obj = (Object) u2p.getCount();
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
