package spittr;

import com.google.common.collect.Lists;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import spittr.data.model.Booking;
import spittr.data.model.Description;
import spittr.data.model.Room;
import spittr.data.model.User;
import spittr.data.repository.*;

import java.util.Date;

/**
 * @author Ilya Ivanov
 */
@SpringBootApplication
@EnableScheduling
public class Starter {
    private static final Logger log = Logger.getLogger(Starter.class);

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }

    @Bean
    public CommandLineRunner init(RoomRepository roomRepository, UserRepository userRepository, UserRoleRepository userRoleRepository, BookingRepository bookingRepository, DescriptionRepository descriptionRepository) {
        return args -> {
            User user = new User("ilya", "ilya", "Ilya", "Ivanov", "com.ilya.ivanov@gmail.com");
            user.setAuthorities(Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN")));
            Room room = new Room(true, 12L);
            Description descriptionEn = new Description("Sunset", "Some text", "en", room);
            Description descriptionRU = new Description("Закат", "Что-то там", "ru", room);
            room.setDescriptions(Lists.newArrayList(descriptionEn, descriptionRU));
            Date now = new Date();
            Booking booking = new Booking(now, now);
            user.addBooking(booking);
            room.addBooking(booking);
            log.debug(roomRepository.save(room));
            log.debug(userRepository.save(user));
            log.debug(userRoleRepository.save(user.getRoles()));
            log.debug(descriptionRepository.save(room.getDescriptions()));
            log.debug(bookingRepository.save(booking));
        };
    }
}
