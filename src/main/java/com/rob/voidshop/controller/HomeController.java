package com.rob.voidshop.controller;

import com.rob.voidshop.form.UserForm;
import com.rob.voidshop.model.Product;
import com.rob.voidshop.model.User;
import com.rob.voidshop.repository.UserRepository;
import com.rob.voidshop.service.ProductService;
import com.rob.voidshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController implements WebMvcConfigurer {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @ModelAttribute("products")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping("/")
    public String index(@ModelAttribute("products") List <Product> products, Model model){
        return "index";
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(UserForm userForm) {
        return "index";
    }

    @PostMapping("/")
    public String checkUserInfo(@Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        // set current active user
        User user = userService.getUsers(userForm.getUsername());
        if (user != null){
            for (User u: userService.getAllUsers()) {
                u.setActive(false);
                userService.updateUsers(u);
            }
            user.setActive(true);
            userService.updateUsers(user);

        }
        return "index";
    }
}
