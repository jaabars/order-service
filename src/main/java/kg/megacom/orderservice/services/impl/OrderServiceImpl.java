package kg.megacom.orderservice.services.impl;

import kg.megacom.orderservice.dao.OrderRepository;
import kg.megacom.orderservice.mappers.OrderMapper;
import kg.megacom.orderservice.models.dto.OrderDetailDto;
import kg.megacom.orderservice.models.dto.OrderDto;
import kg.megacom.orderservice.models.entity.Order;
import kg.megacom.orderservice.models.entity.OrderHistory;
import kg.megacom.orderservice.services.OrderDetailService;
import kg.megacom.orderservice.services.OrderService;
import kg.megacom.orderservice.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailService orderDetailService;
   /* @Autowired
    private PhoneService phoneService;*/

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        Order order = OrderMapper.INSTANCE.orderDtoToOrder(orderDto);
        order = orderRepository.save(order);

        orderDto.setId(order.getId());

        List<OrderDetailDto> orderDetailDtoList = orderDetailService.setDetailsToOrder(orderDto);
        orderDto.setOrderDetailDtoList(orderDetailDtoList);
        return orderDto;
    }

    @Override
    public List<OrderDto> findAll() {

        List<Order> orderList = orderRepository.findAll();
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setId(1l);
        orderHistory.setEndDate(new Date());
        orderHistory.setNaviDate(new Date());
        List<OrderDto> orderDtoList = new ArrayList<>();

        for (int i=0;i<orderList.size();i++){
            OrderDto orderDto = new OrderDto();
             orderDto = OrderMapper.INSTANCE.orderToOrderDto(orderList.get(i),orderDetailService.findAll(orderList.get(i).getId()),orderHistory);
             orderDtoList.add(orderDto);
        }

      /*  for (int i = 0; i <orderDtoList.size();i++){
            Long recepient_id = orderDtoList.get(i).getOrderDetailDtoList().get(i).getRecepient().getId();
            Long sender_id = orderDtoList.get(i).getOrderDetailDtoList().get(i).getSender().getId();
            orderDtoList.get(i).getOrderDetailDtoList().get(i).getRecepient().setPhoneDtoList(phoneService.findAllById(recepient_id));
            orderDtoList.get(i).getOrderDetailDtoList().get(i).getSender().setPhoneDtoList(phoneService.findAllById(sender_id));
        }*/
        return orderDtoList;
    }
}
