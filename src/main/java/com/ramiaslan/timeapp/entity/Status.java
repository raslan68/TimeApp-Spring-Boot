package com.ramiaslan.timeapp.entity;

public enum Status {
    GEPLANT("geplant"),
    OFFEN("offen"),
    UNTERBROCHEN("unterbrochen"),
    GESCHLOSSEN("geschlossen");

    private String value;

    Status(String value) {
        this.value = value;
    }
}
