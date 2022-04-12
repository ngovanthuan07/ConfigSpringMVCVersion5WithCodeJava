/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vanthuandev.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vanthuandev.pojos.Product;
import com.vanthuandev.service.ProductService;
import com.vanthuandev.validator.ProductNameValidator;
import com.vanthuandev.validator.WebAppValidator;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ngova
 */
@Controller
public class ProductController {


    
    @Autowired
    private WebAppValidator productValidator;
    @Autowired
    private ProductService productService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
         binder.setValidator(productValidator);
    }

    @GetMapping("/admin/products")
    public String list(Model model) {
        model.addAttribute("product", new Product());

        return "product";
    }
    
    
    
    @PostMapping("/admin/products")
    public String add(Model model, @ModelAttribute(value = "product") @Valid Product product, BindingResult result) {
        Product p = product;
        if (!result.hasErrors()) {
            if(this.productService.addOrUpdate(product) == true) {
                return "redirect:/";
            } else {
                model.addAttribute("errMsg", "Something wrong!!!");
            }
        }
        return "product";
    }
}
