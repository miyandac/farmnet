/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.repository;

import org.springframework.data.repository.CrudRepository;
import zm.co.farmer.farmnet.entity.InventoryItem;

/**
 *
 * @author CHILIKWEM
 */
public interface InventoryItemRepository extends CrudRepository<InventoryItem, Integer> {
    
}
