package com.video.courses.dto.course;

import java.time.OffsetDateTime;

public record CreateCourseDTO(
        String title,
        String description,
        String level,
        long categoryId,
        Long totalDuration,
        boolean published,
        long professorId,
        String[] requirements,
        OffsetDateTime createdAt
) {
}
