/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author moz
 */
@Entity
@Table(name = "storage")
public class StorageEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "quantity")
    private Integer count = 0;
    @Column(name = "min_count")
    private Integer minCount = 0;
    private String code;
    private Integer delivery;
    @Column(name = "price")
    private Float price = 0.0f;
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProductName() {
        return productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int quantity) {
        this.count = quantity;
    }

    public int getMinCount() {
        return minCount;
    }

    public void setMinCount(int min_count) {
        this.minCount = min_count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

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
