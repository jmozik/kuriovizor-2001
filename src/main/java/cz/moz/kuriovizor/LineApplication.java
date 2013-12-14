/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor;

import cz.moz.kuriovizor.daos.UnitsDao;
import cz.moz.kuriovizor.domain.Unit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moz
 */
public class LineApplication {
    
    public static void main(String[] args) {
         ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/application-context.xml");
         
//         StorageEntitiesDao dao = appContext.getBean(StorageEntitiesDao.class);
//         
//         System.out.println("Pocet kritickych: " + dao.getCriticalEntries().size());
                           
         UnitsDao dao = appContext.getBean(UnitsDao.class);
         
         Unit unit1 = new Unit();
         unit1.setUnitName("DHW 14");
         unit1.setCode("DHW14");
         
         dao.saveUnit(unit1);
    }
    
}
