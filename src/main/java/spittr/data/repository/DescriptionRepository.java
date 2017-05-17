package spittr.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spittr.data.model.Description;

/**
 * @author Ilya Ivanov
 */
public interface DescriptionRepository extends JpaRepository<Description, Long> {
}
