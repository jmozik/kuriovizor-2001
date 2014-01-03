/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.ui.sub;

import cz.moz.kuriovizor.domain.Unit2;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author moz
 */
public class LstUnitsModel extends AbstractListModel<Unit2> {
    private List<Unit2> list;

    public LstUnitsModel() {
    }
    
    public LstUnitsModel(List<Unit2> list) {
        this.list = list;
    }
    
    public void setList(List<Unit2> list) {
        this.list = list;
    }
    
    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public Unit2 getElementAt(int index) {
        return this.list.get(index);
    }
    
    public void addStoreEntry(Unit2 storeEntry) {
        this.list.add(storeEntry);
    }
}
