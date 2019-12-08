package com.rob.voidshop.controller;

import com.rob.voidshop.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @GetMapping("/product")
    public String loadProduct(@RequestParam(name="id") String productId, Model model) {
        model.addAttribute("productId", productId);
        return "product";
    }

}
