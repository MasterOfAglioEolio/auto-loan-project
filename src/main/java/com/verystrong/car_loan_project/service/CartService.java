package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Cars;

import java.util.List;

public interface CartService {

    List<Cars> getCartItems(String accountId);
    void pushCartItem(Long itemId, String accountId);
    void removeCartItem(Long itemId, String accountId);

}
