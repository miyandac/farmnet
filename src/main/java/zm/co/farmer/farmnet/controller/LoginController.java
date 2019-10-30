/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zm.co.farmer.farmnet.service.UserService;

/**
 *
 * @author CHILIKWEM
 */
@Controller
public class LoginController {
    
    @Autowired
    private UserService userService;

    
    @RequestMapping(path = {"/"})
    public String homepage(Model model) {
        return "login";
    }
    
    @RequestMapping(path = {"/login"})
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(path = {"/home"})
    public String home(Model model) {
        return "home";
    }

    @RequestMapping(path = {"/pageone"})
    public String pageone(Model model) {
        
        // Inject user list
        model.addAttribute("users", userService.getAllUsers());
        
        return "pageone";
    }
}
