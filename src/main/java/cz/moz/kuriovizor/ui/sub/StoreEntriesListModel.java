/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.ui.sub;


import cz.moz.kuriovizor.domain.StoreEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author moz
 */
public class StoreEntriesListModel extends AbstractListModel<StoreEntity> {
    private List<StoreEntity> list;

    public StoreEntriesListModel() {
        this.list = new ArrayList<>();
    }

    public void setList(List<StoreEntity> list) {
        this.list = list;
    }
    
    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public StoreEntity getElementAt(int index) {
        return this.list.get(index);
    }
    
    public void addStoreEntry(StoreEntity storeEntry) {
        this.list.add(storeEntry);
    }
    
}
