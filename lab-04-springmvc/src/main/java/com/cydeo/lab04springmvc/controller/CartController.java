package com.cydeo.lab04springmvc.controller;


import com.cydeo.lab04springmvc.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
public class CartController {

    @RequestMapping("/cart-list")
    public String getCart(Model model){
        CartServiceImpl cartService = new CartServiceImpl();

        model.addAttribute("cartList",cartService.retrieveCartList());

        return "cart/cart-list.html";
    }


    @RequestMapping("/cart-list/{id}")
    public String getCart2(@PathVariable UUID id,Model model){
        CartServiceImpl cartService = new CartServiceImpl();

        model.addAttribute("cartItemList",cartService.retrieveCartDetail(id));

        return "cart/cart-detail.html";
    }



}
