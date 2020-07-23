package kg.megacom.orderservice.models.dto;

import kg.megacom.orderservice.models.enums.OrderStatus;
import lombok.Data;

import java.util.Date;

@Data
public class OrderHistoryDto {

    private Long id;

    private Date naviDate;
    private Date startDate;
    private Date endDate;

    private OrderStatus status;

    private UserDto user;

}
