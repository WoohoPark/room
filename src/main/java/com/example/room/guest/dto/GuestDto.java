package com.example.room.guest.dto;

import com.example.room.guest.entity.Guest;
import com.example.room.user.domain.SexualStatus;
import lombok.*;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class GuestDto {
    private long id;
    private int age;
    private String name;
    private String nickName;
    private SexualStatus sexual;
    private long businessNumber;

    @Builder
    public GuestDto(int id, int age, String name, String nickName, SexualStatus sexual, long businessNumber){
        this.id = id;
        this.age = age;
        this.name = name;
        this.nickName = nickName;
        this.sexual = sexual;
        this.businessNumber = businessNumber;
    }

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
