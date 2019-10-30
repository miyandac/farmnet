/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import zm.co.farmer.farmnet.entity.Yield;

/**
 *
 * @author CHILIKWEM
 */
public interface YieldRepository extends CrudRepository<Yield, Integer> {
    
    //public Yield findByYield(Integer yieldid);
    
    public List<Yield> findByCrop(String crop);
    
}
