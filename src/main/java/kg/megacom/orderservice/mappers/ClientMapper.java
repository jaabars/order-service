package kg.megacom.orderservice.mappers;

import kg.megacom.orderservice.models.dto.ClientDto;
import kg.megacom.orderservice.models.entity.Client;
import kg.megacom.orderservice.models.entity.Phone;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mappings({
            @Mapping(source ="clientDto.id", target = "id")
    })
    Client clientDtoToClient(ClientDto clientDto);

    @Mapping(source = "phoneList", target = "phoneDtoList")
    ClientDto clientDtoToClient(Client client, List<Phone> phoneList);

    ClientDto clientToClientDto(Client client);
}
