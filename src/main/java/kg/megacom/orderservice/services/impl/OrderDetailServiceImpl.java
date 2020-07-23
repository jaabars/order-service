package kg.megacom.orderservice.services.impl;

import kg.megacom.orderservice.dao.OrderDetailRepository;
import kg.megacom.orderservice.mappers.OrderDetailMapper;
import kg.megacom.orderservice.mappers.OrderMapper;
import kg.megacom.orderservice.models.dto.OrderDetailDto;
import kg.megacom.orderservice.models.dto.OrderDto;
import kg.megacom.orderservice.models.entity.Order;
import kg.megacom.orderservice.models.entity.OrderDetail;
import kg.megacom.orderservice.services.ClientService;
import kg.megacom.orderservice.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetailDto> setDetailsToOrder(OrderDto orderDto) {

        List<OrderDetailDto> orderDetailDtoList = orderDto.getOrderDetailDtoList();
        List<OrderDetailDto> orderDetailListWithClient = new ArrayList<>();

      /*  orderDetailDtoList.stream()
                .forEach(x->{
                    x.setRecipientClient(clientService.createClient(x.getRecipientClient()));
                    x.setSenderClient(clientService.createClient(x.getSenderClient()));
                });*/
      for (int i =0; i<orderDetailDtoList.size();i++){
          OrderDetailDto orderDetailDto = new OrderDetailDto();
          orderDetailDto.setSenderClient(clientService.createClient(orderDetailDtoList.get(i).getSenderClient()));
         orderDetailDto.setRecipientClient(clientService.createClient(orderDetailDtoList.get(i).getRecipientClient()));
          orderDetailListWithClient.add(orderDetailDto);

      }
        List<OrderDetail> orderDetailList = OrderDetailMapper.INSTANCE.orderDetailDtoListToOrderDetailList(orderDetailListWithClient);

       orderDetailList.stream()
                .forEach(x->x.setOrder(OrderMapper.INSTANCE.orderDtoToOrder(orderDto)));
  /*   List<OrderDetail> finalList = new ArrayList<>();
     for (int i = 0; i<orderDetailList.size(); i++){
         OrderDetail orderDetail = orderDetailList.get(i);
         orderDetail.setOrder(OrderMapper.INSTANCE.orderDtoToOrder(orderDto));
         finalList.add(orderDetail);
     }
*/
        orderDetailList = orderDetailRepository.saveAll(orderDetailList);
        orderDetailListWithClient = OrderDetailMapper.INSTANCE.orderDetailListToOrderDetailDtoList(orderDetailList);


        return orderDetailListWithClient;
    }
}
