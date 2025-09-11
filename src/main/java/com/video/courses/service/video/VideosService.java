package com.video.courses.service.video;

import com.video.courses.dto.video.ExternalVideoUploaderDto;
import com.video.courses.dto.video.PreVideoUploadReturnDTO;
import com.video.courses.dto.video.VideoUploadDto;
import com.video.courses.exceptions.ValidationException;
import com.video.courses.ports.upload.VideoUploader;
import com.video.courses.repositories.courses.CourseRepository;
import com.video.courses.repositories.videos.VideoRepository;
import com.video.courses.repositories.videosUpload.VideoUploadRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideosService {

    private final VideoUploader videoUploader;
    private final VideoUploadRepository videoUploadRepository;
    private final CourseRepository courseRepository;
    private final VideoRepository videoRepository;

    public VideosService(VideoUploader videoUploader, VideoUploadRepository videoUploadRepository, CourseRepository courseRepository, VideoRepository videoRepository) {
        this.videoUploader = videoUploader;
        this.videoUploadRepository = videoUploadRepository;
        this.courseRepository = courseRepository;
        this.videoRepository = videoRepository;
    }

    public PreVideoUploadReturnDTO getUploadUrl(){
        ExternalVideoUploaderDto upload = videoUploader.getUploadUrl();

        if(upload == null){
            return null;
        }

        long preVideoRegisterId = videoUploadRepository.createPreVideoRegister(upload.uploadUrl(), upload.errorMessage());

        return new PreVideoUploadReturnDTO(preVideoRegisterId, upload.uploadUrl(), upload.errorMessage());

    }


    private void validate(VideoUploadDto dto){

        List<ValidationException.FieldError> errors = new ArrayList<>();

        if (!videoUploadRepository.doesPreRegisterVideoExists(dto.uploadId())) {
            errors.add(new ValidationException.FieldError("Pre register video required!", "the sent pre registered video id wasn't found"));
        }

        if (!courseRepository.isCourseExists(dto.courseId())) {
            errors.add(new ValidationException.FieldError("A valid course is required!", "the sent course id wasn't found"));
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }

    }

    public long createNewVideo(VideoUploadDto videoUploadDto) {
        validate(videoUploadDto);

        return videoRepository.saveNewVideo(videoUploadDto);
    }
}
