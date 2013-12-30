/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.moz.kuriovizor.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author moz
 */
@Entity
@Table(name = "STORAGE")
public class Item implements Serializable {

    private Integer id;
    private String company;
    private String productName;
    private Integer count = 0;
    private Integer minCount = 0;
    private String code;
    private Integer delivery;
    private Float price = 0.0f;
    private Set<ItemUnit> units;

    public Item() {
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.item", cascade = CascadeType.ALL)
    public Set<ItemUnit> getUnits() {
        return units;
    }

    public void setUnits(Set<ItemUnit> units) {
        this.units = units;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "COMPANY")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    @Column(name = "QUANTITY")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer quantity) {
        this.count = quantity;
    }

    @Column(name = "MIN_COUNT")
    public Integer getMinCount() {
        return minCount;
    }

    public void setMinCount(Integer min_count) {
        this.minCount = min_count;
    }

    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "DELIVERY")
    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    @Column(name = "PRICE")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProductName(String product_name) {
        this.productName = product_name;
    }

}
