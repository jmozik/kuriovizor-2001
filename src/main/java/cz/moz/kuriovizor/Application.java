/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor;

import cz.moz.kuriovizor.ui.ApplicationForm;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author moz
 */
public class Application {
    
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/application-context.xml");
        
//        StorageEntitiesDao dao =  appContext.getBean(StorageEntitiesDao.class);
        
        ApplicationForm mainForm = appContext.getBean(ApplicationForm.class);
        mainForm.init();
        mainForm.setVisible(true);
        
//        StorageEntity s = new StorageEntity();
//        s.setProductName("Hliníková lišta dveří, délka 1450mm");
//        s.setCount(22);
//        
////        dao.saveEntity(s);
//        
//        System.out.println("count: " + dao.getAllEntities().size());
//        
//        StorageEntity se = dao.getEntity(4);
//        System.out.println("nalezena entita: " + se.getProductName() + " pocet: " + se.getCount());
//        
//        System.out.println("pokus o odecteni kusu: " + dao.substractEntityCount(2, 2));
//        
//        List<StorageEntity> listCritical = dao.getCriticalEntries();
//        for(StorageEntity entity : listCritical) {
//            System.out.println("Id: " + entity.getId() + " - " + entity.getProductName() + "; requ.: " + entity.getMinCount() + " actual: " + entity.getCount());
//        }
        
//        File file = new File("C:\\Users\\moz\\Desktop\\Emil\\inventarizace.csv");
//        try {
//            dao.importCSVFile(file);
//        } catch (IOException ex) {
//            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
