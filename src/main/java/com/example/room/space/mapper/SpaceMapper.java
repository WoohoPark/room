package com.example.room.space.mapper;

import com.example.room.space.dto.RentalDto;
import com.example.room.space.dto.SpaceDto;
import com.example.room.space.entity.rental.Rental;
import com.example.room.space.entity.space.Space;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import javax.persistence.Inheritance;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SpaceMapper {

    // TODO : THROW EXCEPTION

    // RequestDto -> MessageBodyDto 매
//    @Mapping(source="pageDto.pageCount", target="pageCnt")
//    partySupplies
//        backgroundPaper
    @Mapping(source="spaceDto.rentalDto",target = "rental")
    Space convertSpaceEntity(SpaceDto spaceDto);
    Rental convertRentalEntity(RentalDto rentalDto);

//    @InheritInverseConfiguration(name = "convertSpaceEntity")
//    @InheritInverseConfiguration
//@Mapping(source="space.rental",target = "rentalDto")
    @InheritInverseConfiguration
    SpaceDto convertSpaceDto(Space space);
    RentalDto convertRentalDto(Rental rental);

}
