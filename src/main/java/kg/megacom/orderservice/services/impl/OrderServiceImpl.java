package kg.megacom.orderservice.services.impl;

import kg.megacom.orderservice.dao.OrderRepository;
import kg.megacom.orderservice.mappers.OrderMapper;
import kg.megacom.orderservice.models.dto.OrderDetailDto;
import kg.megacom.orderservice.models.dto.OrderDto;
import kg.megacom.orderservice.models.entity.Order;
import kg.megacom.orderservice.services.OrderDetailService;
import kg.megacom.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailService orderDetailService;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        Order order = OrderMapper.INSTANCE.orderDtoToOrder(orderDto);
        order = orderRepository.save(order);

        orderDto.setId(order.getId());

        List<OrderDetailDto> orderDetailDtoList = orderDetailService.setDetailsToOrder(orderDto);
        orderDto.setOrderDetailDtoList(orderDetailDtoList);
        return orderDto;
    }
}
