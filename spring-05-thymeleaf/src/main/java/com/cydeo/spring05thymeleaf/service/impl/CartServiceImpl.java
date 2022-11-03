package com.cydeo.spring05thymeleaf.service.impl;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.CartItem;
import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO,new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){

        //todo retrieve product from repository method
        Product product = productService.findProductById(productId);
        //todo initialise cart item


        CartItem cartItem = new CartItem();
        //todo calculate cart total amount

        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        //todo add to cart


        CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));
        CART.getCartItemList().add(cartItem);

        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        //todo delete product object from cart using stream

        CartItem cart_Item = CART.getCartItemList().stream()
                .filter(cartItem -> cartItem.getProduct().getId().toString().equals(productId.toString())).findFirst().orElseThrow();

        CART.getCartItemList().remove(cart_Item);
        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(cart_Item.getProduct().getPrice().multiply(BigDecimal.valueOf(cart_Item.getProduct().getRemainingQuantity()))));

        return true;
    }
}
