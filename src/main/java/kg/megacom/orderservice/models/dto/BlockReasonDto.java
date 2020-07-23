package kg.megacom.orderservice.models.dto;

import lombok.Data;

@Data
public class BlockReasonDto {

    private Long id;
    private String reason;
    private boolean isVisible;
}
