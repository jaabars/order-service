package kg.megacom.orderservice.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDto {

    private Long id;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date addDate;

    private double ransomSum;

    private List<OrderDetailDto> orderDetailDtoList;
    private OrderHistoryDto orderHistory;
}
