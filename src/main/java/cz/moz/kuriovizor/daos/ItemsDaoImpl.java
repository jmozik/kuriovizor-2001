/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.daos;

import cz.moz.kuriovizor.domain.Item;
import java.util.List;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author moz
 */
public class ItemsDaoImpl extends CommonDao implements ItemsDao {

    @Transactional
    @Override
    public List<Item> getAllItems() {
        Query query = getSession().createQuery("from Item");
        return query.list();
    }
    
}
