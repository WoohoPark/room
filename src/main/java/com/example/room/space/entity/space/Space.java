package com.example.room.space.entity.space;

import com.example.room.common.constants.LocationStatus;
import com.example.room.common.constants.SpaceTypeStatus;
import com.example.room.space.dto.FacilityDto;
import com.example.room.space.dto.RentalDto;
import com.example.room.space.dto.RequestSpace;
import com.example.room.space.dto.ResponseSpace;
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

    //    @OneToOne(
//        mappedBy = "space",
//        cascade = CascadeType.ALL,
//        orphanRemoval = true,
//        fetch = FetchType.LAZY
//    )
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "RENTAL_ID")
    private Rental rental;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FACILITY_ID")
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
    public Space(long id, boolean withDog, int peopleCount, String name, LocationStatus location,
        BigDecimal latitude, BigDecimal longitude, Date createDate, Date updateDate, Rental rental,
        Facility facility, Host host, List<Review> reviews, List<Reservation> reservations,
        SpaceTypeStatus spaceType) {
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
        this.spaceType = spaceType;
        this.reviews = reviews;
        this.reservations = reservations;
    }

    public ResponseSpace toDto() {
        return ResponseSpace.builder()
            .id(id)
            .withDog(withDog)
            .peopleCount(peopleCount)
            .name(name)
            .location(location)
            .latitude(latitude)
            .longitude(longitude)
            .createDate(createDate)
            .updateDate(updateDate)
            .rentalDto(rental.toDto())
            .facilityDto(facility.toDto())
            .build();
    }

    public void updateRental(RentalDto rentalDto) {
        this.rental = Rental.builder()
            .id(rentalDto.getId())
            .partySupplies(rentalDto.isPartySupplies())
            .backgroundPaper(rentalDto.isBackgroundPaper())
            .build();
    }

    public void updateFacility(FacilityDto facilityDto) {
        this.facility = Facility.builder()
            .id(facilityDto.getId())
            .light(facilityDto.isLight())
            .speaker(facilityDto.isSpeaker())
            .tableware(facilityDto.isTableware())
            .tableYn(facilityDto.isTableYn())
            .wifi(facilityDto.isWifi())
            .build();
    }

    public void update(RequestSpace requestSpace) {
        this.id = requestSpace.getId();
        this.withDog = requestSpace.isWithDog();
        this.peopleCount = requestSpace.getPeopleCount();
        this.name = requestSpace.getName();
        this.location = requestSpace.getLocation();
        this.latitude = requestSpace.getLatitude();
        this.longitude = requestSpace.getLongitude();
        this.updateRental(requestSpace.getRentalDto());
        this.updateFacility(requestSpace.getFacilityDto());
        this.spaceType = requestSpace.getSpaceType();
    }
}
