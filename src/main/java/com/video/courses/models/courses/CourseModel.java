package com.video.courses.models.courses;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class CourseModel {

    private long id;
    private String title;
    private String description;
    private String level;
    private long categoryId;
    private String thumbnailUrl;
    private long totalDuration;
    private boolean published;
    private long professorId;
    private List<String> requirements;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
