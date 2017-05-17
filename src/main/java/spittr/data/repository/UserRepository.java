package spittr.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spittr.data.model.User;

/**
 * @author Ilya Ivanov
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
