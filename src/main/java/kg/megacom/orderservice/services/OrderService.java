package kg.megacom.orderservice.services;

import kg.megacom.orderservice.models.dto.OrderDto;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);
}
