package cz.moz.kuriovizor.services;

import cz.moz.kuriovizor.daos.StorageEntitiesDao;
import cz.moz.kuriovizor.domain.StoreEntity;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
import org.springframework.beans.factory.annotation.Autowired;

public class LoadDocument {

    @Autowired
    private StorageEntitiesDao daoEntity;

    public Sheet importSheet(File file) {
        Sheet mainSheet = null;
        try {
            SpreadSheet odsFile = SpreadSheet.createFromFile(file);
            mainSheet = odsFile.getSheet("Sheet1");
            System.out.println("rouws count: " + mainSheet.getRowCount());
            System.out.println("File has been imported");
        } catch (IOException ex) {
            Logger.getLogger(LoadDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mainSheet;

    }

    public void displaySheet(Sheet sheet) {
        int rowCount = sheet.getRowCount();
        int collumCount = sheet.getColumnCount();
        for (int row = 0; row < rowCount; row++) {
            int collum;
            for (collum = 0; collum < collumCount; collum++) {
                System.out.print(getCellValue(sheet, row, collum, 000) + "|");
            }
            System.out.println("");
        }

    }

    public Object getCellValue(Sheet sheet, int row, int collum, Object defaultValue) {
        try {
            Object cellValue = sheet.getCellAt(collum, row).getValue();
            if (cellValue instanceof String) {
                if (!(defaultValue instanceof String)) {
                    return defaultValue;
                } else {
                    return (String) cellValue;
                }
            } else if (cellValue instanceof BigDecimal) {
                if (defaultValue instanceof Integer) {
                    return new Integer(((BigDecimal) cellValue).intValue());
                } else if (defaultValue instanceof Float) {
                    return new Float(((BigDecimal) cellValue).floatValue());
                } else if(defaultValue instanceof String) {
                    return ((BigDecimal)cellValue).toString();
                } else {
                    System.out.println("Jiny datovy typ: " + defaultValue.getClass().getName());
                }

            }

            return sheet.getCellAt(collum, row).getValue();
        } catch (IndexOutOfBoundsException e) {
            return defaultValue;
        }
    }

    public StoreEntity createStorageEntity(Sheet sheet, int row) {
        StoreEntity storageEntity = new StoreEntity();

        int id = (int) getCellValue(sheet, row, 0, new Integer(0));
        String company = (String) getCellValue(sheet, row, 1, new String("null"));
        String name = (String) getCellValue(sheet, row, 2, new String("null"));
        int count = (int) getCellValue(sheet, row, 3, new Integer(0));
        int minCount = (int) getCellValue(sheet, row, 4, new Integer(0));
        String code = (String) getCellValue(sheet, row, 5, new String("null"));
        int delivery = (int) getCellValue(sheet, row, 6, new Integer(0));
        float price = (float) getCellValue(sheet, row, 7, new Float(0.0f));

        storageEntity.setId(id);
        storageEntity.setCompany(company);
        storageEntity.setProductName(name);
        storageEntity.setCount(count);
        storageEntity.setMinCount(minCount);
        storageEntity.setCode(code);
        storageEntity.setDelivery(delivery);
        storageEntity.setPrice(price);
        return storageEntity;

    }

    public void importEntities(Sheet sheet) {
        int objectCount = sheet.getRowCount();
        Boolean isInDat;
        for (int i = 1; i < objectCount; i++) {
            StoreEntity newEntity = createStorageEntity(sheet, i);
            isInDat = isInDatabase(newEntity.getId());
            if(isInDat == true){
            daoEntity.updateEntity(newEntity);
                System.out.println("Updating entity: " + newEntity.getProductName());
            }
            else{
            daoEntity.saveEntity(newEntity);
                System.out.println("Saving entity: " + newEntity.getProductName());

                
            }
        }
    }

    public Boolean isInDatabase(int id) {
        if(daoEntity.getEntity(id) != null) {
            return true;
        } else {
            return false;
        }

    }

//    public static void main(String args[]) {
//        Sheet importedSheet = importSheet(file);
//        //displaySheet(importedSheet);
//        StoreEntity entity = createRowStorageEntity(importedSheet, 1);
//        System.out.println(entity.getId() + " " + entity.getProductName() + " " + entity.getCode());
//    }
}
