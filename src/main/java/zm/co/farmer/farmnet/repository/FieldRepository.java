/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import zm.co.farmer.farmnet.entity.Farm;
import zm.co.farmer.farmnet.entity.Field;

/**
 *
 * @author MUNDIAG
 */
public interface FieldRepository extends CrudRepository<Field, Integer>  {
    
    public List<Field> findByCrop(String crop);

    public List<Field> findByFarm(Farm farm);
    
}
