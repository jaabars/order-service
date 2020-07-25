package kg.megacom.orderservice.mappers;

import kg.megacom.orderservice.models.dto.OrderDetailDto;
import kg.megacom.orderservice.models.dto.OrderDto;
import kg.megacom.orderservice.models.entity.Order;
import kg.megacom.orderservice.models.entity.OrderDetail;
import kg.megacom.orderservice.models.entity.OrderHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order orderDtoToOrder(OrderDto orderDto);
    @Mappings({
            @Mapping(source = "order.id",target = "id"),
            @Mapping(source = "orderDetailList",target = "orderDetailDtoList"),
            @Mapping(source = "orderHistory",target ="orderHistory" )
    })
    OrderDto orderToOrderDto(Order order, List<OrderDetailDto> orderDetailList, OrderHistory orderHistory);

    List<Order> orderDtoListToOrderList(List<OrderDto> orderDtoList);

}
