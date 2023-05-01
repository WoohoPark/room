package com.example.room.space.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.room.common.constants.FeeTypeStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SpaceTypeStatus;
import com.example.room.reservation.service.ReservationService;
import com.example.room.space.dto.FacilityDto;
import com.example.room.space.dto.FeeDto;
import com.example.room.space.dto.RentalDto;
import com.example.room.space.dto.RequestSpace;
import com.example.room.space.dto.ResponseSpace;
import com.example.room.space.repository.SpaceRepository;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SpaceServiceImplTest {

    @InjectMocks
    private SpaceServiceImpl spaceServiceImpl;

    @Mock
    private SpaceRepository spaceRepository;

    @Mock
    private ReservationService reservationService;

    @Test
    void 공간생성() {
        //given
        RequestSpace expect = RequestSpace.builder()
            .withDog(true)
            .peopleCount(3)
            .name("메이스")
            .location(LocationStatus.SEOUL)
            .spaceType(SpaceTypeStatus.STUDIO)
            .latitude(new BigDecimal("12.12341234"))
            .longitude(new BigDecimal("14.12341234123"))
            .rentalDto(RentalDto.builder().partySupplies(true).backgroundPaper(false).build())
            .facilityDto(FacilityDto.builder().light(true).wifi(true).build())
            .feeDto(FeeDto.builder().fee(1000).feeType(FeeTypeStatus.TIME).build())
            .build();

        //when & stub
        when(spaceRepository.save(any())).thenReturn(expect.toEntity());
        ResponseSpace actual = spaceServiceImpl.create(expect);

        //then
        assertThat(actual.isWithDog()).isEqualTo(expect.isWithDog());
        assertThat(actual.getPeopleCount()).isEqualTo(expect.getPeopleCount());
        assertThat(actual.getName()).isEqualTo(expect.getName());
        assertThat(actual.getLocation()).isEqualTo(expect.getLocation());
        assertThat(actual.getLatitude()).isEqualTo(expect.getLatitude());
        assertThat(actual.getLongitude()).isEqualTo(expect.getLongitude());
        assertThat(actual.getSpaceType()).isEqualTo(expect.getSpaceType());
        assertThat(actual.getRentalDto().isPartySupplies()).isEqualTo(
            expect.getRentalDto().isPartySupplies());
        assertThat(actual.getRentalDto().isBackgroundPaper()).isEqualTo(
            expect.getRentalDto().isBackgroundPaper());
        assertThat(actual.getFacilityDto().isLight()).isEqualTo(expect.getFacilityDto().isLight());
        assertThat(actual.getFacilityDto().isSpeaker()).isEqualTo(
            expect.getFacilityDto().isSpeaker());
        assertThat(actual.getFacilityDto().isTableware()).isEqualTo(
            expect.getFacilityDto().isTableware());
        assertThat(actual.getFacilityDto().isWifi()).isEqualTo(expect.getFacilityDto().isWifi());
        assertThat(actual.getFeeDto().getFee()).isEqualTo(expect.getFeeDto().getFee());
        assertThat(actual.getFeeDto().getFeeType()).isEqualTo(expect.getFeeDto().getFeeType());
    }


    @Test
    void 공간삭제() {
        //given
        Long expect = 2L;

        //when & stub
//        when(spaceRepository.deleteById(expect)).thenReturn("");
        spaceServiceImpl.deleteBySpaceId(expect);


    }
}