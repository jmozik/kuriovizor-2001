/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.ui.sub;


import cz.moz.kuriovizor.domain.Unit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author moz
 */
public class UnitsListModel extends AbstractListModel<Unit> {
    private List<Unit> list;

    public UnitsListModel() {
        this.list = new ArrayList<>();
    }

    public void setList(List<Unit> list) {
        this.list = list;
    }
    
    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public Unit getElementAt(int index) {
        return this.list.get(index);
    }
    
    public void addStoreEntry(Unit unit) {
        this.list.add(unit);
    }
    
}
