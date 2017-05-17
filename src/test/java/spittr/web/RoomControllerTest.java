package spittr.web;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.data.model.Room;
import spittr.data.model.User;
import spittr.data.model.UserDto;
import spittr.data.repository.RoomRepository;

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
public class RoomControllerTest {
    private RoomRepository roomRepository = mock(RoomRepository.class);

    private RoomController controller = new RoomController(roomRepository);

    private Room room = new Room();

    private List<Room> rooms = Lists.newArrayList(room);

    private MockMvc mockMvc = standaloneSetup(controller)
            .setSingleView(new InternalResourceView("/WEB-INF/views/rooms.jsp")).build();

    @Before
    public void setUp() throws Exception {
        when(roomRepository.findAll()).thenReturn(rooms);
    }

    @Test
    public void room() throws Exception {
        mockMvc.perform(get("/rooms"))
                .andExpect(view().name("rooms"))
                .andExpect(model().attributeExists("rooms"))
                .andExpect(model().attribute("rooms", rooms));
    }
}