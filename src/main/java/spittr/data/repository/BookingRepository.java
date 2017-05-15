package spittr.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spittr.data.model.Booking;

/**
 * @author Ilya Ivanov
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
