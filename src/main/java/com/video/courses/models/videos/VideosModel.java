package com.video.courses.models.videos;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class VideosModel {

    private long id;
    private String externalVideoId;
    private long courseId;
    private String title;
    private String description;
    private long totalDuration;
    private OffsetDateTime createdAt;
}
