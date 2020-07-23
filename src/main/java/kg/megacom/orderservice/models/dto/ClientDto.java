package kg.megacom.orderservice.models.dto;

import kg.megacom.orderservice.models.enums.ClientStatus;
import lombok.Data;

import java.util.List;

@Data
public class ClientDto {

    private Long id;
    private String name;
    private ClientStatus status;


    private List<PhoneDto> phoneDtoList;
}
