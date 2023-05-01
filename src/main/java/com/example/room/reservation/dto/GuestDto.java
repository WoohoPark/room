package com.example.room.reservation.dto;

import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.user.entity.Guest;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GuestDto {

    private Long userNo;
    private int money;
    private SexualStatus sexual;
    private String name;
    private String nickName;
    private LocationStatus location;

    @Builder
    public GuestDto(Long userNo, int money, SexualStatus sexual, String name, String nickName,
        LocationStatus location) {
        this.userNo = userNo;
        this.money = money;
        this.sexual = sexual;
        this.name = name;
        this.nickName = nickName;
        this.location = location;
    }

    public Guest toEntity(){
        return Guest.builder()
            .userNo(userNo)
            .money(money)
            .sexual(sexual)
            .name(name)
            .nickName(nickName)
            .build();
    }
}
