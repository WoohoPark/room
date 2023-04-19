package com.example.room.host.service;

import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.host.dao.HostDAO;
import com.example.room.host.dto.HostDto;
import com.example.room.host.repository.HostRepository;
import com.example.room.host.service.impl.HostServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = {HostServiceImpl.class, HostDAO.class})
public class HostServiceTest {

    @MockBean
    HostDAO hostDAO;

    @Autowired
    HostServiceImpl hostService;

    @Test
    void 호스트생성(){

        HostDto hostDto = HostDto.builder()
                .age(12)
                .sexual(SexualStatus.MALE)
                .name("test")
                .nickName("abc")
                .location(LocationStatus.DAEJEON)
                .createDate(new Date())
                .businessNumber(122234)
                .build();


        given(hostDAO.create(hostDto)).willReturn(hostDto);

        HostDto expected = hostDAO.create(hostDto);

        Assertions.assertNotNull(expected);


    }

    @Test
    void 호스트수정(){

    }

    @Test
    void 호스트조회(){

    }

}
