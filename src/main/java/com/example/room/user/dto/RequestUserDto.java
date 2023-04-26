package com.example.room.user.dto;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.user.entity.User;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor
public class RequestUserDto {

    private long userNo;

    @Size(min = 5, max = 30)
    @NotBlank(message = "ID를 입력해주세요.")
    private String id;

    @NotBlank(message = "Password 입력해주세요.")
    private String password;

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "닉네임을 입력해주세요.")
    private String nickName;

    @NotNull(message = "지역을 입력해주세요.")
    private LocationStatus location;

    @NotNull(message = "나이를 입력해주세요.")
    private int age;

    @NotNull(message = "사용자유형을 입력해주세요.")
    private AuthRoleStatus role;

    @NotNull(message = "성별을 입력해주세요.")
    private SexualStatus sexual;

    public void cryptPassword(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.password = bCryptPasswordEncoder.encode(this.password);
    }

    @Builder
    public RequestUserDto(long userNo, String id, String password, int age, AuthRoleStatus role,
        SexualStatus sexual, String name, String nickName, LocationStatus location) {
        this.userNo = userNo;
        this.id = id;
        this.password = password;
        this.age = age;
        this.role = role;
        this.sexual = sexual;
        this.name = name;
        this.nickName = nickName;
        this.location = location;
    }

    public User toEntity() {
        return User.builder()
            .userNo(userNo)
            .id(id)
            .password(this.password)
            .age(age)
            .role(role)
            .sexual(sexual)
            .name(name)
            .nickName(nickName)
            .location(location)
            .build();

    }


}
