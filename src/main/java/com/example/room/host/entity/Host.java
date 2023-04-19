package com.example.room.host.entity;

import com.example.room.space.entity.space.Space;
import com.example.room.user.entity.User;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity(name = "HOST")
@Getter
@SuperBuilder
@DiscriminatorValue("host")
public class Host extends User {

    @OneToMany(mappedBy = "host")
    private List<Space> spaces;

    private int businessNumber;

}
