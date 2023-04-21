package com.example.room.review.entity;

import com.example.room.space.entity.space.Space;
import com.example.room.user.entity.Guest;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "REVIEW")
public class Review {

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

    @Temporal(TemporalType.DATE)
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "GUEST_ID")
    Guest guest;

    @ManyToOne
    @JoinColumn(name = "SPACE_ID")
    Space space;
}
