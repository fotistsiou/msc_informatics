package unipi.fotistsiou.geographer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import unipi.fotistsiou.geographer.entity.Result;
import unipi.fotistsiou.geographer.entity.User;
import unipi.fotistsiou.geographer.service.ResultService;
import unipi.fotistsiou.geographer.service.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class ResultController {
    private final ResultService resultService;
    private final UserService userService;

    @Autowired
    public ResultController(
        ResultService resultService,
        UserService userService
    ){
        this.resultService = resultService;
        this.userService = userService;
    }

    @GetMapping("/result/{id}")
    @PreAuthorize("isAuthenticated()")
    public String getResult(
            @PathVariable Long id,
            Model model,
            Principal principal
    ) {
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<Result> optionalResult = resultService.getResultById(id);
        if (optionalResult.isPresent()) {
            Result result = optionalResult.get();
            if (!result.getUser().getEmail().equals(authUsername)) {
                return "404";
            }
            model.addAttribute("result", result);
            return "result";
        } else {
            return "404";
        }
    }

    @GetMapping("/result/all/{id}")
    @PreAuthorize("isAuthenticated()")
    public String getResultAll(
            @PathVariable Long id,
            Model model,
            Principal principal
    ) {
        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName();
        }
        Optional<User> optionalUser = userService.getUserById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (!user.getEmail().equals(authUsername)) {
                return "404";
            }
            List<Result> results = resultService.getUserResults(id);
            model.addAttribute("results", results);
            return "result_all";
        } else {
            return "404";
        }
    }
}