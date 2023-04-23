package com.example.room.user.dto;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@NoArgsConstructor
public class UserDto {

    private long userNo;

    @NotEmpty(message = "ID를 입력해주세요.")
    private String id;

    @NotEmpty(message = "Password 입력해주세요.")
    private String password;

    @NotEmpty(message = "나이를 입력해주세요.")
    private int age;

    @NotEmpty(message = "사용자유형을 입력해주세요.")
    private AuthRoleStatus role;

    @NotEmpty(message = "성별을 입력해주세요.")
    private SexualStatus sexual;

    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;

    @NotEmpty(message = "닉네임을 입력해주세요.")
    private String nickName;
    @NotEmpty(message = "지역을 입력해주세요.")
    private LocationStatus location;

    private Date createDate;

    private Date updateDate;

    public void setPassword(String password) {
        this.password = password;
    }

    @Builder
    public UserDto(long userNo, String id, String password, int age, AuthRoleStatus role,
        SexualStatus sexual, String name, String nickName, LocationStatus location, Date createDate,
        Date updateDate) {
        this.userNo = userNo;
        this.id = id;
        setPassword(password);
        this.age = age;
        this.role = role;
        this.sexual = sexual;
        this.name = name;
        this.nickName = nickName;
        this.location = location;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

}
