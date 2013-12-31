/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.ui.sub;

import cz.moz.kuriovizor.domain.Item;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author moz
 */
public class LstItemsModel extends AbstractListModel<Item>  {
    private List<Item> list;

    public void setList(List<Item> list) {
        this.list = list;
    }
    
    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public Item getElementAt(int index) {
        return this.list.get(index);
    }
    
    public void addStoreEntry(Item storeEntry) {
        this.list.add(storeEntry);
    }
}
