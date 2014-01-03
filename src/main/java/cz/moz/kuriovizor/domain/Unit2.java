/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.moz.kuriovizor.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author moz
 */
@Entity
@Table(name = "UNITS")
public class Unit2 implements Serializable {

    private Integer id;
    private String unitName;
//    private String code;
    private List<ItemUnit> items;

    public void setItems(List<ItemUnit> items) {
        this.items = items;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.unit")
    public List<ItemUnit> getItems() {
        return items;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "UNIT_NAME", nullable = false)
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

//    @Column(name = "CODE")
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }

    @Transient
    public boolean isAvailable() {
        for (ItemUnit itemUnit : getItems()) {
            if (itemUnit.getItem().getCount() < itemUnit.getRequiredCount()) {
                return false;
            }
        }
        return true;
    }
    
    @Transient
    public int getAvailableCount() {
        if(getItems().isEmpty())
            return -1;
        
        int[] availableCounts = new int[getItems().size()];
        for (int i = 0; i < getItems().size(); i++) {
            ItemUnit itemUnit = getItems().get(i);
            availableCounts[i] = itemUnit.getItem().getCount() / itemUnit.getRequiredCount();
        }
        
        int minCount = availableCounts[0];
        for(int count : availableCounts) {
            if(count < minCount)
                minCount = count;
        }
        
        return minCount;
    }

}
