package com.video.courses.ports.upload;

import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface VideoUploader {

    public Optional<String> getUploadUrl();

    public void uploadVideoToExternalApi(MultipartFile file, Optional<String> optUrl);
}
