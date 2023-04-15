package com.example.room.guest.dto;

import com.example.room.common.constants.SexualStatus;
import com.example.room.guest.entity.Guest;
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
    @Builder
    public GuestDto(int id, int age, String name, String nickName, SexualStatus sexual){
        this.id = id;
        this.age = age;
        this.name = name;
        this.nickName = nickName;
        this.sexual = sexual;
    }

    public GuestDto(Guest guest){
        this.id = guest.getId();
        this.age = guest.getAge();
        this.name = guest.getName();
        this.nickName = guest.getNickName();
        this.sexual = guest.getSexual();
    }

    public Guest toEntity(){
        return Guest.builder()
                .age(age)
                .name(name)
                .nickName(nickName)
                .sexual(sexual)
                .build();
    }
}
