/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vanthuandev.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vanthuandev.pojos.Product;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ngova
 */
@Controller
public class ProductController {

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/admin/products")
    public String list(Model model) {
        model.addAttribute("product", new Product());

        return "product";
    }

    @PostMapping("/admin/products")
    public String add(@ModelAttribute(value = "product") @Valid Product product, BindingResult result) {

        if (!result.hasErrors()) {
            try {
                Map r = this.cloudinary.uploader().upload(product.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                String img = (String) r.get("secure_url");
                return "redirect:/";
            } catch (IOException ex) {
                System.err.println("== ADD PRODUCT ==" + ex.getMessage());
            }
        }
        return "product";

    }
}
