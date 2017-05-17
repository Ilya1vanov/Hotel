package spittr.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.data.model.User;
import spittr.data.model.UserDto;
import spittr.service.UserService;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author Ilya Ivanov
 */
public class UserControllerTest {
    private UserService userService = mock(UserService.class);

    private UserController controller = new UserController(userService);

    private User user = new User();

    private MockMvc mockMvc = standaloneSetup(controller)
            .setSingleView(new InternalResourceView("/WEB-INF/views/registration.jsp")).build();

    @Before
    public void setUp() throws Exception {
        when(userService.registerNewUserAccount(any())).thenReturn(user);
    }

    @Test
    public void register() throws Exception {
        mockMvc.perform(get("/registration"))
                .andExpect(view().name("registration"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("user", UserDto.PLACEHOLDER));
    }

    @Test
    public void registerUserAccount() throws Exception {
        mockMvc.perform(post("/registration")
                .param("firstName", "first")
                .param("lastName", "last")
                .param("email", "email@email.com")
                .param("username", "userName")
                .param("password", "password")
                .param("matchingPassword", "password"))
                .andExpect(view().name("registration"));
    }

}