/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zm.co.farmer.farmnet.entity.Yield;
import zm.co.farmer.farmnet.service.YieldService;

/**
 *
 * @author CHILIKWEM
 */
@Controller
public class YieldController {
    @Autowired
    private YieldService yieldService;
    
    
    @RequestMapping(path = {"/yield"}, method =RequestMethod.GET)
    public String viewyield(Model model){
       return "yield";
    }
    
     @RequestMapping(path = {"/yield/add"}, method = RequestMethod.POST)
    public String yield(Model model, @ModelAttribute("crop") String crop,  @ModelAttribute("weight") String weight, @ModelAttribute("dateofyield") String dateofyield) throws ParseException {
     
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date date = format.parse(dateofyield);
        Yield yi = new Yield();
        yi.setCrop(crop);
        yi.setWeight(Double.parseDouble(weight));
        yi.setDateofyield(date);
        
        model.addAttribute("yield");   
        //System.out.println("Crop " + crop);

        return "yield";
        
    }
    
    
}
