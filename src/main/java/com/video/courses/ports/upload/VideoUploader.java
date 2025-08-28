package com.video.courses.ports.upload;

import com.video.courses.dto.VideoUploaderDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface VideoUploader {

    public VideoUploaderDTO getUploadUrl();

    public void uploadVideoToExternalApi(MultipartFile file, Optional<String> optUrl);
}
