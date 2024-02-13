package unipi.fotistsiou.eduverse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import unipi.fotistsiou.eduverse.entity.User;
import unipi.fotistsiou.eduverse.service.CourseService;
import unipi.fotistsiou.eduverse.service.UserService;
import java.security.Principal;
import java.util.Optional;

@Controller
public class HomeController {
    private final UserService userService;
    private final CourseService courseService;

    @Autowired
    public HomeController(
        UserService userService,
        CourseService courseService
    ){
        this.userService = userService;
        this.courseService = courseService;
    }

    @GetMapping("/")
    public String getHome(
        Model model,
        Principal principal
    ){
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.findUserByEmail(authUsername);
        if (optionalUser.isPresent()) {
            String username = optionalUser.get().getFirstName();
            Long userId = optionalUser.get().getId();
            model.addAttribute("username", username);
            model.addAttribute("userId", userId);
        }
        int numberOfCourses = courseService.numberOfCourses();
        int numberOfProfessors = userService.numberOfUsersByRole("ROLE_PROFESSOR");
        int numberOfStudents = userService.numberOfUsersByRole("ROLE_STUDENT");
        model.addAttribute("numberOfCourses", numberOfCourses);
        model.addAttribute("numberOfProfessors", numberOfProfessors);
        model.addAttribute("numberOfStudents", numberOfStudents);
        return "home/home";
    }
}