package kg.megacom.orderservice.services.impl;

import kg.megacom.orderservice.dao.OrderDetailRepository;
import kg.megacom.orderservice.mappers.OrderDetailMapper;
import kg.megacom.orderservice.mappers.OrderMapper;
import kg.megacom.orderservice.models.dto.OrderDetailDto;
import kg.megacom.orderservice.models.dto.OrderDto;
import kg.megacom.orderservice.models.dto.PhoneDto;
import kg.megacom.orderservice.models.entity.OrderDetail;
import kg.megacom.orderservice.services.ClientService;
import kg.megacom.orderservice.services.OrderDetailService;
import kg.megacom.orderservice.services.PhoneService;
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
    @Autowired
    private PhoneService phoneService;

    @Override
    public List<OrderDetailDto> setDetailsToOrder(OrderDto orderDto) {

        List<OrderDetailDto> orderDetailDtoList = orderDto.getOrderDetailDtoList();
//        List<OrderDetailDto> orderDetailListWithClient = new ArrayList<>();

        orderDetailDtoList.stream()
                .forEach(x -> {
                    x.setRecepient(clientService.createClient(x.getRecepient()));
                    x.setSender(clientService.createClient(x.getSender()));
                });
        List<PhoneDto> recepientPhones = getRecepientsPhones(orderDetailDtoList);
        List<PhoneDto> senderPhones = getSenderPhones(orderDetailDtoList);
    /*  for (int i =0; i<orderDetailDtoList.size();i++){
          OrderDetailDto orderDetailDto = new OrderDetailDto();
          orderDetailDto.setSenderClient(clientService.createClient(orderDetailDtoList.get(i).getSenderClient()));
         orderDetailDto.setRecipientClient(clientService.createClient(orderDetailDtoList.get(i).getRecipientClient()));
          orderDetailListWithClient.add(orderDetailDto);

      }*/


        List<OrderDetail> orderDetailList = OrderDetailMapper.INSTANCE.orderDetailDtoListToOrderDetailList(orderDetailDtoList);


        orderDetailList.stream()
                .forEach(x -> x.setOrder(OrderMapper.INSTANCE.orderDtoToOrder(orderDto)));
  /*   List<OrderDetail> finalList = new ArrayList<>();
     for (int i = 0; i<orderDetailList.size(); i++){
         OrderDetail orderDetail = orderDetailList.get(i);
         orderDetail.setOrder(OrderMapper.INSTANCE.orderDtoToOrder(orderDto));
         finalList.add(orderDetail);
     }
*/
        orderDetailList = orderDetailRepository.saveAll(orderDetailList);

        orderDetailDtoList = OrderDetailMapper.INSTANCE.orderDetailListToOrderDetailDtoList(orderDetailList);

        orderDetailDtoList.stream().forEach(x -> {
            x.getSender().setPhoneDtoList(senderPhones);
            x.getRecepient().setPhoneDtoList(recepientPhones);
        });


        return orderDetailDtoList;
    }




    private List<PhoneDto> getSenderPhones(List<OrderDetailDto> orderDetailDtoList) {

        List<PhoneDto> senderPhones = new ArrayList<>();
        for (int i = 0; i < orderDetailDtoList.size(); i++)
            senderPhones = orderDetailDtoList.get(i).getSender().getPhoneDtoList();
        return senderPhones;
    }

    private List<PhoneDto> getRecepientsPhones(List<OrderDetailDto> orderDetailDtoList) {

        List<PhoneDto> recepientPhones = new ArrayList<>();
        for (int i = 0; i < orderDetailDtoList.size(); i++)
            recepientPhones = orderDetailDtoList.get(i).getRecepient().getPhoneDtoList();
        return recepientPhones;
    }

    @Override
    public List<OrderDetailDto> findAll(Long id) {
        List<OrderDetail> orderDetailList = orderDetailRepository.findAllByOrder_Id(id);
        List<OrderDetailDto> orderDetailDtoList = OrderDetailMapper.INSTANCE.orderDetailListToOrderDetailDtoList(orderDetailList);
        orderDetailDtoList.stream().forEach(x -> {
            x.getSender().setPhoneDtoList(phoneService.findAllById(x.getSender().getId()));
            x.getRecepient().setPhoneDtoList(phoneService.findAllById(x.getRecepient().getId()));
        });
        return orderDetailDtoList;
    }
}

