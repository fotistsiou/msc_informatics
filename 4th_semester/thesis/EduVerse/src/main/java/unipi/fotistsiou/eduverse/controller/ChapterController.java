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
import unipi.fotistsiou.eduverse.entity.Chapter;
import unipi.fotistsiou.eduverse.entity.Course;
import unipi.fotistsiou.eduverse.entity.User;
import unipi.fotistsiou.eduverse.service.ChapterService;
import unipi.fotistsiou.eduverse.service.CourseService;
import unipi.fotistsiou.eduverse.service.UserService;
import java.security.Principal;
import java.util.Optional;

@Controller
public class ChapterController {
    private final ChapterService chapterService;
    private final CourseService courseService;
    private final UserService userService;

    @Autowired
    public ChapterController(
        ChapterService chapterService,
        CourseService courseService,
        UserService userService
    ){
        this.chapterService = chapterService;
        this.courseService = courseService;
        this.userService = userService;
    }

    @GetMapping("/chapter/new/{courseId}/{userId}")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public String createChapterForm(
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
                        Chapter chapter = new Chapter();
                        chapter.setCourse(course);
                        model.addAttribute("courseId", courseId);
                        model.addAttribute("userId", userId);
                        model.addAttribute("chapter", chapter);
                        return "chapter/chapter_new";
                    }
                    return "error/error_403";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @PostMapping("/chapter/new/{courseId}/{userId}")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public String createChapter(
        @PathVariable Long courseId,
        @PathVariable Long userId,
        @Valid @ModelAttribute("chapter") Chapter chapter,
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
                    Course course = optionalCourse.get();
                    if (course.getProfessor().getId().equals(userId)) {
                        if (result.hasErrors()) {
                            model.addAttribute("chapter", chapter);
                            model.addAttribute("userId", userId);
                            return "chapter/chapter_new";
                        }
                        chapterService.saveChapter(chapter);
                        return String.format("redirect:/course/view/%d/%d?success_create_chapter", courseId, userId);
                    }
                    return "error/error_403";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/chapter/view/{chapterId}/{userId}")
    @PreAuthorize("isAuthenticated()")
    public String getChapter(
        @PathVariable Long chapterId,
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
                Optional<Chapter> optionalChapter = chapterService.findChapterById(chapterId);
                if (optionalChapter.isPresent()) {
                    Chapter chapter = optionalChapter.get();
                    if (
                        chapter.getCourse().getStudents().contains(user)
                        ||
                        chapter.getCourse().getProfessor().getId().equals(userId)
                    ){
                        Long courseId = chapter.getCourse().getId();
                        model.addAttribute("chapter", chapter);
                        model.addAttribute("courseId", courseId);
                        model.addAttribute("userId", userId);
                        return "chapter/chapter_view";
                    }
                    return "error/error_403";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/chapter/delete/{chapterId}/{userId}")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public String deleteChapter(
        @PathVariable Long chapterId,
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
                Optional<Chapter> optionalChapter = chapterService.findChapterById(chapterId);
                if (optionalChapter.isPresent()) {
                    Chapter chapter = optionalChapter.get();
                    if (chapter.getCourse().getProfessor().getId().equals(userId)) {
                        chapterService.deleteChapter(chapter);
                        return String.format("redirect:/course/view/%d/%d?success_delete_chapter", chapter.getCourse().getId(), userId);
                    }
                    return "error/error_403";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/chapter/edit/{chapterId}/{userId}")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public String editChapterForm(
        @PathVariable Long chapterId,
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
                Optional<Chapter> optionalChapter = chapterService.findChapterById(chapterId);
                if (optionalChapter.isPresent()) {
                    Chapter chapter = optionalChapter.get();
                    if (chapter.getCourse().getProfessor().getId().equals(userId)) {
                        model.addAttribute("chapter", chapter);
                        return "chapter/chapter_edit";
                    }
                    return "error/error_403";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @PostMapping("/chapter/edit/{chapterId}/{userId}")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public String editChapter(
        @PathVariable Long chapterId,
        @PathVariable Long userId,
        @Valid @ModelAttribute("chapter") Chapter chapter,
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
                Optional<Chapter> optionalChapter = chapterService.findChapterById(chapterId);
                if (optionalChapter.isPresent()) {
                    Chapter existingChapter = optionalChapter.get();
                    if (existingChapter.getCourse().getProfessor().getId().equals(userId)) {
                        if (result.hasErrors()) {
                            model.addAttribute("chapter", chapter);
                            return "chapter/chapter_edit";
                        }
                        existingChapter.setTitle(chapter.getTitle());
                        existingChapter.setContent(chapter.getContent());
                        chapterService.saveChapter(existingChapter);
                        return String.format("redirect:/course/view/%d/%d?success_edit_chapter", chapter.getCourse().getId(), userId);
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