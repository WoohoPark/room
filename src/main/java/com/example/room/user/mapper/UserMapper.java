package com.example.room.user.mapper;

import com.example.room.space.dto.RentalDto;
import com.example.room.space.dto.SpaceDto;
import com.example.room.space.entity.rental.Rental;
import com.example.room.space.entity.space.Space;
import com.example.room.user.dto.UserDto;
import com.example.room.user.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    // TODO : THROW EXCEPTION
    User convertUserEntity(UserDto userDto);
    @InheritInverseConfiguration
    UserDto convertUserDto(User user);
    List<User> convertUsersEntity(List<UserDto> usersDto);
    List<UserDto> convertUsersDto(List<User> users);



}
