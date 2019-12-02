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
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zm.co.farmer.farmnet.entity.User;
import zm.co.farmer.farmnet.entity.Yield;
import zm.co.farmer.farmnet.service.CropService;
import zm.co.farmer.farmnet.service.UserService;
import zm.co.farmer.farmnet.service.YieldService;

/**
 *
 * @author CHILIKWEM
 */
@Controller
public class YieldController {
    
    @Autowired
    private YieldService yieldService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CropService cropService;
    
   
    @RequestMapping(path = {"/addyield"}, method =RequestMethod.GET)
    public String addyield(Model model, @CookieValue("user_session_id") String username){
        
        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("crops", cropService.getAllCrops());
        
       return "addyield";
    }
    
    @RequestMapping(path = {"/addyield"}, method = RequestMethod.POST)
    public String yield(Model model, 
            @ModelAttribute("crop") String crop,  
            @ModelAttribute("weight") String weight, 
            @ModelAttribute("quantity") Float quantity, 
            @ModelAttribute("dateofyield") String dateofyield) throws ParseException {
     
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date date = format.parse(dateofyield);
        Yield yield = new Yield();
        yield.setCrop(crop);
        yield.setWeight(Double.parseDouble(weight));
        yield.setDateofyield(date);
        yield.setQuantity(quantity);
        
        yield = yieldService.addOrUpdate(yield);
        
        return "redirect:/yield";
        
    }
    

    @RequestMapping(path = {"/yield"})
    public String viewyield(Model model) {

        // Inject user list
        model.addAttribute("yield", yieldService.getYield());

        return "yield";
    }
   
}
