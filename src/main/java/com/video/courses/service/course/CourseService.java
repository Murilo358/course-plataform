package com.video.courses.service.course;

import com.video.courses.dto.course.CreateCourseDTO;
import com.video.courses.exceptions.ValidationException;
import com.video.courses.repositories.category.CategoryRepository;
import com.video.courses.repositories.courses.CourseRepository;
import com.video.courses.repositories.professors.ProfessorsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    private final CategoryRepository categoryRepository;

    private final ProfessorsRepository professorsRepository;

    public CourseService(CourseRepository courseRepository, CategoryRepository categoryRepository, ProfessorsRepository professorsRepository) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
        this.professorsRepository = professorsRepository;
    }

    public void validateNewCourse(CreateCourseDTO createCourseDTO){

        List<ValidationException.FieldError> errors = new ArrayList<>();

        if(!categoryRepository.isCategoryExists(createCourseDTO.categoryId())){
            errors.add(new ValidationException.FieldError("A valid category is required!", "the sent category id wasn't found"));
        }

        if(createCourseDTO.totalDuration() < 30){
            errors.add(new ValidationException.FieldError("The total duration must be at least 30 minutes!", "the sent total duration is less than 30 minutes"));
        }

        if(!professorsRepository.isProfessorExists(createCourseDTO.professorId())){
            errors.add(new ValidationException.FieldError("A valid professor is required!", "the sent professor id wasn't found"));
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }


    }

    public long createNewCourse(CreateCourseDTO createCourseDTO){

        validateNewCourse(createCourseDTO);

        return courseRepository.createNewCourse(createCourseDTO);

    }

}
