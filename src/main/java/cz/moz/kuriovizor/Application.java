/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.moz.kuriovizor;

import cz.moz.kuriovizor.domain.ApplContext;
import cz.moz.kuriovizor.ui.ApplicationForm2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.awt.AppContext;

/**
 *
 * @author moz
 */
public class Application {

    private final String propertyFileName = "conf.properties";

    public void run() throws IOException {
        Properties conf = loadProperties();
        if(conf == null) {
            return;
        }
        
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/application-context.xml");
        
        ApplContext ac = appContext.getBean(ApplContext.class);
        ac.setProductionReportsDirectory(conf.getProperty("reportsDirectory"));

        ApplicationForm2 mainForm = appContext.getBean(ApplicationForm2.class);
        mainForm.setTitle("KurioVizor - 2001");
        mainForm.init();
        mainForm.setLocationRelativeTo(null);
        mainForm.setVisible(true);
    }

    private Properties loadProperties() throws IOException {
        File file = new File(propertyFileName);
        if (!file.exists()) {
            
            Properties conf = new Properties();
            conf.setProperty("reportsDirectory", "");
            conf.store(new FileOutputStream(file), "created new property file");
            
            JOptionPane.showMessageDialog(null, "Put data to configuration file: " + file.getAbsolutePath(), "Missing properties file", JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            Properties conf = new Properties();
            conf.load(new FileInputStream(file));
            return conf;
        }
    }

    public static void main(String[] args) throws IOException {
        new Application().run();
    }

}
