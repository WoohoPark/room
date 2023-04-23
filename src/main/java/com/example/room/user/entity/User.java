package com.example.room.user.entity;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(
    name = "USERS"
//    ,
//    uniqueConstraints = {
//        @UniqueConstraint(name = "UniqueNickName", columnNames = "nickName")
//    })
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
    private long userNo;

    @Column(nullable = false, length = 30)
    private String id;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false)
    private int age;
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

    public List<String> getRoleList() {
        // TODO : NULL CHECK
        Optional<String> optionalRoles = Optional.ofNullable(role.toString());
//        String roles = optionalRoles.get();
        return Arrays.asList(optionalRoles.get().split(","));
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
