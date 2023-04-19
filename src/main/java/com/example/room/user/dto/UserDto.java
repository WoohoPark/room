package com.example.room.user.dto;

import com.example.room.common.config.constants.AuthRoleStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.user.entity.User;
import lombok.Getter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Getter
public class UserDto {

    private long userNo;
    private String id;
    private String password;
    private int age;
    private AuthRoleStatus role;
    private SexualStatus sexual;
    private String name;
    private String nickName;
    private LocationStatus location;
    private Date createDate;
    private Date updateDate;

    public void setPassword(String password) {
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .id(id)
                .password(password)
                .role(role)
                .age(age)
                .name(name)
                .sexual(sexual)
                .nickName(nickName)
                .location(location)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

}
