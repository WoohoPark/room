package com.example.room.user.service;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.user.dao.UserDAO;
import com.example.room.user.dto.UserDto;
import com.example.room.user.entity.User;
import com.example.room.user.mapper.UserMapper;
import com.example.room.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Calendar;
import java.util.Date;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserServiceImpl.class, UserDAO.class, BCryptPasswordEncoder.class})
public class UserServiceTest {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserServiceImpl userService;
    @MockBean
    private UserDAO userDAO;
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private UserDto userDto;
    private User user;

    @BeforeEach
    void 셋업(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,3);
        userDto = UserDto.builder()
                .id("wooho")
                .age(33)
                .location(LocationStatus.SEOUL)
                .name("Park")
                .nickName("안녕")
                .password("waoefjoa@!#")
                .role(AuthRoleStatus.HOST)
                .sexual(SexualStatus.MALE)
                .createDate(new Date())
                .updateDate(calendar.getTime())
                .build();
        user = userMapper.convertUserEntity(userDto);
    }

    @Test
    void 회원가입(){
//        when(userDAO.join(userDto)).thenReturn(userDto);
//        UserDto accept = userDAO.join(userDto);
//        Assertions.assertEquals(accept.getId(), userDto.getId());
//        Assertions.assertEquals(accept.getAge(), userDto.getAge());
//        Assertions.assertEquals(accept.getLocation(), userDto.getLocation());
//        Assertions.assertEquals(accept.getName(), userDto.getName());
//        Assertions.assertEquals(accept.getNickName(), userDto.getNickName());
//        Assertions.assertEquals(accept.getPassword(), userDto.getPassword());
//        Assertions.assertEquals(accept.getRole(), userDto.getRole());
//        Assertions.assertEquals(accept.getSexual(), userDto.getSexual());
//        verify(userDAO).join(userDto);
    }

    @Test
    void 회원목록(){

    }

}
