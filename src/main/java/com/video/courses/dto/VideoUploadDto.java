package com.video.courses.dto;

public record VideoUploadDto(Long uploadId, String videoTitle, String videoDescription, Long courseId, Long externalVideoId) {
}
