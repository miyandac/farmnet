/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author CHILIKWEM
 */
@Controller
public class LoginController {
    
    @RequestMapping(path = {"/login"})
    public String login(Model model){
        return "login";
    }
    
     @RequestMapping(path = {"/home"})
    public String home(Model model){
        return "home";
    }
}
