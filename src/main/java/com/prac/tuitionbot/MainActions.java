package com.prac.tuitionbot;

public enum MainActions {
    MY_POINTS("My Points"),
    REDEMPTION("Redemption"),
    REFER("Refer A Friend");

    public String getName() {
        return name;
    }

    private String name;

    MainActions(String name) {
        this.name = name;
    }


}
