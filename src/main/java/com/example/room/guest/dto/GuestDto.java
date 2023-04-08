package com.example.room.guest.dto;

import com.example.room.guest.domain.Guest;
import com.example.room.user.domain.SexualStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GuestDto {

    int age;
    String name;
    String nickName;
    SexualStatus sexual;
    long businessNumber;

    public Guest toEntity(){
        return Guest.builder()
                .age(age)
                .name(name)
                .nickName(nickName)
                .sexual(sexual)
                .businessNumber(businessNumber)
                .build();
    }


}
