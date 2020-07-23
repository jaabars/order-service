package kg.megacom.orderservice.services;

import kg.megacom.orderservice.models.dto.ClientDto;

public interface ClientService {

    ClientDto createClient(ClientDto clientDto);
}
