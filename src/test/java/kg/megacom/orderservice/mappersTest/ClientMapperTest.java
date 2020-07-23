package kg.megacom.orderservice.mappersTest;

import kg.megacom.orderservice.mappers.ClientMapper;
import kg.megacom.orderservice.models.dto.ClientDto;
import kg.megacom.orderservice.models.entity.Client;
import kg.megacom.orderservice.models.entity.Phone;
import kg.megacom.orderservice.models.enums.ClientStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientMapperTest {

    @Test
    public void clientMapper(){
        ClientDto clientDto = new ClientDto();
        clientDto.setName("client");
        clientDto.setStatus(ClientStatus.NEW);
        Client client = ClientMapper.INSTANCE.clientDtoToClient(clientDto);

        Phone phone = new Phone();

        phone.setActive(true);
        phone.setClient(client);
        phone.setMsisdn("0550550550");
        Phone phone1 = new Phone();
        phone1.setMsisdn("0551551551");
        phone1.setClient(client);
        phone1.setActive(true);
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone);
        phoneList.add(phone1);
        ClientDto found = ClientMapper.INSTANCE.clientDtoToClient(client,phoneList);


        assertEquals(found.getPhoneDtoList().get(0).getMsisdn(),phoneList.get(0).getMsisdn());
        assertEquals(found.getName(),clientDto.getName());
        assertEquals(found.getStatus(),clientDto.getStatus());
    }

}
