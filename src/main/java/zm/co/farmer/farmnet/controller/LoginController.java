/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.farmer.farmnet.controller;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zm.co.farmer.farmnet.entity.User;
import zm.co.farmer.farmnet.service.FarmService;
import zm.co.farmer.farmnet.service.UserService;
import zm.co.farmer.farmnet.service.YieldService;
import zm.co.farmer.farmnet.util.GenericDataService;

/**
 *
 * @author CHILIKWEM
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private YieldService yieldService;
    @Autowired
    private FarmService farmService;
    @Autowired
    private GenericDataService genericDataService;

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

    //invalidate session
    @RequestMapping(path = {"/logout"}, method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        Cookie cookie = new Cookie("user_session_id", null);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        HttpSession session = request.getSession();

        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

    @RequestMapping(path = {"/home"})
    public String home(Model model, @CookieValue("user_session_id") String username) throws SQLException {

        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);

        List<String> names = new ArrayList<>();
        List<Float> values = new ArrayList<>();
        float max = 0;

        for (HashMap hashMap : getCurrentYieldByYear(Calendar.getInstance().get(Calendar.YEAR))) {
            String name = hashMap.get("crop").toString();
            Float value = Float.parseFloat(hashMap.get("weight").toString());

            if (value > max) {
                max = value;
            }

            names.add(name);
            values.add(value);
        }

        Gson gson = new Gson();

        model.addAttribute("events", farmService.getAllFarmEvents());
        model.addAttribute("yieldnames", gson.toJson(names));
        model.addAttribute("yieldvalues", gson.toJson(values));
        model.addAttribute("year", Calendar.getInstance().get(Calendar.YEAR));
        model.addAttribute("max", max + ((int) (max * .1f)));

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

    private List<HashMap> getCurrentYieldByYear(int year) throws SQLException {
        String sql = "SELECT fy.crop, sum(fy.weight) AS weight \n"
                + "FROM fisp_yield fy \n"
                + "WHERE DATE_FORMAT(fy.dateofyield,'%Y') = " + year + " \n"
                + "GROUP BY fy.crop;";

        return genericDataService.getQueryResultsAsHashmap(sql);
    }

}
