package com.example.room.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.user.dto.RequestUserDto;
import com.example.room.user.dto.ResponseUserDto;
import com.example.room.user.entity.User;
import com.example.room.user.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void 회원등록() {
        //given
        RequestUserDto expect = RequestUserDto.builder()
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

        //when & stub
        when(userRepository.save(any())).thenReturn(expect.toEntity());
        ResponseUserDto actual = userService.join(expect);

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
    void 회원수정() throws Exception {
        //given
        long userNo = 1L;
        RequestUserDto expect = RequestUserDto.builder()
            .userNo(1L)
            .id("wooho2")
            .age(22)
            .money(100000000)
            .location(LocationStatus.DAEGU)
            .name("hopark")
            .nickName("EditWooho")
            .password("awjkefioajwefo")
            .role(AuthRoleStatus.GUEST)
            .sexual(SexualStatus.MALE)
            .build();
        Optional<User> optionalExpected = Optional.of(expect.toEntity());

        //when & stub
        when(userRepository.findByUserNo(userNo)).thenReturn(optionalExpected);
        ResponseUserDto actual = userService.update(expect);

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
    void 회원전체조회() throws Exception {
        //given
        List<User> expect = new ArrayList<>();
        expect.add(User.builder()
            .id("wooho2")
            .age(22)
            .money(100000000)
            .location(LocationStatus.DAEGU)
            .name("hopark")
            .nickName("EditWooho")
            .password("awjkefioajwefo")
            .role(AuthRoleStatus.GUEST)
            .sexual(SexualStatus.MALE)
            .build());
        expect.add(User.builder()
            .id("wooho")
            .age(20)
            .money(100000002)
            .location(LocationStatus.SEOUL)
            .name("jhpark")
            .nickName("WoohoPark")
            .password("awjkefioajwefo")
            .role(AuthRoleStatus.HOST)
            .sexual(SexualStatus.FEMALE)
            .build());

        int expectSize = 2;

        //when & stub
        when(userRepository.findAll()).thenReturn(expect);
        List<ResponseUserDto> actual = userService.findAll();

        //then
        assertThat(actual.size()).isEqualTo(expectSize);
        IntStream.range(0, 2)
            .forEach(i -> {
                assertThat(actual.get(i).getAge()).isEqualTo(expect.get(i).getAge());
                assertThat(actual.get(i).getUserNo()).isEqualTo(expect.get(i).getUserNo());
                assertThat(actual.get(i).getName()).isEqualTo(expect.get(i).getName());
                assertThat(actual.get(i).getRole()).isEqualTo(expect.get(i).getRole());
                assertThat(actual.get(i).getLocation()).isEqualTo(expect.get(i).getLocation());
                assertThat(actual.get(i).getSexual()).isEqualTo(expect.get(i).getSexual());
            });
    }


}