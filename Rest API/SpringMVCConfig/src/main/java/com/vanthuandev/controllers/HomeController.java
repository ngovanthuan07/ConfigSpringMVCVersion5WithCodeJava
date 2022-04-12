/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vanthuandev.controllers;

import com.vanthuandev.pojos.Cart;
import com.vanthuandev.service.CategoryService;
import com.vanthuandev.pojos.User;
import com.vanthuandev.service.ProductService;
import com.vanthuandev.utils.Utils;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ngova
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    @ModelAttribute
    public void commonAttr(Model model, HttpSession session) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("cartCounter", Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam(required = false) Map<String, String> params) {


        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("products", this.productService.getProducts(params.getOrDefault("kw", ""), page));
        model.addAttribute("counter", this.productService.countProduct());
        return "index";
    }

    @RequestMapping(path = "/cart")
    public String cart(Model model) {
        return "cart";
    }

    @RequestMapping("/hello/{name}")
    public String hello(Model model, @PathVariable(value = "name") String name) {
        model.addAttribute("message", "Welcome " + name + "!!!");
        return "hello";
    }

//    @RequestMapping(path = "/hello-post", method = RequestMethod.POST)
//    public String show(Model model, @ModelAttribute(value = "user") User user) {
//        model.addAttribute("fullName", user.getFirstName() + " " + user.getLastName());
//
//        return "index";
//    }

    @RequestMapping(path = "/test")
    public String testRedirect(Model model) {
        model.addAttribute("testMsg", "WELCOME REDIRECT!!!");
        return "forward:/hello/Thuan";
    }

    @RequestMapping("/my-home")
    public String html(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
        return "my_home";
    }

}
