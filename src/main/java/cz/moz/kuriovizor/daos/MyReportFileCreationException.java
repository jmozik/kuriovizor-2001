/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.daos;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author moz
 */
public class MyReportFileCreationException extends IOException {
    private File file;

    public MyReportFileCreationException(Exception e, File f, String message) {
        super();
        
        this.file = file;
    }

    public File getFile() {
        return file;
    }
    
    
    
    
}
