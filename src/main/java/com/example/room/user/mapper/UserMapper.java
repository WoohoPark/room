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

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

    // TODO : THROW EXCEPTION

    // RequestDto -> MessageBodyDto 매
//    @Mapping(source="pageDto.pageCount", target="pageCnt")
//    partySupplies
//        backgroundPaper
//    @Mapping(source="spaceDto.rentalDto",target = "rental")
    User convertUserEntity(UserDto userDto);
//    Rental convertRentalEntity(RentalDto rentalDto);

//    @InheritInverseConfiguration(name = "convertSpaceEntity")
//    @InheritInverseConfiguration
//@Mapping(source="space.rental",target = "rentalDto")
    @InheritInverseConfiguration
    UserDto convertUserDto(User user);
//    RentalDto convertRentalDto(Rental rental);

}
