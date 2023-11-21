package unipi.fotistsiou.geographer.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import unipi.fotistsiou.geographer.entity.User;
import unipi.fotistsiou.geographer.service.UserService;
import java.util.Optional;

@Controller
public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController (
        UserService userService
    ){
        this.userService = userService;
    }

    @GetMapping("/register/student")
    public String getRegisterForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register_student";
    }

    @PostMapping("/register/{role}")
    public String registerUser(
        @PathVariable String role,
        @Valid @ModelAttribute("user") User user,
        BindingResult result,
        Model model
    ){
        Optional<User> optionalUser = userService.findOneByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            result.rejectValue("email", "error.email", "Υπάρχει ήδη ένας λογαριασμός εγγεγραμμένος με αυτό το email. Δοκιμάστε με άλλο λογαριασμό email.");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            if (role.equals("ROLE_STUDENT")) {
                return "register_student";
            }
            return "404";
        }
        userService.saveUser(user, role);
        return "redirect:/login?success_register";
    }
}