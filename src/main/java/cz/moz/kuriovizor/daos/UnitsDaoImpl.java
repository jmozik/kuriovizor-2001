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
    public void saveUnit(Unit2 unit) {
//        getSession().save(unit);
        getSession().saveOrUpdate(unit);
    }

    @Transactional
    @Override
    public List<Unit> getAllUnits() {
        Query query = getSession().createQuery("from Unit");
        return query.list();
    }

    @Transactional
    @Override
    public Unit getUnit(int id) {
        Query query = getSession().createQuery("from Unit as u where u.id = '" + id + "'");
        return (Unit)query.list().get(0);
    }

    @Transactional
    @Override
    public UnitEntities getConnection(int id) {
        Query query = getSession().createQuery("from UnitEntities as u where u.id = '" + id + "'");
        return (UnitEntities)query.list().get(0);
    }

    @Transactional
    @Override
    public Unit2 getUnit2(int id) {
        Query query = getSession().createQuery("from Unit2 as u where u.id = '" + id + "'");
        List list = query.list();
        if(list.size() > 0)
        return (Unit2)list.get(0);
        else
        return null;    
    }
    @Transactional
    @Override
    public void updateItemUnit(ItemUnit itemUnit) {
        getSession().update(itemUnit);
    }
    
    
    
}
