package com.example.room.fee.entity;

import com.example.room.fee.domain.PackageStatus;

import javax.persistence.*;

@Entity(name = "PACKAGE")
@DiscriminatorValue("package")
public class PackageEntity extends FeeEntity {

    @Enumerated(EnumType.STRING)
    private PackageStatus packageStatus;

}
