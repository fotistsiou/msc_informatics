package unipi.fotistsiou.geographer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import unipi.fotistsiou.geographer.entity.Quiz;
import unipi.fotistsiou.geographer.entity.Result;
import unipi.fotistsiou.geographer.entity.User;
import unipi.fotistsiou.geographer.service.QuestionService;
import unipi.fotistsiou.geographer.service.ResultService;
import unipi.fotistsiou.geographer.service.UserService;
import java.security.Principal;
import java.util.Optional;

@Controller
public class QuestionController {
    private final QuestionService questionService;
    private final UserService userService;
    private final ResultService resultService;
    Boolean submitted = false;

    @Autowired
    public QuestionController (
        QuestionService questionService,
        UserService userService,
        ResultService resultService
    ){
        this.questionService = questionService;
        this.userService = userService;
        this.resultService = resultService;
    }

    @GetMapping("/quiz/{chapter}")
    @PreAuthorize("isAuthenticated()")
    public String getQuiz (
        @PathVariable String chapter,
        Model model
    ){
        submitted = false;
        Quiz quiz = questionService.getQuestionsByChapter(chapter);
        model.addAttribute("quiz", quiz);
        model.addAttribute("chapter", chapter);
        return "quiz";
    }

    @PostMapping("/quiz/{chapter}")
    @PreAuthorize("isAuthenticated()")
    public String submitQuiz (
        @PathVariable String chapter,
        @ModelAttribute Quiz quiz,
        Principal principal
    ){
        if(!submitted) {
            String authUsername = "anonymousUser";
            if (principal != null) {
                authUsername = principal.getName();
            }
            Optional<User> optionalUser = userService.findOneByEmail(authUsername);
            if (optionalUser.isPresent()) {
                Result result = new Result();
                result.setUser(optionalUser.get());
                result.setChapter(chapter);
                result.setTotalCorrect(resultService.getResult(quiz));
                resultService.saveResult(result);
                submitted = true;
                return String.format("redirect:/result/%d?success", result.getId());
            }
        }
        return "redirect:/";
    }
}