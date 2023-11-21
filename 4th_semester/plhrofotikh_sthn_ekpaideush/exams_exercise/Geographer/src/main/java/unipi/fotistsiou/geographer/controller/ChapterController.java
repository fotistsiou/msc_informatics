package unipi.fotistsiou.geographer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import unipi.fotistsiou.geographer.entity.User;
import unipi.fotistsiou.geographer.service.UserService;
import java.security.Principal;
import java.util.Optional;

@Controller
public class ChapterController {
    private final UserService userService;

    @Autowired
    public ChapterController (
            UserService userService
    ){
        this.userService = userService;
    }

    private void AuthUser(Model model, Principal principal) {
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findOneByEmail(authUsername);
        if (optionalUser.isPresent()) {
            String username = optionalUser.get().getFirstName();
            Long userId = optionalUser.get().getId();
            model.addAttribute("username", username);
            model.addAttribute("userId", userId);
        }
    }

    @GetMapping("/chapter/one")
    @PreAuthorize("isAuthenticated()")
    public String getChapterOne(
        Model model,
        Principal principal
    ){
        AuthUser(model, principal);
        return "chapter_one";
    }

    @GetMapping("/chapter/two")
    @PreAuthorize("isAuthenticated()")
    public String getChapterTwo(
        Model model,
        Principal principal
    ){
        AuthUser(model, principal);
        return "chapter_two";
    }

    @GetMapping("/chapter/three")
    @PreAuthorize("isAuthenticated()")
    public String getChapterThree(
        Model model,
        Principal principal
    ){
        AuthUser(model, principal);
        return "chapter_three";
    }

    @GetMapping("/chapter/four")
    @PreAuthorize("isAuthenticated()")
    public String getChapterFour(
        Model model,
        Principal principal
    ){
        AuthUser(model, principal);
        return "chapter_four";
    }

    @GetMapping("/chapter/five")
    @PreAuthorize("isAuthenticated()")
    public String getChapterFive(
        Model model,
        Principal principal
    ){
        AuthUser(model, principal);
        return "chapter_five";
    }

    @GetMapping("/chapter/quizzes")
    @PreAuthorize("isAuthenticated()")
    public String getChapterQuizzes(
            Model model,
            Principal principal
    ){
        AuthUser(model, principal);
        return "chapter_quizzes";
    }
}