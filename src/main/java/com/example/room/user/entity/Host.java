package com.example.room.user.entity;

import com.example.room.space.entity.space.Space;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Entity(name = "HOST")
@SuperBuilder
@NoArgsConstructor
@DiscriminatorValue("host")
public class Host extends User {

    @OneToMany(mappedBy = "host")
    private List<Space> spaces;

    private int businessNumber;

}
