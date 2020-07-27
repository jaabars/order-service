package kg.megacom.orderservice.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.orderservice.models.enums.OrderStatus;
import lombok.Data;

import java.util.Date;

@Data
public class OrderHistoryDto {

    private Long id;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date naviDate;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date startDate;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date endDate;

    private OrderStatus status;

    private UserDto user;

}
