/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.co.farmer.farmnet.entity.Farm;
import zm.co.farmer.farmnet.entity.Field;
import zm.co.farmer.farmnet.repository.FieldRepository;

/**
 *
 * @author MUNDIAG
 */
@Service
public class FieldService {
        @Autowired
    private FieldRepository fieldRepository;
    
    public Field addField(Field field){
        return fieldRepository.save(field);
    }
    
}
