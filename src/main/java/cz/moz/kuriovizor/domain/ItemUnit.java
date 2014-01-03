/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.moz.kuriovizor.domain;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author moz
 */
@Entity
@Table(name = "UNITS_ENTITIES")
@AssociationOverrides({
    @AssociationOverride(name = "pk.item", joinColumns = @JoinColumn(name = "STORAGE_ID")),
    @AssociationOverride(name = "pk.unit", joinColumns = @JoinColumn(name = "UNIT_ID"))})
public class ItemUnit implements Serializable {

    private ItemUnitId pk = new ItemUnitId();
//    private Integer id;
    private Integer requiredCount;

    public ItemUnit() {
    }
    
    @SuppressWarnings("empty-statement")
    public ItemUnit(Item item, Unit2 unit, int requiredCount) {
        this.pk.setItem(item);
        this.pk.setUnit(unit);
        this.requiredCount = requiredCount;
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
        
    @EmbeddedId
    public ItemUnitId getPk() {
        return pk;
    }

    public void setPk(ItemUnitId pk) {
        this.pk = pk;
    }

    @Transient
    public Item getItem() {
        return getPk().getItem();
    }

    public void setItem(Item item) {
        getPk().setItem(item);
    }

    @Transient
    public Unit2 getUnit() {
        return getPk().getUnit();
    }

    public void setUnit(Unit2 unit) {
        getPk().setUnit(unit);
    }

    @Column(name = "REQUIRED_COUNT")
    public int getRequiredCount() {
        return requiredCount;
    }

    public void setRequiredCount(int requiredCount) {
        this.requiredCount = requiredCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ItemUnit that = (ItemUnit) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

}
