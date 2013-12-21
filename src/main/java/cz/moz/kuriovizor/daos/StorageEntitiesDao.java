/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.daos;

import cz.moz.kuriovizor.domain.StoreEntity;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author moz
 */
public interface StorageEntitiesDao {
    
    public List<StoreEntity> getAllEntities();
    
    public void saveEntity(StoreEntity entity);
    
    public void updateEntity(StoreEntity entity);
    
    public StoreEntity getEntity(int id);
    
    public void deleteEntity(int id);
    
    public List<StoreEntity> getCriticalEntries();
    
    public boolean substractEntityCount(int id, int count);
    
    public boolean substractEntityCount(StoreEntity entity, int count);
    
    public void importCSVFile(File file) throws IOException;

    public int getUnitsCount();
}
