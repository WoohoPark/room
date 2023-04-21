package com.example.room.space.service;

import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.PaymentStatus;
import com.example.room.space.dao.SpaceDAO;
import com.example.room.space.dto.FeeDto;
import com.example.room.space.dto.RentalDto;
import com.example.room.space.dto.SpaceDto;
import com.example.room.space.entity.space.Space;
import com.example.room.space.mapper.SpaceMapper;
import com.example.room.space.service.impl.SpaceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {SpaceServiceImpl.class, SpaceDAO.class})
public class SpaceServiceTest {

    @MockBean
    private SpaceDAO spaceDAO;

    @Autowired
    private SpaceServiceImpl spaceService;

    private SpaceMapper spaceMapper = Mappers.getMapper(SpaceMapper.class);

    private Space space;

    private SpaceDto spaceDto;

    private RentalDto rentalDto;

    private FeeDto feeDto;

    @BeforeEach
    void 셋업(){
        System.out.println("setup");

        rentalDto = RentalDto.builder()
                .backgroundPaper(false)
                .partySupplies(true)
                .build();
        feeDto = FeeDto.builder()
                .fee(100)
                .payDate(new Date())
                .paymentStatus(PaymentStatus.CARD)
                .build();

        spaceDto = SpaceDto.builder()
                .withDog(true)
                .peopleCount(3)
                .name("Test")
                .location(LocationStatus.SEOUL)
                .latitude(BigDecimal.valueOf(123123.4352352435))
                .longitude(BigDecimal.valueOf(0.12312312))
                .rentalDto(rentalDto)
                .feeDto(feeDto)
                .build();
    }
    @Test
    void 공간등록(){
        Space accept = spaceMapper.convertSpaceEntity(spaceDto);
        given(spaceDAO.create(spaceDto)).willReturn(accept);
        Space expected = spaceDAO.create(spaceDto);
        Assertions.assertNotNull(expected);
        verify(spaceDAO).create(spaceDto);
    }

    @Test
    void 공간수정(){


    }

    @Test
    void 공간삭제(){

    }

    @Test
    void 공간조회(){
        공간등록();
        when(spaceDAO.getSpace()).thenReturn(spaceDto);
        SpaceDto expected = spaceDAO.getSpace();
        Assertions.assertNotNull(expected);
        verify(spaceDAO).getSpace();
    }
}
