package kg.megacom.orderservice.services;

import kg.megacom.orderservice.models.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);
    List<OrderDto> findAll ();
}
