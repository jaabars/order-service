package kg.megacom.orderservice.services.impl;

import kg.megacom.orderservice.dao.ClientRepository;
import kg.megacom.orderservice.mappers.ClientMapper;
import kg.megacom.orderservice.mappers.PhoneMapper;
import kg.megacom.orderservice.models.dto.ClientDto;
import kg.megacom.orderservice.models.dto.PhoneDto;
import kg.megacom.orderservice.models.entity.Client;
import kg.megacom.orderservice.models.entity.Phone;
import kg.megacom.orderservice.services.ClientService;
import kg.megacom.orderservice.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PhoneService phoneService;

    @Override
    public ClientDto createClient(ClientDto clientDto) {

        Client client = ClientMapper.INSTANCE.clientDtoToClient(clientDto);

        client = clientRepository.save(client);


        List<PhoneDto> phoneDtos = clientDto.getPhoneDtoList().stream()
                .filter(x->phoneService.existByMsisdn(x.getMsisdn())).collect(Collectors.toList());

        Client finalClient = client;

        List<Phone> phoneList = phoneDtos.stream().map(
                x->{
          Phone phone = PhoneMapper.INSTANCE.phoneDtoToPhone(x);
          phone.setClient(finalClient);
          return phone;
                }
        ).collect(Collectors.toList());

        phoneDtos = phoneService.setPhonesToClient(phoneList);
        clientDto = ClientMapper.INSTANCE.clientToClientDto(client);
        clientDto.setPhoneDtoList(phoneDtos);

        return clientDto;
    }
}
