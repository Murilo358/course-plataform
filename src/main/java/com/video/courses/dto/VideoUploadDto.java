package com.video.courses.dto;

import jakarta.validation.constraints.NotNull;

public record VideoUploadDto(@NotNull Long uploadId, @NotNull String videoTitle, String videoDescription, @NotNull Long courseId, @NotNull Long externalVideoId) {
}
