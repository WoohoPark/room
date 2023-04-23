package com.example.room.fee;

import com.example.room.common.constants.PackageStatus;

import javax.persistence.*;

@Entity(name = "FEE_PACKAGE")
@DiscriminatorValue("package")
public class FeePackage extends Fee {

    @Id
    @GeneratedValue
    @Column(name = "FEE_PACKAGE_ID")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 7)
    private PackageStatus packageType;

}
