package kg.megacom.orderservice.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDetailDto {

    private Long id;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date estDate;


    private ClientDto recepient;


    private ClientDto sender;


}
