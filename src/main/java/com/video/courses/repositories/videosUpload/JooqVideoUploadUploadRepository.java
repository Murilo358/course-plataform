package com.video.courses.repositories.videosUpload;

import com.video.courses.models.enums.VideoStatus;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.video.courses.models.Tables.VIDEOS_UPLOAD;

@Repository
public class JooqVideoUploadUploadRepository implements VideoUploadRepository {

    private final DSLContext dsl;

    public JooqVideoUploadUploadRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public long createPreVideoRegister(String uploadUrl, String errorMessage) {

        return dsl.insertInto(VIDEOS_UPLOAD)
                .set(VIDEOS_UPLOAD.UPLOAD_URL, uploadUrl)
                .set(VIDEOS_UPLOAD.ERROR_MESSAGE, errorMessage)
                .set(VIDEOS_UPLOAD.STATUS, VideoStatus.waiting)
                .returning(VIDEOS_UPLOAD.ID)
                .execute();

    }

    public boolean doesPreRegisterVideoExists(Long preRegisterVideoId) {

        return dsl.fetchExists(
                dsl.selectFrom(VIDEOS_UPLOAD)
                        .where(VIDEOS_UPLOAD.ID.eq(Math.toIntExact(preRegisterVideoId)))
        );
    }
}
