package com.jlucas.shoppingcart.controller;

import com.jlucas.shoppingcart.model.Cart;
import com.jlucas.shoppingcart.model.Item;
import com.jlucas.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item){
        Otpional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if (savedCart.equals(Optional.empty())){
            cart = new Cart(id);
        }
        else
        {
            cart = savedCart.get();
        }
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Cart> findById(@PathVariable("id") Integer id) { return cartRepository.findById(id);}

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void clear (@PathVariable("id") Integer id) { cartRepository.findById(id);}
}
