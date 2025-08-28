package com.video.courses;

import com.video.courses.dto.ExternalVideoUploaderDto;
import com.video.courses.dto.PreVideoUploadReturnDTO;
import com.video.courses.dto.VideoUploadDto;
import com.video.courses.ports.upload.VideoUploader;
import com.video.courses.repositories.videos.VideoRepository;
import org.springframework.stereotype.Service;

@Service
public class VideosService {

    private final VideoUploader videoUploader;
    private final VideoRepository videoRepository;

    public VideosService(VideoUploader videoUploader, VideoRepository videoRepository) {
        this.videoUploader = videoUploader;
        this.videoRepository = videoRepository;
    }

    public PreVideoUploadReturnDTO getUploadUrl(){
        ExternalVideoUploaderDto upload = videoUploader.getUploadUrl();

        if(upload == null){
            return null;
        }

        long preVideoRegisterId = videoRepository.createPreVideoRegister(upload.uploadUrl(), upload.errorMessage());

        return new PreVideoUploadReturnDTO(preVideoRegisterId, upload.uploadUrl(), upload.errorMessage());

    }


    private void validate(VideoUploadDto dto){

        videoRepository.doesPreRegisterVideoExists(dto.uploadId()); //todo throw new validation exception

        dto.courseId(); //todo verify if course exists

        dto.externalVideoId(); //todo colocar como not null no request



    }

    public Object createNewVideo(VideoUploadDto dto) {
        return null; //todo implements
    }
}
