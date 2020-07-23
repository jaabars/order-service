package kg.megacom.orderservice.models.dto;

import lombok.Data;

@Data
public class ClientAddressDto {

    private Long id;

    private boolean main;
    private boolean active;

    private ClientDto client;

    private AddressDto address;
}
