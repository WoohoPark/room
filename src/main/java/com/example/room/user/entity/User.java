package com.example.room.user.entity;

import com.example.room.common.config.auth.constants.AuthRoleStatus;
import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SexualStatus;
import com.example.room.reservation.entity.Reservation;
import com.example.room.space.entity.Space;
import com.example.room.user.dto.RequestUser;
import com.example.room.user.dto.ResponseUser;
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

    @OneToMany(mappedBy = "user")
    List<Reservation> reservations;

    @OneToMany(mappedBy = "user")
    private List<Space> spaces;

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

    public void update(RequestUser RequestUser) {
        this.age = RequestUser.getAge();
        this.location = RequestUser.getLocation();
        this.nickName = RequestUser.getNickName();
        this.password = RequestUser.getPassword();
        this.name = RequestUser.getName();
        this.sexual = RequestUser.getSexual();
        this.role = RequestUser.getRole();
    }
}
