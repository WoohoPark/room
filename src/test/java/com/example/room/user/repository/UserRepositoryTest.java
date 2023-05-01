package com.example.room.user.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.user.dto.RequestUser;
import com.example.room.user.entity.User;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        RequestUser requestUser = RequestUser.builder()
            .id("wooho")
            .age(20)
            .money(100000000)
            .location(LocationStatus.SEOUL)
            .name("jhpark")
            .nickName("WoohoPark")
            .password("awjkefioajwefo")
            .role(AuthRoleStatus.HOST)
            .sexual(SexualStatus.FEMALE)
            .build();
        userRepository.save(requestUser.toEntity());
    }

    @Test
    void 회원등록() {
        //given
        RequestUser expect = RequestUser.builder()
            .id("wooho")
            .age(20)
            .money(100000000)
            .location(LocationStatus.SEOUL)
            .name("jhpark")
            .nickName("WoohoPark")
            .password("awjkefioajwefo")
            .role(AuthRoleStatus.HOST)
            .sexual(SexualStatus.FEMALE)
            .build();

        //when
        User actual = userRepository.save(expect.toEntity());

        //then
        assertThat(actual.getId()).isEqualTo(expect.getId());
        assertThat(actual.getAge()).isEqualTo(expect.getAge());
        assertThat(actual.getName()).isEqualTo(expect.getName());
        assertThat(actual.getNickName()).isEqualTo(expect.getNickName());
        assertThat(actual.getLocation()).isEqualTo(expect.getLocation());
        assertThat(actual.getRole()).isEqualTo(expect.getRole());
        assertThat(actual.getSexual()).isEqualTo(expect.getSexual());
    }

    @Test
    void 회원수정() {
        //given
        RequestUser expect = RequestUser.builder()
            .userNo(1L)
            .id("wooho")
            .age(21)
            .money(100000000)
            .location(LocationStatus.BUSAN)
            .name("jhpark2")
            .nickName("WoohoPark2")
            .password("EDDDIfeawfawef")
            .role(AuthRoleStatus.GUEST)
            .sexual(SexualStatus.MALE)
            .build();

        //when
        User actual = userRepository.save(expect.toEntity());

        //then
        assertThat(actual.getId()).isEqualTo(expect.getId());
        assertThat(actual.getAge()).isEqualTo(expect.getAge());
        assertThat(actual.getName()).isEqualTo(expect.getName());
        assertThat(actual.getNickName()).isEqualTo(expect.getNickName());
        assertThat(actual.getLocation()).isEqualTo(expect.getLocation());
        assertThat(actual.getRole()).isEqualTo(expect.getRole());
        assertThat(actual.getSexual()).isEqualTo(expect.getSexual());
    }

    @Test
    void 회원전체조회() {
        //given
        int actualSize = 1;
        String expectId = "wooho";
        int expectAge = 20;

        //when
        List<User> actual = userRepository.findAll();

        //then
        assertThat(actualSize).isEqualTo(actual.size());
        actual.stream().forEach(
            obj -> {
                assertThat(obj.getId()).isEqualTo(expectId);
                assertThat(obj.getAge()).isEqualTo(expectAge);
            }
        );
    }

    @Sql("classpath:db/tableInit.sql")
    @Test
    void 회원삭제(){
        //given
        Long userNo = 1L;

        //when
        userRepository.deleteByUserNo(userNo);

        //then
        assertThat(userRepository.findByUserNo(userNo)).isEmpty();
    }
}