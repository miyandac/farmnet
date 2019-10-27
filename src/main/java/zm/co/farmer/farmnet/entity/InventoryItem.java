/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author dhulfa.abdallah
 */
@Entity
@Table(name="fisp_inventoryitem")
public class InventoryItem {
    //create fields to be inside an inventory
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Integer id;
    private String name;
    private String type;
    private String supplier;
    private Float quantity;
    private String quantity_type;
    private String batchid;
    private String barcodenumber;

    public InventoryItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public String getQuantity_type() {
        return quantity_type;
    }

    public void setQuantity_type(String quantity_type) {
        this.quantity_type = quantity_type;
    }

    public String getBatchid() {
        return batchid;
    }

    public void setBatchid(String batchid) {
        this.batchid = batchid;
    }

    public String getBarcodenumber() {
        return barcodenumber;
    }

    public void setBarcodenumber(String barcodenumber) {
        this.barcodenumber = barcodenumber;
    }  

    @Override
    public String toString() {
        return "InventoryItem{" + "id=" + id + ", name=" + name + ", type=" + type + ", supplier=" + supplier + ", quantity=" + quantity + ", quantity_type=" + quantity_type + ", batchid=" + batchid + ", barcodenumber=" + barcodenumber + '}';
    }
    
}
