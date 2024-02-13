package unipi.fotistsiou.eduverse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import unipi.fotistsiou.eduverse.entity.Role;
import unipi.fotistsiou.eduverse.entity.User;
import unipi.fotistsiou.eduverse.repository.UserRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService (
        UserRepository userRepository,
        RoleService roleService,
        PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void updatePassword(User user) {
        userRepository.save(user);
    }

    public void saveUser(User user, String role) {
        if (user.getId() == null) {
            if (user.getRoles().isEmpty()) {
                Set<Role> roles = new HashSet<>();
                roleService.findRoleByName(role).ifPresent(roles::add);
                user.setRoles(roles);
            }
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void addAm(User user) {
        String am = null;
        if (user.getId() != null) {
            am = generateAm(user.getId(), user.getRoles().toString());
            if (!am.isEmpty()) {
                user.setAm(am);
            }
        }
        userRepository.updateUserDetailsAm(user.getId(), am);
    }

    public void updateUserDetails(User user) {
        userRepository.updateUserDetails(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getTelephone()
        );
    }

    public int numberOfUsersByRole(String role) {
        List<User> users = userRepository.findAll();
        int usersByRole = 0;
        for (User user:users) {
            if (user.getRoles().toString().contains(role)) {
                usersByRole++;
            }
        }
        return usersByRole;
    }

    /* --------------- Helper Function --------------- */

    private String generateAm(Long userId, String role) {
        String prefix = role.contains("ROLE_PROFESSOR") ? "eduprof" : "edustud";
        String userIdStr = String.format("%05d", userId);
        return prefix + userIdStr;
    }
}