package com.example.room.space.entity;

import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SpaceTypeStatus;
import com.example.room.user.entity.Host;
import com.example.room.reservation.entity.Reservation;
import com.example.room.review.entity.Review;
import com.example.room.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Entity(name = "SPACE")
@NoArgsConstructor
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SPACE_ID")
    private Long id;

    @Column(length = 2)
    private boolean withDog;

    @Column(length = 2)
    private int peopleCount;

    @Column(length = 30)
    private String name;

    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    private LocationStatus location;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private SpaceTypeStatus spaceType;

    @Column(precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(precision = 10, scale = 7)
    private BigDecimal longitude;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @OneToOne(
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "RENTAL_ID")
    private Rental rental;

    @OneToOne(
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "FACILITY_ID")
    private Facility facility;

    @OneToOne(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JoinColumn(name = "FEE_ID")
    private Fee fee;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(name = "USER_NO")
    User user;

    @OneToMany(mappedBy = "space")
    List<Review> reviews;

    @OneToMany(mappedBy = "space")
    List<Reservation> reservations;

    @PrePersist
    private void onCreate() {
        createDate = new Date();
    }

    @PreUpdate
    private void onUpdate() {
        updateDate = new Date();
    }

    @Builder
    public Space(long id, boolean withDog, int peopleCount, String name, LocationStatus location,
        BigDecimal latitude, BigDecimal longitude, Date createDate, Date updateDate, Rental rental,
        Facility facility, User user, List<Review> reviews, List<Reservation> reservations,
        SpaceTypeStatus spaceType,Fee fee) {
        this.id = id;
        this.withDog = withDog;
        this.peopleCount = peopleCount;
        this.name = name;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.rental = rental;
        this.facility = facility;
        this.user = user;
        this.spaceType = spaceType;
        this.reviews = reviews;
        this.reservations = reservations;
        this.fee =fee;
    }
}
