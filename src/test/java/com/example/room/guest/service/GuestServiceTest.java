package com.example.room.guest.service;

import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.guest.dao.GuestDAO;
import com.example.room.guest.dto.GuestDto;
import com.example.room.guest.entity.Guest;
import com.example.room.guest.service.impl.GuestServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {GuestServiceImpl.class, GuestDAO.class})
public class GuestServiceTest {

    @MockBean
    private GuestDAO guestDAO;

    @Autowired
    private GuestServiceImpl guestService;

    private GuestDto guestDto;

    private Guest guest;

    @BeforeEach
    public void setUp(){
        guestDto = GuestDto.builder()
                .id(String.valueOf(1234))
                .age(23)
                .name("T")
                .nickName("abc")
                .sexual(SexualStatus.FEMALE)
                .location(LocationStatus.SEOUL)
                .createDate(new Date())
                .build();

        guest = Guest.builder()
                .id(String.valueOf(1))
                .age(23)
                .name("T")
                .nickName("abc")
                .sexual(SexualStatus.FEMALE)
                .location(LocationStatus.SEOUL)
                .build();
    }

    @Test
    void 회원가입(){
//        given(guestDAO.save(guestDto)).willReturn(guest);
//        GuestDto response = guestService.join(guestDto);
//        Assertions.assertNotNull(response);
//        verify(guestDAO).save(guestDto);
    }

    @Test
    void 회원조회(){
//        String nickName = "abc";
//        given(guestDAO.findByNickName(nickName)).willReturn(guest);
//        Guest response = guestDAO.findByNickName(nickName);
//        Assertions.assertNotNull(response);
//        verify(guestDAO).findByNickName(nickName);
    }

    @Test
    void 회원수정(){

    }

}
