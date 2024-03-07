package com.verystrong.car_loan_project.api;

import com.verystrong.car_loan_project.domain.Cars;
import com.verystrong.car_loan_project.domain.Cart;
import com.verystrong.car_loan_project.repository.CartRepository;
import com.verystrong.car_loan_project.service.CartService;
import com.verystrong.car_loan_project.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
public class CartApiController {

    @Autowired
    JwtService jwtService;

    @Autowired
    private CartService cartService;

    @Autowired
    CartRepository cartRepository;

    @GetMapping("/api/cart/items")
    public ResponseEntity getCartItems(@CookieValue(value = "token", required = false) String token) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        String accountId = jwtService.getId(token);


        List<Cars> items = cartService.getCartItems(accountId);
        log.info("[Get cartItem]:"+items);

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping("/api/cart/items/{itemId}")
    public ResponseEntity pushCartItem( @PathVariable("itemId") Long itemId,
                                        @CookieValue(value = "token", required = false) String token
    ) {
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        String accountId = jwtService.getId(token);
        log.info("[push cartItem]:"+itemId);
        cartService.pushCartItem(itemId, accountId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/cart/items/{itemId}")
    public ResponseEntity removeCartItem(
            @PathVariable("itemId") Long itemId,
            @CookieValue(value = "token", required = false) String token
    ) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        String accountId = jwtService.getId(token);
        cartService.removeCartItem(itemId,accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
