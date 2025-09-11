package com.video.courses.service.course;

import com.video.courses.dto.course.CreateCourseDTO;
import com.video.courses.repositories.courses.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public long createNewCourse(CreateCourseDTO createCourseDTO){

        //todo validate

        return courseRepository.createNewCourse(createCourseDTO);

    }

}
