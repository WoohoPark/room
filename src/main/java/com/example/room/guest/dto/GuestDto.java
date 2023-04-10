package com.example.room.guest.dto;

import com.example.room.guest.entity.Guest;
import com.example.room.user.domain.SexualStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GuestDto {

    long id;
    int age;
    String name;
    String nickName;
    SexualStatus sexual;
    long businessNumber;

    public GuestDto(Guest guest){
        this.id = guest.getId();
        this.age = guest.getAge();
        this.name = guest.getName();
        this.nickName = guest.getNickName();
        this.sexual = guest.getSexual();
        this.businessNumber = guest.getBusinessNumber();
    }

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
