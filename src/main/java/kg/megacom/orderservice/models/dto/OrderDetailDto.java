package kg.megacom.orderservice.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDetailDto {

    private Long id;

    private Date estDate;


    private ClientDto recipientClient;


    private ClientDto senderClient;


}
