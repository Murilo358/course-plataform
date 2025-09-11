package com.video.courses.ports.upload;

import com.video.courses.dto.video.ExternalVideoUploaderDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface VideoUploader {

    public ExternalVideoUploaderDto getUploadUrl();

    public void uploadVideoToExternalApi(MultipartFile file, Optional<String> optUrl);
}
