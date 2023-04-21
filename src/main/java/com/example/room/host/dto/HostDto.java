package com.example.room.host.dto;

import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.host.entity.Host;
import lombok.Builder;

import java.util.Date;

public class HostDto {

    private long userNo;
     private String id;
     private int age;
     private SexualStatus sexual;
     private String name;
     private String nickName;
     private LocationStatus location;
     private Date createDate;
     private Date updateDate;
     private int businessNumber;

     @Builder
    public HostDto(long userNo, String id, int age, SexualStatus sexual, String name, String nickName, LocationStatus location, Date createDate, Date updateDate, int businessNumber) {
        this.userNo = userNo;
        this.id = id;
        this.age = age;
        this.sexual = sexual;
        this.name = name;
        this.nickName = nickName;
        this.location = location;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.businessNumber = businessNumber;
    }

    public HostDto(Host host) {
        this.userNo = host.getUserNo();
        this.id = host.getId();
        this.age = host.getAge();
        this.sexual = host.getSexual();
        this.name = host.getName();
        this.nickName = host.getNickName();
        this.location = host.getLocation();
        this.createDate = host.getCreateDate();
        this.updateDate = host.getUpdateDate();
        this.businessNumber = host.getBusinessNumber();
    }

    public Host toEntity() {
        return Host.builder()
                .id(id)
                .age(age)
                .name(name)
                .sexual(sexual)
                .nickName(nickName)
                .location(location)
                .createDate(createDate)
                .updateDate(updateDate)
                .businessNumber(businessNumber)
                .build();
    }
}
