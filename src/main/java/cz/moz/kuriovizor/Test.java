/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.moz.kuriovizor;

import cz.moz.kuriovizor.daos.UnitsDao;
import cz.moz.kuriovizor.domain.Unit;
import cz.moz.kuriovizor.domain.UnitEntities;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moz
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext con = new ClassPathXmlApplicationContext("spring/application-context.xml");
//        StorageEntitiesDao dao = con.getBean(StorageEntitiesDao.class);
        UnitsDao unitsDao = con.getBean(UnitsDao.class);

//        Unit unit = new Unit();
//        unit.setUnitName("Koloběžka");
//        unit.setCode("HWE14");
//        
//        unitsDao.saveUnit(unit);
//        
//        System.out.println("Pocet polozek units: " + unitsDao.getAllUnits().size());
        Unit u = unitsDao.getUnit(1);
        System.out.println("Jednotka " + u.getUnitName());
        
        UnitEntities ue = unitsDao.getConnection(1);
        System.out.println("ue: " + ue.getEntity_id());
//        System.out.println("pocet polozek skladu: " + u.getEntities().size());

    }

}
