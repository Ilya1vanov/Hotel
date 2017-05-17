package spittr.web;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.data.model.Booking;
import spittr.data.model.Room;
import spittr.data.model.User;
import spittr.data.repository.BookingRepository;
import spittr.data.repository.RoomRepository;
import spittr.data.repository.UserRepository;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author Ilya Ivanov
 */
public class BookingControllerTest {
    private final RoomRepository roomRepository = mock(RoomRepository.class);

    private final UserRepository userRepository = mock(UserRepository.class);

    private final BookingRepository bookingRepository = mock(BookingRepository.class);

    private final BookingController controller = new BookingController(roomRepository, userRepository, bookingRepository);

    private final Room room = new Room();

    private final Long id = 1L;

    private final Booking booking = new Booking();

    private final User user = new User("username", "password", "first name", "last name", "email@email.email");

    private MockMvc mockMvc = standaloneSetup(controller)
            .setSingleView(new InternalResourceView("/WEB-INF/views/booking.jsp")).build();

    @Before
    public void setUp() throws Exception {
        when(roomRepository.findOne(id)).thenReturn(room);
        when(userRepository.findByUsername(user.getUsername())).thenReturn(user);
    }

    @Test
    public void booking() throws Exception {
        mockMvc.perform(get("/booking/" + id))
                .andExpect(view().name("booking"))
                .andExpect(model().attributeExists("room"))
                .andExpect(model().attribute("room", room))
                .andExpect(model().attributeExists("booking"))
                .andExpect(model().attribute("booking", booking));
    }

    @Test
    public void registerNewBooking() throws Exception {
    }

}