/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.daos;

import cz.moz.kuriovizor.domain.StorageEntity;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author moz
 */
public interface StorageEntitiesDao {
    
    public List<StorageEntity> getAllEntities();
    
    public void saveEntity(StorageEntity entity);
    
    public StorageEntity getEntity(int id);
    
    public List<StorageEntity> getCriticalEntries();
    
    public boolean substractEntityCount(int id, int count);
    
    public boolean substractEntityCount(StorageEntity entity, int count);
    
    public void importCSVFile(File file) throws IOException;

    public int getUnitsCount();
}
