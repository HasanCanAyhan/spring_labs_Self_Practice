package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class CartController {


    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping("/cart")
    public String seeCart(Model model){

        model.addAttribute("cartItemList", CartServiceImpl.CART.getCartItemList());
        model.addAttribute("cartTotalAmount", CartServiceImpl.CART.getCartTotalAmount());


        return "/cart/show-cart";
    }


    @GetMapping("/addToCart/{productId}/{quantity}")
    public String addToCart(@PathVariable UUID productId, @PathVariable int quantity, Model model){

        cartService.addToCart(productId,quantity);

        /*
        model.addAttribute("cartItemList", CartServiceImpl.CART.getCartItemList());
        model.addAttribute("cartTotalAmount", CartServiceImpl.CART.getCartTotalAmount());
         */

        //return "/cart/show-cart";
        return "redirect:/cart";
    }


    @GetMapping("/delete/{productId}")
    public String deleteFromCart(@PathVariable UUID productId, Model model){

        cartService.deleteFromCart(productId);

        /*
        model.addAttribute("cartItemList", CartServiceImpl.CART.getCartItemList());
        model.addAttribute("cartTotalAmount", CartServiceImpl.CART.getCartTotalAmount());

         */

        //return "/cart/show-cart";
        return "redirect:/cart";
    }



}
