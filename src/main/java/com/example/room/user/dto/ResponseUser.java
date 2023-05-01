package com.example.room.user.dto;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.user.entity.User;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseUser {

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
    public ResponseUser(Long userNo, String id, String password, int age, AuthRoleStatus role,
        SexualStatus sexual, String name, String nickName, LocationStatus location, Date createDate,
        Date updateDate) {
        this.userNo = userNo;
        this.id = id;
        this.password = password;
        this.age = age;
        this.role = role;
        this.sexual = sexual;
        this.name = name;
        this.nickName = nickName;
        this.location = location;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public ResponseUser(User user) {
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
