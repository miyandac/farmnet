/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zm.co.farmer.farmnet.entity.Farm;
import zm.co.farmer.farmnet.entity.FarmEvent;
import zm.co.farmer.farmnet.entity.Field;
import zm.co.farmer.farmnet.entity.User;
import zm.co.farmer.farmnet.service.FarmService;
import zm.co.farmer.farmnet.service.FieldEventService;
import zm.co.farmer.farmnet.service.FieldService;
import zm.co.farmer.farmnet.service.UserService;

/**
 *
 * @author Mumbi Chishimba
 */
@Controller
public class FieldEventController {

    @Autowired
    private UserService userService;
    @Autowired
    private FarmService farmService;

    @Autowired
    private FieldService fieldService;

    @Autowired
    private FieldEventService fieldeventservice;

    @RequestMapping(path = {"/{fieldid}/events"}, method = RequestMethod.GET)
    public String viewFiels(Model model, @CookieValue("user_session_id") String username, @PathVariable("fieldid") Integer fieldId) {

        Field field = fieldService.findById(fieldId);
        Farm f = farmService.getById(field.getFarm().getId());
        User user = userService.getUserByUsername(username);

        model.addAttribute("user", user);
        model.addAttribute("farm", f);
        model.addAttribute("events", farmService.getFarmEventsByField(field));
        model.addAttribute("field", field);

        return "event";
    }

    @RequestMapping(path = {"/{fieldid}/addfieldevent"}, method = RequestMethod.GET)
    public String addfieldEventGet(Model model, @CookieValue("user_session_id") String username, @PathVariable("fieldid") Integer fieldId) {

        FarmEvent fe = new FarmEvent();
        Field field = fieldService.findById(fieldId);

        Farm f = farmService.getById(field.getFarm().getId());
        User user = userService.getUserByUsername(username);

        model.addAttribute("user", user);
        model.addAttribute("farm", f);
        model.addAttribute("field", field);

        return "addfieldevent";
    }

    @RequestMapping(path = {"/{fieldid}/addfieldevent"}, method = RequestMethod.POST)
    public String addfieldEvent(Model model,
            @ModelAttribute("description") String description,
            @ModelAttribute("eventreport") String event,
            @ModelAttribute("dateofevent") @DateTimeFormat(pattern ="yyyy-mm-dd") Date dateofevent,
            @ModelAttribute("farm") Integer farmId,
            @ModelAttribute("field") Integer fieldId, @CookieValue("user_session_id") String username) {

        User user = userService.getUserByUsername(username);

        FarmEvent fe = new FarmEvent();
        fe.setDescription(description);
        fe.setEventreport(event);
        fe.setDateofevent(dateofevent);

        fe.setFarm(farmService.getById(farmId));
        fe.setField(fieldService.getFieldById(fieldId));
        fe.setCreatedby(user);

        fe = fieldeventservice.addfarmEvent(fe);

        return "redirect:/" + fieldId + "/events";
    }

}
