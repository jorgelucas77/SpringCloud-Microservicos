package com.jlucas.shoppingcart.repository;

import com.jlucas.shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository  extends CrudRepository<Cart, Integer>{
}
