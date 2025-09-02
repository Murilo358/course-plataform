package com.video.courses.repositories.videos;

import com.video.courses.dto.VideoUploadDto;

public interface VideoRepository {

    long saveNewVideo(VideoUploadDto videoUploadDto);
}
