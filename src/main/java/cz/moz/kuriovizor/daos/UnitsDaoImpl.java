/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.daos;

import cz.moz.kuriovizor.domain.Unit;
import java.util.List;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author moz
 */
public class UnitsDaoImpl extends CommonDao implements UnitsDao {

    @Transactional
    @Override
    public void saveUnit(Unit unit) {
        getSession().save(unit);
    }

    @Transactional
    @Override
    public List<Unit> getAllUnits() {
        Query query = getSession().createQuery("from Unit");
        return query.list();
    }
    
}
