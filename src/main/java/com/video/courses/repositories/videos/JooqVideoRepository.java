package com.video.courses.repositories.videos;

import com.video.courses.dto.video.VideoUploadDto;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

import static com.video.courses.models.tables.Videos.VIDEOS;

@Repository
public class JooqVideoRepository implements VideoRepository {

    private final DSLContext dslContext;

    public JooqVideoRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public long saveNewVideo(VideoUploadDto videoUploadDto) {

        return dslContext.insertInto(VIDEOS)
                .set(VIDEOS.EXTERNAL_VIDEO_ID, videoUploadDto.externalVideoId())
                .set(VIDEOS.CREATED_AT, OffsetDateTime.now())
                .set(VIDEOS.TITLE, videoUploadDto.videoTitle())
                .set(VIDEOS.DESCRIPTION, videoUploadDto.videoDescription())
                .set(VIDEOS.COURSE_ID, videoUploadDto.courseId())
                .returning(VIDEOS.ID)
                .execute();

    }
}
