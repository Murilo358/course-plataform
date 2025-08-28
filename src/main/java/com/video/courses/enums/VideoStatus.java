package com.video.courses.enums;

public enum VideoStatus {

    waiting("waiting"),

    uploading("uploading"),

    ready("ready"),

    errored("errored"),

    expired("expired");

    private final String literal;


    VideoStatus(String literal) {
        this.literal = literal;
    }
}

