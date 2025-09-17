package com.video.courses.controller.couse;

import com.video.courses.dto.course.CreateCourseDTO;
import com.video.courses.service.course.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Long> newCourse(@RequestBody CreateCourseDTO createCourseDTO){
        return ResponseEntity.ok(courseService.createNewCourse(createCourseDTO));
    }

}
