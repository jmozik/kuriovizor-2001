/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.daos;

import cz.moz.kuriovizor.domain.ItemUnit;
import cz.moz.kuriovizor.domain.Unit;
import cz.moz.kuriovizor.domain.Unit2;
import cz.moz.kuriovizor.domain.UnitEntities;
import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 *
 * @author moz
 */
public interface UnitsDao {
    
//    public void saveUnit(Unit unit);
    
    public void saveUnit(Unit2 unit);
    
    public List<Unit2> getAllUnits();
    
    public Unit getUnit(int id);
    
    public Unit2 getUnit2(int id);
    
    public void updateItemUnit(ItemUnit itemUnit);
    
    public void saveItemUnit(ItemUnit itemUnit);
    
    public void deleteItemUnit(ItemUnit itemUnit);
    
    public UnitEntities getConnection(int id);
    
    public void deleteUnit(Unit2 unit);
    
    public boolean writeUnitOff(Unit2 unit, int count, File reportFile) throws IOException;
}
