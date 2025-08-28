package com.video.courses;

import com.video.courses.dto.VideoUploadDto;
import com.video.courses.dto.VideoUploaderDTO;
import com.video.courses.models.enums.VideoStatus;
import com.video.courses.ports.upload.VideoUploader;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import static com.video.courses.models.Tables.VIDEOS_UPLOAD;

@Service
public class VideosService {

    private final VideoUploader videoUploader;

    private final DSLContext dsl;

    public VideosService(VideoUploader videoUploader, DSLContext dsl) {
        this.videoUploader = videoUploader;
        this.dsl = dsl;
    }

    public VideoUploadDto getUploadUrl(){
        VideoUploaderDTO upload = videoUploader.getUploadUrl();

        long videoUploadId = dsl.insertInto(VIDEOS_UPLOAD)
                .set(VIDEOS_UPLOAD.UPLOAD_URL, upload.uploadUrl())
                .set(VIDEOS_UPLOAD.ERROR_MESSAGE, upload.errorMessage())
                .set(VIDEOS_UPLOAD.STATUS, VideoStatus.waiting)
                .returning(VIDEOS_UPLOAD.ID)
                .execute();
        return new VideoUploadDto(videoUploadId, upload.uploadUrl(), upload.errorMessage());

    }


}
