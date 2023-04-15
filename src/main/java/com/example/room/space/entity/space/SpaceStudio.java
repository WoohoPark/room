package com.example.room.space.entity.space;

import javax.persistence.*;

@Entity
@DiscriminatorValue("studio")
public class SpaceStudio extends Space {

//    @Id
//    @GeneratedValue
//    @Column(name = "STUDIO_ID")
//    private long id;
//
//    @OneToOne(mappedBy = "spaceEntity")
//    private Facility facility;
}
