package unipi.fotistsiou.eduverse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unipi.fotistsiou.eduverse.repository.RoleRepository;
import unipi.fotistsiou.eduverse.entity.Role;
import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService (RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }

    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}