package spittr.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spittr.data.model.Room;

/**
 * @author Ilya Ivanov
 */
public interface RoomRepository extends JpaRepository<Room, Long> {
}
