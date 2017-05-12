package spittr.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spittr.data.model.Spittle;

/**
 * @author Ilya Ivanov
 */
@Repository
public interface SpittleRepository extends JpaRepository<Spittle, Long> {
}
