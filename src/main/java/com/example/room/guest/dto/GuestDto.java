package com.example.room.guest.dto;

import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.guest.entity.Guest;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class GuestDto {

    private long userNo;
    private String id;
    @NotNull(message = "나이가 입력되지 않았습니다.")
    private int age;
    @NotNull(message = "이름이 입력되지 않았습니다.")
    private String name;
    @NotNull(message = "별명이 입력되지 않았습니다.")
    private String nickName;
    @NotNull(message = "성별이 입력되지 않았습니다.")
    private SexualStatus sexual;

    @NotNull(message = "지역이 입력되지 않았습니다.")
    private LocationStatus location;

    private Date createDate;

    private Date birthDate;

    private Date updateDate;

    @Builder
    public GuestDto(long userNo, String id, int age, String name, String nickName, SexualStatus sexual, LocationStatus location, Date createDate , Date birthDate , Date updateDate){
        this.userNo = userNo;
        this.id = id;
        this.age = age;
        this.name = name;
        this.nickName = nickName;
        this.sexual = sexual;
        this.location = location;
        this.createDate = createDate;
        this.birthDate = birthDate;
        this.updateDate = updateDate;
    }

    public GuestDto(Guest guest){
        this.userNo = guest.getUserNo();
        this.id = guest.getId();
        this.age = guest.getAge();
        this.name = guest.getName();
        this.nickName = guest.getNickName();
        this.sexual = guest.getSexual();
        this.location = guest.getLocation();
        this.createDate = guest.getCreateDate();
        this.birthDate = guest.getBirthDate();
        this.updateDate = guest.getUpdateDate();
    }

    public Guest toEntity(){
        return Guest.builder()
                .id(id)
                .age(age)
                .name(name)
                .nickName(nickName)
                .sexual(sexual)
                .location(location)
                .createDate(createDate)
                .birthDate(birthDate)
                .updateDate(updateDate)
                .build();
    }
}
