package kg.megacom.orderservice.services;

import kg.megacom.orderservice.models.dto.OrderDetailDto;
import kg.megacom.orderservice.models.dto.OrderDto;

import java.util.List;

public interface OrderDetailService {

    List<OrderDetailDto> setDetailsToOrder(OrderDto orderDto);
}
