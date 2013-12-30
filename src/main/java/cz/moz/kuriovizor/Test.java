/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.moz.kuriovizor;

import cz.moz.kuriovizor.daos.StorageEntitiesDao;
import cz.moz.kuriovizor.daos.UnitsDao;
import cz.moz.kuriovizor.domain.ItemUnit;
import cz.moz.kuriovizor.domain.StoreEntity;
import cz.moz.kuriovizor.domain.Unit;
import cz.moz.kuriovizor.domain.Unit2;
import cz.moz.kuriovizor.ui.UnitDialog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moz
 */
public class Test {
    
    public void addUnits() {
        ApplicationContext con = new ClassPathXmlApplicationContext("spring/application-context.xml");
        UnitsDao unitsDao = con.getBean(UnitsDao.class);
                                
        unitsDao.saveUnit(new Unit("HWE 14", "HWE14"));
        unitsDao.saveUnit(new Unit("HW 14", "HW14"));
        unitsDao.saveUnit(new Unit("HWE 23", "HWE23"));
        unitsDao.saveUnit(new Unit("HW 23", "HW23"));
    }
    
    public void test_01() {
        ApplicationContext con = new ClassPathXmlApplicationContext("spring/application-context.xml");
//        StorageEntitiesDao dao = con.getBean(StorageEntitiesDao.class);
        UnitsDao unitsDao = con.getBean(UnitsDao.class);
        StorageEntitiesDao entitiesDao = con.getBean(StorageEntitiesDao.class);

        StoreEntity entity = entitiesDao.getEntity(1);
        System.out.println("entity: " + entity.getProductName());
//        System.out.println("in units: " + entity.getUnitsList().size());

//        Unit unit = new Unit();
//        unit.setUnitName("Koloběžka");
//        unit.setCode("HWE14");
//        
//        unitsDao.saveUnit(unit);
//        
//        System.out.println("Pocet polozek units: " + unitsDao.getAllUnits().size());
        Unit2 u = unitsDao.getUnit2(1);
//        System.out.println("Jednotka " + u.getUnitName());
//        System.out.println("Nalezi k jednotkam: " + u.get);
//        
//        Unit u = unitsDao.getUnit(1);
//        System.out.println("ue: " + u.getUnitName());
//        System.out.println("obsahuje polozek ze skladu: " + u.getEntitiesList().size());
//        for (StoreEntity e : u.getEntitiesList()) {
//            System.out.println("nazev: " + e.getProductName());
//        }

        UnitDialog dialog = new UnitDialog(new javax.swing.JFrame(), true);
        dialog.setStoreDao(entitiesDao);
        dialog.setUnit(u);
        dialog.initData();
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }
    
    public void test_02() {
        ApplicationContext con = new ClassPathXmlApplicationContext("spring/application-context.xml");
        UnitsDao unitsDao = con.getBean(UnitsDao.class);
        
        Unit2 u = unitsDao.getUnit2(1);
        System.out.println("Ziskana jednotka " + u.getUnitName());
        System.out.println("je slozena z " + u.getItems().size() + " polozek skladu");
        if(u.getItems().size() > 0) {
            for(ItemUnit item : u.getItems()) {
                System.out.println("\tpolozka: " + item.getItem().getProductName() + "; count: " + item.getRequiredCount());
            }
        }
    }

    public static void main(String[] args) {
        new Test().test_01();
    }

}
