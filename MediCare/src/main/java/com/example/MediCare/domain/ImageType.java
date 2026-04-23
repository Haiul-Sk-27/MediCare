package com.example.MediCare.domain;

public enum ImageType {

    MANAGER("manager"),
    STAFF("staff"),
    PHARMACY("pharmacy"),
    COMMON("common");


    private final String folder;

    ImageType(String folder) {
        this.folder = folder;
    }

    public String getFolder() {
        return folder;
    }
}