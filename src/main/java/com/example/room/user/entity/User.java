package com.example.room.user.entity;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.user.dto.RequestUserDto;
import com.example.room.user.dto.ResponseUserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(
    name = "USERS"
)
@Getter
@SuperBuilder
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "userType")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_NO")
    private Long userNo;

    @Column(nullable = false, length = 30)
    private String id;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private int money;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuthRoleStatus role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private SexualStatus sexual;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 30)
    private String nickName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private LocationStatus location;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @PrePersist
    private void onCreate() {
        createDate = new Date();
    }

    @PreUpdate
    private void onUpdate() {
        updateDate = new Date();
    }

    public List<String> getRoles() {
        Optional<String> optionalRoles = Optional.ofNullable(role.toString());
        return optionalRoles.map(s -> Arrays.asList(s.split(",")))
            .orElseGet(() -> List.of(""));
    }

    public void update(RequestUserDto requestUserDto) {
        this.age = requestUserDto.getAge();
        this.location = requestUserDto.getLocation();
        this.nickName = requestUserDto.getNickName();
        this.password = requestUserDto.getPassword();
        this.name = requestUserDto.getName();
        this.sexual = requestUserDto.getSexual();
        this.role = requestUserDto.getRole();
    }
}
