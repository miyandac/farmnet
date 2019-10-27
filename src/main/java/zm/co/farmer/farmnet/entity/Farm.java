package zm.co.farmer.farmnet.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ega
 */
@Entity 
@Table(name="fisp_farm")
public class Farm {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Integer id;
    private String location;
    private String name;
    private float length;
    private float bridth;
    private User user;

    public Farm(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getBridth() {
        return bridth;
    }

    public void setBridth(float bridth) {
        this.bridth = bridth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Farm{" + "id=" + id + ", location=" + location + ", name=" + name + ", length=" + length + ", bridth=" + bridth + ", user=" + user + '}';
    }



}