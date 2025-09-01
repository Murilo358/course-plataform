package com.video.courses.repositories.courses;

import com.video.courses.models.courses.CourseModel;

public interface CourseRepository {

    boolean courseExists(long courseId);

    CourseModel findCourseById(long courseId);
}
