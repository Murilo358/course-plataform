package com.video.courses.repositories.videos;

import com.video.courses.models.enums.VideoStatus;
import org.jooq.DSLContext;

import static com.video.courses.models.Tables.VIDEOS_UPLOAD;

public class JooqVideoRepository implements VideoRepository {

    private final DSLContext dsl;

    public JooqVideoRepository(DSLContext dsl) {
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
