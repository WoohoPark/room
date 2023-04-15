package com.example.room.space.entity.space;

import com.example.room.host.entity.Host;
import com.example.room.reservation.entity.Reservation;
import com.example.room.review.entity.Review;
import com.example.room.space.entity.facility.Facility;
import com.example.room.space.entity.rental.Rental;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "SPACE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "SPACE_TYPE")
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SPACE_ID")
    private long id;

    private boolean withDog;

    private int peopleCount;

    private String name;

    private String location;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @OneToOne(mappedBy = "space")
    private Rental rental;

    @OneToOne(mappedBy = "space")
    private Facility facility;

    @ManyToOne
    @JoinColumn(name = "HOST_ID")
    Host host;

    @OneToMany(mappedBy = "space")
    List<Review> reviews;

    @OneToMany(mappedBy = "space")
    List<Reservation> reservations;
}
