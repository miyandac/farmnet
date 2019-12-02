/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.co.farmer.farmnet.entity.FarmEvent;
import zm.co.farmer.farmnet.repository.FarmEventRepository;

/**
 *
 * @author CHILIKWEM
 */
@Service
public class FieldEventService {
    @Autowired
    private FarmEventRepository farmEventRepository;
    
    public FarmEvent addfarmEvent(FarmEvent f){
        
        return farmEventRepository.save(f);
    }

  
}
