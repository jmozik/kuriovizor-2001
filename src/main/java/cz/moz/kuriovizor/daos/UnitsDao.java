/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.daos;

import cz.moz.kuriovizor.domain.Unit;
import java.util.List;

/**
 *
 * @author moz
 */
public interface UnitsDao {
    
    public void saveUnit(Unit unit);
    
    public List<Unit> getAllUnits();
}
