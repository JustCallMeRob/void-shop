/*package com.rob.voidshop.controller;

import com.rob.voidshop.model.User;
import com.rob.voidshop.service.SecurityService;
import com.rob.voidshop.service.UserService;
import com.rob.voidshop.utility.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String registerNewUser(Model model){
        model.addAttribute("userForm", new User());
        return "reg";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String registerNewUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

}
*/