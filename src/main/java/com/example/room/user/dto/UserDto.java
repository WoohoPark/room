package com.example.room.user.dto;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import java.util.Date;
import lombok.Getter;

@Getter
public class UserDto {

    private Long userNo;
    private String id;
    private String password;
    private int age;
    private int money;
    private AuthRoleStatus role;
    private SexualStatus sexual;
    private String name;
    private String nickName;
    private LocationStatus location;
    private Date createDate;
    private Date updateDate;
}
