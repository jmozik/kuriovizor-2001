/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.moz.kuriovizor.daos;

import cz.moz.kuriovizor.domain.StorageEntity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author moz
 */
@Repository("storageEntitiesDao")
public class StorageEntitiesDaoImpl extends CommonDao implements StorageEntitiesDao {

    @Transactional
    public List<StorageEntity> getAllEntities() {
        Query query = getSession().createQuery("from StorageEntity");
        return query.list();
    }

    @Transactional
    public void saveEntity(StorageEntity entity) {
        getSession().save(entity);
    }

    @Transactional
    public StorageEntity getEntity(int id) {
        Query query = getSession().createQuery("from StorageEntity as se where se.id = '" + id + "'");
        return (StorageEntity) query.list().get(0);
    }

    @Transactional
    public List<StorageEntity> getCriticalEntries() {
        Query query = getSession().createQuery("from StorageEntity as se where se.count <= se.minCount");
        return query.list();
    }

    @Transactional
    public boolean substractEntityCount(int id, int count) {
        return substractEntityCount(getEntity(id), count);
    }

    @Transactional
    public boolean substractEntityCount(StorageEntity entity, int count) {
        if (entity != null) {
            if (entity.getCount() - count >= 0) {
                entity.setCount(entity.getCount() - count);
                getSession().update(entity);
                return true;
            }
        }
        return false;
    }

    @Transactional
    public void importCSVFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line = null;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            line += ";";
            String[] data = line.split("#");
            StorageEntity entity = createStorageEntityFromLine(data);
            saveEntity(entity);
        }
        reader.close();

    }

    private StorageEntity createStorageEntityFromLine(String[] line) {
        if (line.length != 8) {
            System.out.println("Vyskytl se problem s parsovanim zaznamu na radku " + line[0]);
            return null;
        }

        StorageEntity entity = new StorageEntity();
        entity.setCompany(line[1]);
        entity.setProductName(line[2].replace("\"", ""));
        if (!line[3].equals("")) {
            entity.setCount(Integer.valueOf(line[3]));
        }
        if (!line[4].equals("")) {
            entity.setMinCount(Integer.valueOf(line[4]));
        }
        entity.setCode(line[5]);
        if (!line[6].equals("")) {
            entity.setDelivery(Integer.valueOf(line[6]));
        }
        if (!line[7].equals("") && !line[7].equals(";")) {
            if (line[7].contains(",")) {
                line[7] = line[7].replace(",", ".");
            }
            if(line[7].contains(";"))
                line[7] = line[7].replace(";", "");
            entity.setPrice(Float.valueOf(line[7]));
        }

        return entity;
    }
    
    @Transactional
    public int getUnitsCount() {
        return getAllEntities().size();
    }

}
