package com.example.room.space.entity;

import com.example.room.facility.entity.FacilityEntity;
import com.example.room.host.entity.HostEntity;
import com.example.room.rental.entity.RentalEntity;
import com.example.room.reservation.entity.ReservationEntity;
import com.example.room.review.entity.ReviewEntity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "SPACE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "SPACE_TYPE")
public class SpaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SPACE_ID")
    private long id;

    private String name;

    private String location;

    @OneToOne(mappedBy = "spaceEntity")
    private RentalEntity rental;

    @OneToOne(mappedBy = "spaceEntity")
    private FacilityEntity facility;

    @ManyToOne
    @JoinColumn(name = "HOST_ID")
    HostEntity hostEntity;

    @ManyToOne
    @JoinColumn(name = "REVIEW_ID")
    ReviewEntity reviewEntity;

    @OneToMany(mappedBy = "spaceEntity")
    List<ReservationEntity> reservationEntities;
}
