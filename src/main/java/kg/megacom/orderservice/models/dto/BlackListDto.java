package kg.megacom.orderservice.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BlackListDto {

    private Long id;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date addDate;


    private UserDto user;


    private ClientDto client;

    private BlockReasonDto blockReason;
}
