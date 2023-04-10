package com.example.room.review.entity;

import com.example.room.guest.entity.Guest;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "REVIEW")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private long id;

    @Lob
    @Column(nullable = false)
    private String context;

    @Column(nullable = false)
    private int score;

    @Temporal(TemporalType.DATE)
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "GUEST_ID")
    Guest guest;
}
