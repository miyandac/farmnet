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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zm.co.farmer.farmnet.entity.User;
import zm.co.farmer.farmnet.service.UserService;

/**
 *
 * @author MUNDIAG
 */
@Controller
public class FieldController {
    @Autowired
    private UserService userService;
    @RequestMapping(path = {"/fields"}, method = RequestMethod.GET)
    public String viewFiels(Model model, @CookieValue("user_session_id") String username) {

        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);

        return "field";
    }
    
}
