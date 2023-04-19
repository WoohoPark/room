package com.example.room.space.entity.space;

import javax.persistence.*;

@Entity
@DiscriminatorValue("partyRoom")
public class SpacePartyRoom extends Space{

}