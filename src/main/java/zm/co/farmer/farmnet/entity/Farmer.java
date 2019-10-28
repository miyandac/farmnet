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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author MUNDIAG
 */
@Entity
@Table(name = "fisp_farmer")
public class Farmer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    private Integer id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Govtcoperative govtcoperative;

    public Farmer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Govtcoperative getGovtcoperative() {
        return govtcoperative;
    }

    public void setGovtcoperative(Govtcoperative govtcoperative) {
        this.govtcoperative = govtcoperative;
    }

    @Override
    public String toString() {
        return "Farmer{" + "id=" + id + ", user=" + user + ", govtcoperative=" + govtcoperative + '}';
    }
    
        
}
