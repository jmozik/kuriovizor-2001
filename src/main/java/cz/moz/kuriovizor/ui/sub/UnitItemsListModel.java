/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.ui.sub;

import cz.moz.kuriovizor.domain.ItemUnit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author moz
 */
public class UnitItemsListModel extends AbstractListModel<ItemUnit> {
    private List<ItemUnit> list;

    public UnitItemsListModel() {
        this.list = new ArrayList<>();
    }

    public void setList(List<ItemUnit> list) {
        this.list = list;
    }
    
    @Override
    public int getSize() {
        return this.list.size();
    }
    
    @Override
    public ItemUnit getElementAt(int index) {
        return this.list.get(index);
    }
    
    public void addStoreEntry(ItemUnit storeEntry) {
        this.list.add(storeEntry);
    }
}
