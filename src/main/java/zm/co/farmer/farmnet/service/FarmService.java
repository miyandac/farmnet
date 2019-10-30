/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.co.farmer.farmnet.entity.Farm;
import zm.co.farmer.farmnet.repository.FarmRepository;

/**
 *
 * @author CHILIKWEM
 * Farm repository
 */
@Service
public class FarmService {
    @Autowired
    private FarmRepository farmRepository;
    
    public Farm addFarm(Farm farm){
        return farmRepository.save(farm);
    }
    
    
    
    
}
