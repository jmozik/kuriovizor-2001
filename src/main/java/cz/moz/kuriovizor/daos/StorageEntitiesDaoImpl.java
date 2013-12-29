/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.moz.kuriovizor.daos;

import cz.moz.kuriovizor.domain.StoreEntity;
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
    @Override
    public List<StoreEntity> getAllEntities() {
        Query query = getSession().createQuery("from StoreEntity");
        return query.list();
    }

    @Transactional
    @Override
    public void saveEntity(StoreEntity entity) {
        getSession().save(entity);
    }

    @Transactional
    @Override
    public void updateEntity(StoreEntity entity) {
        getSession().update(entity);
    }

    @Transactional
    @Override
    public StoreEntity getEntity(int id) {
        Query query = getSession().createQuery("from StoreEntity as se where se.id = '" + id + "'");
        List list = query.list();
        if (list.size() > 0) {
            return (StoreEntity) list.get(0);
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public List<StoreEntity> getCriticalEntries() {
        Query query = getSession().createQuery("from StoreEntity as se where se.count <= se.minCount");
        return query.list();
    }

    @Transactional
    @Override
    public void deleteEntity(int id) {
        Query query = getSession().createQuery("delete from StoreEntity as e where e.id = :id");
        query.setInteger("id", id);
        int affected = query.executeUpdate();
        System.out.println("Deleted " + affected + " records.");
    }

    @Transactional
    @Override
    public boolean substractEntityCount(int id, int count) {
        return substractEntityCount(getEntity(id), count);
    }

    @Transactional
    @Override
    public boolean substractEntityCount(StoreEntity entity, int count) {
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
    @Override
    public void importCSVFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line = null;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            line += ";";
            String[] data = line.split("#");
            StoreEntity entity = createStorageEntityFromLine(data);
            saveEntity(entity);
        }
        reader.close();

    }

    private StoreEntity createStorageEntityFromLine(String[] line) {
        if (line.length != 8) {
            System.out.println("Vyskytl se problem s parsovanim zaznamu na radku " + line[0]);
            return null;
        }

        StoreEntity entity = new StoreEntity();
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
            if (line[7].contains(";")) {
                line[7] = line[7].replace(";", "");
            }
            entity.setPrice(Float.valueOf(line[7]));
        }

        return entity;
    }

    @Transactional
    public int getUnitsCount() {
        return getAllEntities().size();
    }

}
