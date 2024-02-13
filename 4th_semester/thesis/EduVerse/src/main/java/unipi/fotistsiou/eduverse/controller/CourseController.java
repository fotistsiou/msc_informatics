package unipi.fotistsiou.eduverse.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import unipi.fotistsiou.eduverse.entity.*;
import unipi.fotistsiou.eduverse.service.*;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {
    private final CourseService courseService;
    private final UserService userService;
    private final ChapterService chapterService;
    private final ResultService resultService;

    @Autowired
    public CourseController(
        CourseService courseService,
        UserService userService,
        ChapterService chapterService,
        ResultService resultService
    ){
        this.courseService = courseService;
        this.userService = userService;
        this.chapterService = chapterService;
        this.resultService = resultService;
    }

    @GetMapping("/course/new/{userId}")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public String createCourseForm(
        @PathVariable Long userId,
        Model model,
        Principal principal
    ){
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getEmail().equals(authUsername)) {
                Course course = new Course();
                course.setProfessor(user);
                model.addAttribute("course", course);
                return "course/course_new";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @PostMapping("/course/new/{userId}")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public String createCourse(
        @PathVariable Long userId,
        @Valid @ModelAttribute("course") Course course,
        BindingResult result,
        Model model,
        Principal principal
    ){
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getEmail().equals(authUsername)) {
                Optional<Course> optionalCourse = courseService.findCourseByCode(course.getCode());
                if (optionalCourse.isPresent()) {
                    result.rejectValue("code", "error.code", "Υπάρχει ήδη μάθημα με τον συγκεκριμένο κωδικό.");
                }
                if (result.hasErrors()) {
                    model.addAttribute("course", course);
                    return "course/course_new";
                }
                courseService.saveCourse(course);
                return String.format("redirect:/course/my/%d?success", course.getProfessor().getId());
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/course/my/{userId}")
    @PreAuthorize("isAuthenticated()")
    public String getMyCourses(
        @PathVariable Long userId,
        Model model,
        Principal principal
    ){
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getEmail().equals(authUsername)) {
                String role = user.getRoles().toString();
                List<Course> courses = courseService.findMyCourses(userId, role);
                model.addAttribute("role", role);
                model.addAttribute("courses", courses);
                return "course/course_my";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/course/student/all/{userId}")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public String getMyCourseStudentAll(
        @PathVariable Long userId,
        Model model,
        Principal principal
    ){
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getEmail().equals(authUsername)) {
                List<Course> courses = courseService.findMyCourses(userId, "ROLE_PROFESSOR");
                model.addAttribute("courses", courses);
                return "course/course_student_all";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/course/student/view/{courseId}/{studentId}/{professorId}")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public String getMyCourseStudentView(
        @PathVariable Long courseId,
        @PathVariable Long studentId,
        @PathVariable Long professorId,
        Model model,
        Principal principal
    ){
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalProfessor = userService.findUserById(professorId);
        if (optionalProfessor.isPresent()) {
            User professor = optionalProfessor.get();
            if (professor.getEmail().equals(authUsername)) {
                Optional<User> optionalStudent = userService.findUserById(studentId);
                if (optionalStudent.isPresent()) {
                    Optional<Course> optionalCourse = courseService.findCourseById(courseId);
                    if (optionalCourse.isPresent()) {
                        User student = optionalStudent.get();
                        Course course = optionalCourse.get();
                        if (
                            course.getProfessor().getId().equals(professorId)
                            &&
                            course.getStudents().contains(student)
                        ){
                            List<Result> results = resultService.findStudentCourseResults(courseId, studentId);
                            model.addAttribute("course", course);
                            model.addAttribute("results", results);
                            model.addAttribute("student", student);
                            model.addAttribute("userId", professorId);
                            return "course/course_student_view";
                        }
                        return "error/error_403";
                    }
                    return "error/error_404";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/course/delete/{courseId}/{userId}")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public String deleteCourse(
        @PathVariable Long courseId,
        @PathVariable Long userId,
        Principal principal
    ){
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getEmail().equals(authUsername)) {
                Optional<Course> optionalCourse = courseService.findCourseById(courseId);
                if (optionalCourse.isPresent()) {
                    Course course = optionalCourse.get();
                    if (course.getProfessor().getId().equals(userId)) {
                        courseService.deleteCourse(course);
                        return String.format("redirect:/course/my/%d?success_delete", userId);
                    }
                    return "error/error_403";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/course/register/{userId}")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public String getAllCourses(
        @PathVariable Long userId,
        Model model,
        Principal principal
    ){
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getEmail().equals(authUsername)) {
                List<Course> courses = courseService.findAvailableCourses(userId);
                model.addAttribute("courses", courses);
                return "course/course_register";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/course/register/{courseId}/{userId}")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public String registerCourse(
        @PathVariable Long courseId,
        @PathVariable Long userId,
        Principal principal
    ){
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getEmail().equals(authUsername)) {
                Optional<Course> optionalCourse = courseService.findCourseById(courseId);
                if (optionalCourse.isPresent()) {
                    Course course = optionalCourse.get();
                    course.getStudents().add(user);
                    courseService.saveCourse(course);
                    return String.format("redirect:/course/my/%d?success_register", userId);
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/course/remove/{courseId}/{userId}")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public String removeCourse(
        @PathVariable Long courseId,
        @PathVariable Long userId,
        Principal principal
    ){
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getEmail().equals(authUsername)) {
                Optional<Course> optionalCourse = courseService.findCourseById(courseId);
                if (optionalCourse.isPresent()) {
                    Course course = optionalCourse.get();
                    if (course.getStudents().contains(user)) {
                        course.getStudents().remove(user);
                        courseService.saveCourse(course);
                        return String.format("redirect:/course/my/%d?success_remove", userId);
                    }
                    return "error/error_403";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/course/view/{courseId}/{userId}")
    @PreAuthorize("isAuthenticated()")
    public String getCourse(
        @PathVariable Long courseId,
        @PathVariable Long userId,
        Model model,
        Principal principal
    ){
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getEmail().equals(authUsername)) {
                Optional<Course> optionalCourse = courseService.findCourseById(courseId);
                if (optionalCourse.isPresent()) {
                    Course course = optionalCourse.get();
                    if (course.getStudents().contains(user) || course.getProfessor().getId().equals(userId)) {
                        List<Chapter> chapters = chapterService.findAllCourseChapters(courseId);
                        String role = user.getRoles().toString();
                        model.addAttribute("course", course);
                        model.addAttribute("chapters", chapters);
                        model.addAttribute("userId", userId);
                        model.addAttribute("role", role);
                        return "course/course_view";
                    }
                    return "error/error_403";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/course/edit/{courseId}/{userId}")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public String editCourseForm(
        @PathVariable Long courseId,
        @PathVariable Long userId,
        Model model,
        Principal principal
    ){
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getEmail().equals(authUsername)) {
                Optional<Course> optionalCourse = courseService.findCourseById(courseId);
                if (optionalCourse.isPresent()) {
                    Course course = optionalCourse.get();
                    if (course.getProfessor().getId().equals(userId)) {
                        model.addAttribute("course", course);
                        return "course/course_edit";
                    }
                    return "error/error_403";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @PostMapping("/course/edit/{courseId}/{userId}")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public String editCourse(
        @PathVariable Long courseId,
        @PathVariable Long userId,
        @Valid @ModelAttribute("course") Course course,
        BindingResult result,
        Model model,
        Principal principal
    ){
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getEmail().equals(authUsername)) {
                Optional<Course> optionalCourse = courseService.findCourseById(courseId);
                if (optionalCourse.isPresent()) {
                    Course existingCourse = optionalCourse.get();
                    if (existingCourse.getProfessor().getId().equals(userId)) {
                        if (!course.getCode().equals(existingCourse.getCode())) {
                            Optional<Course> optCourse = courseService.findCourseByCode(course.getCode());
                            if (optCourse.isPresent()) {
                                result.rejectValue("code", "error.code", "Υπάρχει ήδη μάθημα με τον συγκεκριμένο κωδικό.");
                            }
                        }
                        if (result.hasErrors()) {
                            model.addAttribute("course", course);
                            return "course/course_edit";
                        }
                        existingCourse.setCode(course.getCode());
                        existingCourse.setTitle(course.getTitle());
                        existingCourse.setDescription(course.getDescription());
                        courseService.saveCourse(existingCourse);
                        return String.format("redirect:/course/my/%d?success_edit", userId);
                    }
                    return "error/error_403";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }
}