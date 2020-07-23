package kg.megacom.orderservice.mappers;

import kg.megacom.orderservice.models.dto.UserDto;
import kg.megacom.orderservice.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDtoToUser(UserDto userDto);
    UserDto userDtoToUser(User user);

    List<UserDto> userListToUserDtoList(List<User> userList);
}
