package unipi.fotistsiou.eduverse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unipi.fotistsiou.eduverse.entity.Course;
import unipi.fotistsiou.eduverse.entity.User;
import unipi.fotistsiou.eduverse.repository.CourseRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService (CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public int numberOfCourses() {
        return courseRepository.findAll().size();
    }

    public Optional<Course> findCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Optional<Course> findCourseByCode(String code) {
        return courseRepository.findCourseByCode(code);
    }

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }

    public List<Course> findMyCourses(Long userId, String role) {
        List<Course> myCourses = new ArrayList<>();
        List<Course> courses = courseRepository.findAll();
        for (Course course:courses) {
            if (role.contains("ROLE_PROFESSOR")) {
                if (course.getProfessor().getId().equals(userId)) {
                    myCourses.add(course);
                }
            } else if (role.contains("ROLE_STUDENT")) {
                boolean isUserEnrolled = false;
                for (User student:course.getStudents()) {
                    if (student.getId().equals(userId)) {
                        isUserEnrolled = true;
                        break;
                    }
                }
                if (isUserEnrolled) {
                    myCourses.add(course);
                }
            }
        }
        return myCourses;
    }

    public List<Course> findAvailableCourses(Long userId) {
        List<Course> availableCourses = new ArrayList<>();
        List<Course> courses = courseRepository.findAll();
        for (Course course:courses) {
            boolean isUserEnrolled = false;
            for (User student:course.getStudents()) {
                if (student.getId().equals(userId)) {
                    isUserEnrolled = true;
                    break;
                }
            }
            if (!isUserEnrolled) {
                availableCourses.add(course);
            }
        }
        return availableCourses;
    }
}