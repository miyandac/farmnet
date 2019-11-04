/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author CHILIKWEM
 */
@Controller
public class YieldController {
    @RequestMapping(path = {"/yield"}, method =RequestMethod.POST)
    public String addYield(Model model){
       return "yield";
    }
}
