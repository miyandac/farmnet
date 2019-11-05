/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zm.co.farmer.farmnet.entity.User;
import zm.co.farmer.farmnet.service.UserService;
import zm.co.farmer.farmnet.service.YieldService;


/**
 *
 * @author CHILIKWEM
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    private YieldService yieldService;


    @RequestMapping(path = {"/"})
    public String homepage(Model model) {
        return "login";
    }

    @RequestMapping(path = {"/login"}, method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(path = {"/login"}, method = RequestMethod.POST)
    public String loginAction(HttpServletRequest request,
            HttpServletResponse response,
            Model model,
            @ModelAttribute("username") String username,
            @ModelAttribute("password") String password) throws Exception {

        try {
            User user = userService.login(username, password);
            if (user == null) {
                return "redirect:/login?error=invalidusernamepassword";
            }

            model.addAttribute("user", user);

            if (user == null) {
                return "login?error=invalidusernamepassword";
            } else {

                //user.setPassword("");
                request.getSession().setAttribute("logged_in_user", user);

                String id = user.getId().toString();

                Cookie cookie = new Cookie("user_session_id", username);

                cookie.setHttpOnly(true);
                cookie.setMaxAge(36000);

                response.addCookie(cookie);
            }

            // Redirect user
            return "redirect:/home";

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            return "redirect:/login?error=invalidusernamepassword";
        }
    }

    @RequestMapping(path = {"/home"})
    public String home(Model model, @CookieValue("user_session_id") String username) {
        
        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        
        
        return "home";
    }

    @RequestMapping(path = {"/pageone"})
    public String pageone(Model model) {

        // Inject user list
        model.addAttribute("users", userService.getAllUsers());

        return "pageone";
        
    }
    
        @RequestMapping(path = {"/field"})
        public String field(Model model) {

        // Inject user list
        model.addAttribute("users", yieldService.getYield());

        return "field";
        
    }
    
    
}
