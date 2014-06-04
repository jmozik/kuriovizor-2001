/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.domain;

import java.io.File;

/**
 *
 * @author moz
 */
public class ApplContext {
    private String productionReportsDirectory;

    public String getProductionReportsDirectory() {
        char lastChar = productionReportsDirectory.charAt(productionReportsDirectory.length() - 1);
        if(lastChar == '/' || lastChar == '\\') {
            return productionReportsDirectory;
        } else
            return productionReportsDirectory + File.separator;
    }

    public void setProductionReportsDirectory(String productionReportsDirectory) {
        this.productionReportsDirectory = productionReportsDirectory;
    }
    
    public static void main(String[] args) {
        
        ApplContext ac = new ApplContext();
        ac.setProductionReportsDirectory("C:\\Users\\moz\\Documents\\NetBeansProjects\\emil\\kuriovizor-2001");
        
        System.out.println("path: " + ac.getProductionReportsDirectory());
    }
}
