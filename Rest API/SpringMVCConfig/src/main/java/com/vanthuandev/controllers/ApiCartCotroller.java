/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vanthuandev.controllers;

import com.vanthuandev.pojos.Cart;
import com.vanthuandev.pojos.Product;
import com.vanthuandev.service.ProductService;
import com.vanthuandev.utils.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ngova
 */
@RestController
public class ApiCartCotroller {

    @Autowired
    private ProductService productService;

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> listProduct() {
        List<Product> products = this.productService.getProducts("", 1);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/api/cart/{productId}")
    public ResponseEntity<Integer> card(@PathVariable(value = "productId") Integer productId, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        if (cart.containsKey(productId) == true) {
            // san pham da co trong gio
            Cart c = cart.get(productId);
            c.setCount(c.getCount() + 1);
        } else {
            // san pham cua co trong gio
            Product p = this.productService.getProductById(productId);
            Cart c = new Cart();
            c.setProductId(p.getId());
            c.setName(p.getName());
            c.setPrice(p.getPrice());
            c.setCount(1);
            
            cart.put(productId, c);
        }
        session.setAttribute("cart", cart);
        return new ResponseEntity<>(Utils.countCart(cart), HttpStatus.OK);
    }
}
