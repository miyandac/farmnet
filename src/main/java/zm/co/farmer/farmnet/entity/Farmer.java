/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.entity;

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
    private User user;
    private Cooperative cooperative;   

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

    public Cooperative getCooperative() {
        return cooperative;
    }

    public void setCooperative(Cooperative cooperative) {
        this.cooperative = cooperative;
    }

    @Override
    public String toString() {
        return "Farmer{" + "id=" + id + ", user=" + user + ", cooperative=" + cooperative + '}';
    }
    
}
