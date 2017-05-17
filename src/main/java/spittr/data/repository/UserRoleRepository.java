package spittr.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spittr.data.model.UserRole;

/**
 * @author Ilya Ivanov
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
