package com.example.room.space.entity.rental;

import com.example.room.space.entity.space.Space;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "RENTAL")
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RENTAL_ID")
    private long id;

    @Column(length = 1)
    private boolean partySupplies;

    @Column(length = 1)
    private boolean backgroundPaper;

    @OneToOne
    @JoinColumn(name = "SPACE_ID")
    private Space space;

    @Builder
    public Rental(long id, boolean partySupplies, boolean backgroundPaper, Space space) {
        this.id = id;
        this.partySupplies = partySupplies;
        this.backgroundPaper = backgroundPaper;
        this.space = space;
    }
}
