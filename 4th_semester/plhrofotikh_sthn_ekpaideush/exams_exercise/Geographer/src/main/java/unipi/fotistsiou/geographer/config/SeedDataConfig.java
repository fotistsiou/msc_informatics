package unipi.fotistsiou.geographer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import unipi.fotistsiou.geographer.entity.Role;
import unipi.fotistsiou.geographer.entity.User;
import unipi.fotistsiou.geographer.service.RoleService;
import unipi.fotistsiou.geographer.service.UserService;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class SeedDataConfig implements CommandLineRunner {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public SeedDataConfig (
            UserService userService,
            RoleService roleService
    ){
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<User> optionalUser = userService.findOneByEmail("fotis.tsioumas@outlook.com");
        if (optionalUser.isEmpty()) {
            Role doctor = new Role();
            doctor.setName("ROLE_STUDENT");
            roleService.saveRole(doctor);

            User user1 = new User();

            user1.setFirstName("Φώτης");
            user1.setLastName("Τσιούμας");
            user1.setEmail("fotis.tsioumas@outlook.com");
            user1.setPassword("1234!@#$qwer");
            Set<Role> roles1 = new HashSet<>();
            roleService.findRoleByName("ROLE_DOCTOR").ifPresent(roles1::add);
            user1.setRoles(roles1);

            userService.saveUser(user1, user1.getRoles().toString());
        }
    }
}