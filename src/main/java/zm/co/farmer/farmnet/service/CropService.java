/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.service;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.co.farmer.farmnet.entity.Crop;
import zm.co.farmer.farmnet.repository.CropRepository;

/**
 *
 * @author mumbi
 */
@Service
public class CropService {
    @Autowired
    private CropRepository cropRepository;
    
    public List<Crop> getAllCrops(){
        return Lists.newArrayList(cropRepository.findAll());
    }
    
}
