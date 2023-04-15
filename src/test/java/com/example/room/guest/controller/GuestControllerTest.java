package com.example.room.guest.controller;

import com.example.room.guest.dto.GuestDto;
import com.example.room.guest.service.GuestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GuestController.class)
public class GuestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GuestService guestService;

    private GuestDto guestDto;

    @BeforeEach
    public void setUp(){
        guestDto = GuestDto.builder()
                .id(1234)
                .age(23)
                .name("T")
                .nickName("abc")
                .sexual(SexualStatus.FEMALE).build();
    }

    @Test
    void 회원가입() throws Exception {
        given(guestService.join(guestDto)).willReturn(guestDto);
        String content = new ObjectMapper().writeValueAsString(guestDto);
        mockMvc.perform(
                    post("/guest")
                    .content(content)
                    .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.age").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.nickName").exists())
                .andExpect(jsonPath("$.sexual").exists())
                .andExpect(jsonPath("$.businessNumber").exists())
                .andDo(print());
    }

    @Test
    void 회원조회() throws Exception {
        given(guestService.find("T")).willReturn(guestDto);
        String name = "T";
        mockMvc.perform(
                get("/guest")
                        .param("name",name)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.age").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.nickName").exists())
                .andExpect(jsonPath("$.sexual").exists())
                .andExpect(jsonPath("$.businessNumber").exists())
                .andDo(print());
    }
}
