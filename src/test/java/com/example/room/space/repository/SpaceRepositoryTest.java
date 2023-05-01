package com.example.room.space.repository;


import static org.assertj.core.api.Assertions.assertThat;

import com.example.room.common.constants.FeeTypeStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SpaceTypeStatus;
import com.example.room.space.dto.FacilityDto;
import com.example.room.space.dto.FeeDto;
import com.example.room.space.dto.RentalDto;
import com.example.room.space.dto.RequestSpace;
import com.example.room.space.entity.Space;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
class SpaceRepositoryTest {

    @Autowired
    SpaceRepository spaceRepository;

    @BeforeEach
    void setUp() {
        RequestSpace req = RequestSpace.builder()
            .withDog(false)
            .peopleCount(10)
            .name("메이스")
            .location(LocationStatus.DAEGU)
            .spaceType(SpaceTypeStatus.PARTY_ROOM)
            .latitude(new BigDecimal("12.3949"))
            .longitude(new BigDecimal("140.3919"))
            .rentalDto(RentalDto.builder().partySupplies(false).backgroundPaper(false).build())
            .facilityDto(FacilityDto.builder().light(true).wifi(false).build())
            .feeDto(FeeDto.builder().fee(1100).feeType(FeeTypeStatus.TIME).build())
            .build();

        spaceRepository.save(req.toEntity());
    }

    @Test
    void 공간등록() {
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

        //when
        Space actual = spaceRepository.save(expect.toEntity());

        //then
        assertThat(actual.isWithDog()).isEqualTo(expect.isWithDog());
        assertThat(actual.getPeopleCount()).isEqualTo(expect.getPeopleCount());
        assertThat(actual.getName()).isEqualTo(expect.getName());
        assertThat(actual.getLocation()).isEqualTo(expect.getLocation());
        assertThat(actual.getLatitude()).isEqualTo(expect.getLatitude());
        assertThat(actual.getLongitude()).isEqualTo(expect.getLongitude());
        assertThat(actual.getSpaceType()).isEqualTo(expect.getSpaceType());
        assertThat(actual.getRental().isPartySupplies()).isEqualTo(
            expect.getRentalDto().isPartySupplies());
        assertThat(actual.getRental().isBackgroundPaper()).isEqualTo(
            expect.getRentalDto().isBackgroundPaper());
        assertThat(actual.getFacility().isLight()).isEqualTo(expect.getFacilityDto().isLight());
        assertThat(actual.getFacility().isSpeaker()).isEqualTo(expect.getFacilityDto().isSpeaker());
        assertThat(actual.getFacility().isTableware()).isEqualTo(
            expect.getFacilityDto().isTableware());
        assertThat(actual.getFacility().isWifi()).isEqualTo(expect.getFacilityDto().isWifi());
        assertThat(actual.getFee().getFee()).isEqualTo(expect.getFeeDto().getFee());
        assertThat(actual.getFee().getFeeType()).isEqualTo(expect.getFeeDto().getFeeType());
    }

    @Sql("classpath:db/tableInit.sql")
    @Test
    void 공간조회() {
        //given
        Long expect = 1L;

        //when
        Optional<Space> optionalSpace = spaceRepository.findSpaceById(expect);
        Space actual = optionalSpace.get();

        //then
        assertThat(actual.getId()).isEqualTo(expect);
    }

    @Sql("classpath:db/tableInit.sql")
    @Test
    void 공간삭제() {
        //given
        Long expect = 1L;

        //when
        spaceRepository.deleteById(expect);

        //then
        assertThat(spaceRepository.findById(expect)).isEmpty();
    }


}