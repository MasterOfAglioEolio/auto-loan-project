package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Cars;
import com.verystrong.car_loan_project.domain.Cart;
import com.verystrong.car_loan_project.repository.CarsRepository;
import com.verystrong.car_loan_project.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CarsRepository carsRepository;

    @Override
    public List<Cars> getCartItems(String accountId) {

        List<Cart> carts = cartRepository.findByAccountId(accountId);
        List<Long> itemIds = carts.stream().map(Cart::getItemId).toList();
        List<Cars> items = carsRepository.findByIdIn(itemIds);

        return items;

    }

    @Override
    public void pushCartItem(Long itemId, String accountId) {
        Cart cart = cartRepository.findByAccountIdAndItemId(accountId, itemId);
        if (cart == null) {
            Cart newCart = new Cart();
            newCart.setAccountId(accountId);
            newCart.setItemId(itemId);
            cartRepository.save(newCart);
        }

    }

    @Override
    public void removeCartItem(Long itemId, String accountId) {
        Cart cart = cartRepository.findByAccountIdAndItemId(accountId, itemId);

        cartRepository.delete(cart);
    }
}
