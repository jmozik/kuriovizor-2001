/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor;

import cz.moz.kuriovizor.daos.StorageEntitiesDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author moz
 */
public class Test {
    
    public static void main(String[] args) {
        ApplicationContext con = new ClassPathXmlApplicationContext("spring/application-context.xml");
        StorageEntitiesDao dao = con.getBean(StorageEntitiesDao.class);
        
        
    }
    
}
