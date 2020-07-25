package kg.megacom.orderservice.mappers;

import kg.megacom.orderservice.models.dto.OrderDetailDto;
import kg.megacom.orderservice.models.dto.PhoneDto;
import kg.megacom.orderservice.models.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderDetailMapper {

    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

   /* @Mappings({
            @Mapping(source = "orderDetailDto.id", target = "id"),
    })
    OrderDetail orderDetailDtoToOrderDetail(OrderDetailDto orderDetailDto, OrderDto order);

    OrderDetailDto orderDetailToOrderDetailDto(OrderDetail orderDetail);*/


   OrderDetail orderDetailDtoToOrderDetail(OrderDetailDto orderDetailDto);

   OrderDetailDto orderDetailToOrderDetailDto(OrderDetail orderDetail);

   List<OrderDetail> orderDetailDtoListToOrderDetailList(List<OrderDetailDto> orderDetailDtoList);

   List<OrderDetailDto> orderDetailListToOrderDetailDtoList(List<OrderDetail> orderDetailList);
}
