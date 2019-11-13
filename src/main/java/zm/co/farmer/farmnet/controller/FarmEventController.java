/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zm.co.farmer.farmnet.entity.Farm;
import zm.co.farmer.farmnet.entity.Field;
import zm.co.farmer.farmnet.entity.User;
import zm.co.farmer.farmnet.service.FarmService;
import zm.co.farmer.farmnet.service.FieldService;
import zm.co.farmer.farmnet.service.UserService;

/**
 *
 * @author Mumbi Chishimba
 */


@Controller
public class FarmEventController {
    
    
    @Autowired
    private UserService userService;
    @Autowired
    private FarmService farmService;
    
    @Autowired
    private FieldService fieldService;
    
    @RequestMapping(path = {"/{fieldid}/events"}, method = RequestMethod.GET)
    public String viewFiels(Model model, @CookieValue("user_session_id") String username, @PathVariable("fieldid") Integer fieldId) {

        Field field = fieldService.findById(fieldId);
        Farm f = farmService.getById(field.getFarm().getId());
        User user = userService.getUserByUsername(username);
        
        model.addAttribute("user", user);
        model.addAttribute("farm", f);
        model.addAttribute("events", farmService.getFarmEventsByField(field)); 

        return "event";
    }
}
