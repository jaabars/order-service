package kg.megacom.orderservice.mappersTest;

import kg.megacom.orderservice.mappers.OrderDetailMapper;
import kg.megacom.orderservice.models.dto.ClientDto;
import kg.megacom.orderservice.models.dto.OrderDetailDto;
import kg.megacom.orderservice.models.entity.OrderDetail;
import kg.megacom.orderservice.models.enums.ClientStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailMapperTest {

    @Test
    public void orderDetailMapper(){
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setEstDate(new Date());
        ClientDto recepient = new ClientDto();
        recepient.setStatus(ClientStatus.NEW);
        recepient.setName("Recepient");
        ClientDto sender = new ClientDto();
        sender.setName("Sender");
        sender.setStatus(ClientStatus.NEW);
        orderDetailDto.setRecepient(recepient);
        orderDetailDto.setSender(sender);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail = OrderDetailMapper.INSTANCE.orderDetailDtoToOrderDetail(orderDetailDto);

        OrderDetailDto found = OrderDetailMapper.INSTANCE.orderDetailToOrderDetailDto(orderDetail);



        assertEquals(found.getEstDate(),orderDetailDto.getEstDate());
        assertEquals(found.getRecepient().getName(),orderDetailDto.getRecepient().getName());
        assertEquals(found.getSender().getName(),orderDetailDto.getSender().getName());

    }
}
