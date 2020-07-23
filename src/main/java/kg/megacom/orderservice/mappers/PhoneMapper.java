package kg.megacom.orderservice.mappers;

import kg.megacom.orderservice.models.dto.ClientDto;
import kg.megacom.orderservice.models.dto.PhoneDto;
import kg.megacom.orderservice.models.entity.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);


    Phone phoneDtoToPhone(PhoneDto phoneDto);

    PhoneDto phoneToPhoneDto(Phone phone);

    List<Phone> phoneDtoListToPhoneList(List<PhoneDto> phoneDtoList);
    List<PhoneDto> phoneListToPhoneDtoList(List<Phone> phoneList);

}
