package com.tastytown.backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tastytown.backend.constants.OrderStatus;
import com.tastytown.backend.dto.BillingInfoDTO;
import com.tastytown.backend.dto.OrderDTO;
import com.tastytown.backend.entity.Cart;
import com.tastytown.backend.entity.Order;
import com.tastytown.backend.entity.User;
import com.tastytown.backend.helper.CartServiceHelper;
import com.tastytown.backend.helper.UserServiceHelper;
import com.tastytown.backend.service.IOrderService;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService{
    private final UserServiceHelper userServiceHelper;
    private final CartServiceHelper cartServiceHelper;

    @Override
    public OrderDTO placeOrder(BillingInfoDTO dto, String userId) {
      var user = userServiceHelper.getUserById(userId);
      var cart = cartServiceHelper.getCartByUser(user);

      if (cart.getItems().isEmpty()) {
        throw new RuntimeException("Cart is Empty");
      }

      var  order = createOrderFromCart(cart, dto, user);
    }

    @Override
    public List<OrderDTO> getOrderByUser(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderByUser'");
    }

    @Override
    public List<OrderDTO> getAllOreders() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllOreders'");
    }

    @Override
    public OrderDTO updateOrderStatus(String orderCode, OrderStatus status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOrderStatus'");
    }

    private Order createOrderFromCart(Cart cart, BillingInfoDTO billingInfo, User user) {
        var order = new Order();
        order.setUser(user);
        order.setOrderDateTime(LocalDateTime.now());

    }
    
}
