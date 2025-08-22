package com.video.courses;

import com.video.courses.ports.upload.VideoUploader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class VideosService {

    private final VideoUploader videoUploader;

    public VideosService(VideoUploader videoUploader) {
        this.videoUploader = videoUploader;
    }

    public String upload(MultipartFile file){
        Optional<String> uploadUrl = videoUploader.getUploadUrl();
        return null;
    }


}
