package unipi.fotistsiou.eduverse.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import unipi.fotistsiou.eduverse.entity.User;
import unipi.fotistsiou.eduverse.service.UserService;
import java.util.Optional;

@Controller
public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterMidForm() {
        return "register/register";
    }

    @GetMapping("/register/professor")
    public String getRegisterAsProfessorForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register/register_professor";
    }

    @GetMapping("/register/student")
    public String getRegisterAsStudentForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register/register_student";
    }

    @PostMapping("/register/{role}")
    public String registerNewUser(
        @PathVariable String role,
        @Valid @ModelAttribute("user") User user,
        BindingResult result,
        Model model
    ){
        Optional<User> optionalUser = userService.findUserByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            result.rejectValue("email", "error.email", "Υπάρχει ήδη χρήστης με το συγκεκριμένο email.");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            if (role.equals("ROLE_PROFESSOR")) {
                return "register/register_professor";
            } else if (role.equals("ROLE_STUDENT")) {
                return "register/register_student";
            }
            return "register/register";
        }
        userService.saveUser(user, role);
        userService.addAm(user);
        return "redirect:/login?success_register";
    }
}