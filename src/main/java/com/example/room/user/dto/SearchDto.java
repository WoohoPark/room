package com.example.room.user.dto;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class SearchDto {
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
}
