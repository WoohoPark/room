package com.example.room.space.entity.space;

import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SpaceTypeStatus;
import com.example.room.user.entity.Host;
import com.example.room.reservation.entity.Reservation;
import com.example.room.review.entity.Review;
import com.example.room.space.entity.facility.Facility;
import com.example.room.space.entity.rental.Rental;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Entity(name = "SPACE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SPACE_ID")
    private long id;

    @Column(length = 2)
    private boolean withDog;

    @Column(length = 2)
    private int peopleCount;

    @Column(length = 30)
    private String name;

    @Column(nullable = false,length = 5)
    @Enumerated(EnumType.STRING)
    private LocationStatus location;

    @Column(nullable = false, length = 10)
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
            mappedBy = "space",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
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

    @PrePersist
    private void onCreate() {
        createDate = new Date();
    }

    @PreUpdate
    private void onUpdate() {
        updateDate = new Date();
    }
    @Builder
    public Space(long id, boolean withDog, int peopleCount, String name, LocationStatus location, BigDecimal latitude, BigDecimal longitude, Date createDate, Date updateDate, Rental rental, Facility facility, Host host, List<Review> reviews, List<Reservation> reservations) {
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
        this.host = host;
        this.reviews = reviews;
        this.reservations = reservations;
    }


}
