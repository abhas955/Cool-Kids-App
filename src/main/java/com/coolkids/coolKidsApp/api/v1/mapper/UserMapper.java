package com.coolkids.coolKidsApp.api.v1.mapper;

import com.coolkids.coolKidsApp.api.v1.model.UserDTO;
import com.coolkids.coolKidsApp.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    UserDTO userToUserDTO(User user);

    User userDTOtoUser(UserDTO userDTO);

}
