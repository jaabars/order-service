package kg.megacom.orderservice.models.dto;

import lombok.Data;

@Data
public class AddressDto {

    private Long id;

    private String street;
    private String house;
    private int flat;
    private int floor;
    private String intercom;
    private String description;
}
