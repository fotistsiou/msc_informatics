package unipi.fotistsiou.eduverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import unipi.fotistsiou.eduverse.entity.User;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

    @Modifying
    @Transactional
    @Query(
        "UPDATE User u SET " +
        "u.am = :am " +
        "WHERE u.id = :id"
    )
    void updateUserDetailsAm(
        @Param("id") Long id,
        @Param("am") String am
    );

    @Modifying
    @Transactional
    @Query(
        "UPDATE User u SET " +
        "u.email = :email, " +
        "u.firstName = :firstName, " +
        "u.lastName = :lastName, " +
        "u.telephone = :telephone " +
        "WHERE u.id = :id"
    )
    void updateUserDetails(
        @Param("id") Long id,
        @Param("email") String email,
        @Param("firstName") String firstName,
        @Param("lastName") String lastName,
        @Param("telephone") String telephone
    );
}