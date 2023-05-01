package com.example.room.common.constants;

public enum MorningAfternoonStatus {
    AM(1),
    PM(1.5);

    double premium;

    MorningAfternoonStatus(double premium) {
        this.premium = premium;
    }

    public double getPremium() {
        return premium;
    }
}
