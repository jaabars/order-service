package kg.megacom.orderservice.services;

import kg.megacom.orderservice.models.dto.PhoneDto;
import kg.megacom.orderservice.models.entity.Phone;

import java.util.List;

public interface PhoneService {

    boolean existByMsisdn(String msisdn);

    List<PhoneDto> setPhonesToClient(List<Phone> phoneList);
}
