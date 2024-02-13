package unipi.fotistsiou.eduverse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class QuizController {
    private final QuestionService questionService;
    private final UserService userService;
    private final ChapterService chapterService;
    private final ResultService resultService;
    private final QuizQuestionService quizQuestionService;

    @Autowired
    public QuizController(
        QuestionService questionService,
        UserService userService,
        ChapterService chapterService,
        ResultService resultService,
        QuizQuestionService quizQuestionService
    ){
        this.questionService = questionService;
        this.userService = userService;
        this.chapterService = chapterService;
        this.resultService = resultService;
        this.quizQuestionService = quizQuestionService;
    }

    @GetMapping("/quiz/{chapterId}/{userId}")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public String getQuiz (
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
                    if (chapter.getCourse().getStudents().contains(user)) {
                        Quiz quiz = questionService.findQuestionsByChapter(chapterId);
                        model.addAttribute("quiz", quiz);
                        model.addAttribute("chapter", chapter);
                        model.addAttribute("userId", userId);
                        return "quiz/quiz";
                    }
                    return "error/error_403";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @PostMapping("/quiz/{chapterId}/{userId}")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public String submitQuiz (
        @PathVariable Long chapterId,
        @PathVariable Long userId,
        @ModelAttribute Quiz quiz,
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
                    if (chapter.getCourse().getStudents().contains(user)) {
                        int corrects = resultService.generateCorrects(quiz);
                        int wrongs = resultService.generateWrongs(quiz);
                        String feedback = resultService.generateFeedback(corrects, wrongs);
                        Result result = new Result();
                        result.setCorrect(corrects);
                        result.setWrong(wrongs);
                        result.setFeedback(feedback);
                        result.setChapter(chapter);
                        result.setStudent(user);
                        resultService.saveResult(result);
                        quizQuestionService.saveQuizQuestions(quiz, result, user);
                        return String.format("redirect:/quiz/result/%d/%d?success_submit_quiz", result.getId(), userId);
                    }
                    return "error/error_403";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/quiz/result/{quizId}/{userId}")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public String getQuizResult(
        @PathVariable Long quizId,
        @PathVariable Long userId,
        Model model,
        Principal principal
    ) {
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getEmail().equals(authUsername)) {
                Optional<Result> optionalResult = resultService.findResultById(quizId);
                if (optionalResult.isPresent()) {
                    Result result = optionalResult.get();
                    if (result.getStudent().getEmail().equals(authUsername)) {
                        model.addAttribute("result", result);
                        model.addAttribute("userId", userId);
                        model.addAttribute("courseId", result.getChapter().getCourse().getId());
                        return "quiz/quiz_result";
                    }
                    return "error/error_403";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/quiz/result/all/{userId}")
    @PreAuthorize("isAuthenticated()")
    public String getQuizResultAll(
        @PathVariable Long userId,
        Model model,
        Principal principal
    ) {
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getEmail().equals(authUsername)) {
                List<Result> results = resultService.findStudentResults(userId);
                model.addAttribute("results", results);
                return "quiz/quiz_result_all";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/quiz/question/{resultId}/{userId}")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public String getQuizQuestions(
        @PathVariable Long resultId,
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
                Optional<Result> optionalResult = resultService.findResultById(resultId);
                if (optionalResult.isPresent()) {
                    Result result = optionalResult.get();
                    if (result.getStudent().getId().equals(userId)) {
                        List<QuizQuestion> quizQuestions = quizQuestionService.findQuizQuestionsByResultId(resultId);
                        String role = user.getRoles().toString();
                        model.addAttribute("result", result);
                        model.addAttribute("quizQuestions", quizQuestions);
                        model.addAttribute("userId", userId);
                        model.addAttribute("studentId", userId);
                        model.addAttribute("role", role);
                        return "quiz/quiz_question";
                    }
                    return "error/error_403";
                }
                return "error/error_404";
            }
            return "error/error_403";
        }
        return "error/error_404";
    }

    @GetMapping("/quiz/question/{resultId}/{studentId}/{professorId}")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public String getQuizQuestionsMyStudent(
        @PathVariable Long resultId,
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
                    Optional<Result> optionalResult = resultService.findResultById(resultId);
                    if (optionalResult.isPresent()) {
                        User student = optionalStudent.get();
                        Result result = optionalResult.get();
                        if (
                            result.getChapter().getCourse().getProfessor().getId().equals(professorId)
                            &&
                            result.getChapter().getCourse().getStudents().contains(student)
                            &&
                            result.getStudent().getId().equals(studentId)
                        ){
                            List<QuizQuestion> quizQuestions = quizQuestionService.findQuizQuestionsByResultId(resultId);
                            String role = professor.getRoles().toString();
                            Long courseId = result.getChapter().getCourse().getId();
                            model.addAttribute("result", result);
                            model.addAttribute("quizQuestions", quizQuestions);
                            model.addAttribute("studentId", studentId);
                            model.addAttribute("userId", professorId);
                            model.addAttribute("student", student);
                            model.addAttribute("role", role);
                            model.addAttribute("courseId", courseId);
                            return "quiz/quiz_question";
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
}