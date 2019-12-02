/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zm.co.farmer.farmnet.entity.Farm;
import zm.co.farmer.farmnet.entity.Field;
import zm.co.farmer.farmnet.entity.User;
import zm.co.farmer.farmnet.service.CropService;
import zm.co.farmer.farmnet.service.FarmService;
import zm.co.farmer.farmnet.service.FieldService;
import zm.co.farmer.farmnet.service.UserService;

/**
 *
 * @author MUNDIAG
 */
@Controller
public class FieldController {

    @Autowired
    private UserService userService;
    @Autowired
    private FarmService farmService;    
    @Autowired
    private FieldService fieldService;
    @Autowired
    private CropService cropService;

    @RequestMapping(path = {"/{farmid}/fields"}, method = RequestMethod.GET)
    public String viewFiels(Model model, @CookieValue("user_session_id") String username, @PathVariable("farmid") Integer farmid) {

        Farm f = farmService.getById(farmid);
        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("farm", f);
        model.addAttribute("fields", fieldService.getFieldsByFarm(f));

        return "field";
    }

    @RequestMapping(path = {"/{farmid}/addfield"}, method = RequestMethod.GET)
    public String addfield(Model model, @CookieValue("user_session_id") String username, @PathVariable("farmid") Integer farmid) {
        Farm f = farmService.getById(farmid);
        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("farm", f);
        
        model.addAttribute("crops", cropService.getAllCrops());

        return "addfield";
    }

    @RequestMapping(path = {"/{farmid}/addfield"}, method = RequestMethod.POST)
    public String addfieldaction(Model model, @CookieValue("user_session_id") String username, @PathVariable("farmid") Integer farmid,
            @ModelAttribute("breadth") Float breadth,
            @ModelAttribute("crop") String crop,
            @ModelAttribute("datecreated") String datecreated,
            @ModelAttribute("length") Float length) throws ParseException {
        Farm farm = farmService.getById(farmid);
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        
        Field f = new Field();
        f.setBreadth(breadth);
        f.setCrop(crop);
        f.setDatecreated(format.parse(datecreated));
        f.setFarm(farm);
        f.setLength(length);
        
        f=fieldService.addField(f);
        

        return "redirect:/"+farm.getId()+"/fields";
    }

}
