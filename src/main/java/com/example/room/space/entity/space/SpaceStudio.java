package com.example.room.space.entity.space;

import javax.persistence.*;

@Entity
@DiscriminatorValue("studio")
public class SpaceStudio extends Space {

}
