package unipi.fotistsiou.geographer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import unipi.fotistsiou.geographer.entity.User;
import unipi.fotistsiou.geographer.service.UserService;
import java.security.Principal;
import java.util.Optional;

@Controller
public class HomepageController {
    private final UserService userService;

    @Autowired
    public HomepageController (
        UserService userService
    ){
        this.userService = userService;
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
        Optional<User> optionalUser = userService.findOneByEmail(authUsername);
        if (optionalUser.isPresent()) {
            String username = optionalUser.get().getFirstName();
            Long userId = optionalUser.get().getId();
            model.addAttribute("username", username);
            model.addAttribute("userId", userId);
        }
        return "home";
    }
}