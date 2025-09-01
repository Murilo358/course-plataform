package com.video.courses.repositories.courses;

import com.video.courses.models.courses.CourseModel;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.video.courses.models.Tables.COURSES;

@Repository
public class JooqCourseRepository implements CourseRepository {

    private final DSLContext dslContext;

    public JooqCourseRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public boolean courseExists(long courseId) {
        return dslContext.fetchExists(
                dslContext.selectFrom(COURSES)
                        .where(COURSES.ID.eq(Math.toIntExact(courseId)))
        );
    }

    @Override
    public CourseModel findCourseById(long courseId) {

        Record record = dslContext
                .select()
                .from(COURSES)
                .where(COURSES.ID.eq(Math.toIntExact(courseId))).fetchOne();

        if(record != null){
            CourseModel courseModel = new CourseModel();
            courseModel.setId(record.getValue(COURSES.ID));
            courseModel.setTitle(record.getValue(COURSES.TITLE));
            courseModel.setDescription(record.getValue(COURSES.DESCRIPTION));
            courseModel.setLevel(record.getValue(COURSES.LEVEL));
            courseModel.setCategoryId(record.getValue(COURSES.CATEGORY_ID));
            courseModel.setThumbnailUrl(record.getValue(COURSES.THUMBNAIL_URL));
            courseModel.setTotalDuration(record.getValue(COURSES.TOTAL_DURATION));
            courseModel.setPublished(record.getValue(COURSES.PUBLISHED));
            courseModel.setRequirements(List.of(record.getValue(COURSES.REQUIREMENTS)));
            courseModel.setCreatedAt(record.getValue(COURSES.CREATED_AT));
            courseModel.setUpdatedAt(record.getValue(COURSES.UPDATED_AT));
            return courseModel;
        }

        return null;
    }
}
