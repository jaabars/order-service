package kg.megacom.orderservice.models.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDto {

    private Long id;
    private Date addDate;
    private double ransomSum;

    private List<OrderDetailDto> orderDetailDtoList;
    private OrderHistoryDto orderHistory;
}
