package com.video.courses.dto.course;

import jakarta.validation.constraints.*;

public record CreateCourseDTO(
        @NotBlank @Size(min = 3, max = 100) String title,
        @NotBlank @Size(min = 20, max = 1000) String description,
        @NotNull String level,
        @Positive  long categoryId,
        @PositiveOrZero  Long totalDuration,
        boolean published,
        @Positive long professorId,
        String[] requirements
) {
}
