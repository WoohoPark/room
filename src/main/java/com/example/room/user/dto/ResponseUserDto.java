package com.example.room.user.dto;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.user.entity.User;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseUserDto {

    private final Long userNo;
    private final String id;
    private final String password;
    private final int age;
    private final AuthRoleStatus role;
    private final SexualStatus sexual;
    private final String name;
    private final String nickName;
    private final LocationStatus location;
    private final Date createDate;
    private final Date updateDate;

    @Builder
    public ResponseUserDto(User user) {
        this.userNo = user.getUserNo();
        this.id = user.getId();
        this.password = user.getPassword();
        this.age = user.getAge();
        this.role = user.getRole();
        this.sexual = user.getSexual();
        this.name = user.getName();
        this.nickName = user.getNickName();
        this.location = user.getLocation();
        this.createDate = user.getCreateDate();
        this.updateDate = user.getUpdateDate();
    }
}
