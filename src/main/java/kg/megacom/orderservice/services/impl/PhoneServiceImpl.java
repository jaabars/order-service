package kg.megacom.orderservice.services.impl;

import kg.megacom.orderservice.dao.PhoneRepository;
import kg.megacom.orderservice.mappers.PhoneMapper;
import kg.megacom.orderservice.models.dto.PhoneDto;
import kg.megacom.orderservice.models.entity.Phone;
import kg.megacom.orderservice.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public boolean existByMsisdn(String msisdn) {
        return phoneRepository.existsByMsisdn(msisdn);
    }

    @Override
    public List<PhoneDto> setPhonesToClient(List<Phone> phoneList) {
        phoneList = phoneRepository.saveAll(phoneList);
        return PhoneMapper.INSTANCE.phoneListToPhoneDtoList(phoneList);
    }
}
