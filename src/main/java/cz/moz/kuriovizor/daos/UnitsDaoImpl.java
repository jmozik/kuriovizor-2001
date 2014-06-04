/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.moz.kuriovizor.daos;

import cz.moz.kuriovizor.domain.Item;
import cz.moz.kuriovizor.domain.ItemUnit;
import cz.moz.kuriovizor.domain.Unit;
import cz.moz.kuriovizor.domain.Unit2;
import cz.moz.kuriovizor.domain.UnitEntities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    public List<Unit2> getAllUnits() {
        Query query = getSession().createQuery("from Unit2");
        return query.list();
    }

    @Transactional
    @Override
    public Unit getUnit(int id) {
        Query query = getSession().createQuery("from Unit as u where u.id = '" + id + "'");
        return (Unit) query.list().get(0);
    }

    @Transactional
    @Override
    public UnitEntities getConnection(int id) {
        Query query = getSession().createQuery("from UnitEntities as u where u.id = '" + id + "'");
        return (UnitEntities) query.list().get(0);
    }

    @Transactional
    @Override
    public Unit2 getUnit2(int id) {
        Query query = getSession().createQuery("from Unit2 as u where u.id = '" + id + "'");
        List list = query.list();
        if (list.size() > 0) {
            return (Unit2) list.get(0);
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public void updateItemUnit(ItemUnit itemUnit) {
        getSession().update(itemUnit);
    }

    @Transactional
    @Override
    public void saveItemUnit(ItemUnit itemUnit) {
        getSession().saveOrUpdate(itemUnit);
    }

    @Transactional
    @Override
    public void deleteItemUnit(ItemUnit itemUnit) {
        getSession().delete(itemUnit);
    }

    @Transactional
    @Override
    public void deleteUnit(Unit2 unit) {

        for (ItemUnit itemUnit : unit.getItems()) {
            deleteItemUnit(itemUnit);
        }
        getSession().delete(unit);
    }

    @Transactional
    @Override
    public boolean writeUnitOff(Unit2 unit, int count, File reportFile) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");

        File actDir = new File("./" + sdf.format(new Date()) + "-" + unit.getUnitName());
        System.out.println("actDir: " + actDir.getAbsolutePath());

        String report = "Produce unit: " + unit.getUnitName();
        report += "\nin count: " + count + "\n\n";
        report += "Dependent Items from store:\n";
        report += "Id; Item name; Writed off the store; Actual state in store\n";

        if (unit.isAvailable() && unit.getAvailableCount() >= count) {
            for (ItemUnit itemUnit : unit.getItems()) {
                report += itemUnit.getItem().getId() + ";" + itemUnit.getItem().getProductName() + ";" + itemUnit.getRequiredCount() + ";";
                deductItemCount(itemUnit.getItem(), itemUnit.getRequiredCount() * count);
                report += itemUnit.getItem().getCount() + "\n";
            }
        }

        try {
            PrintWriter writer = new PrintWriter(reportFile);
            writer.print(report);
            writer.close();
            System.out.println("Output data saved to " + reportFile.getAbsolutePath());
            return true;
        } catch (FileNotFoundException ex) {
            throw new MyReportFileCreationException(ex, reportFile, "File " + reportFile.getAbsolutePath() + " not found.");
        }

    }

    @Transactional
    private void deductItemCount(Item item, int count) {
        int newValue = item.getCount() - count;
        item.setCount(newValue);
        getSession().update(item);
    }

    @Transactional
    private Item getItem(Integer id) {
        Query query = getSession().createQuery("from Item as item where item.id = '" + id + "'");
        List list = query.list();
        if (list.size() > 0) {
            return (Item) list.get(0);
        } else {
            return null;
        }
    }

}
