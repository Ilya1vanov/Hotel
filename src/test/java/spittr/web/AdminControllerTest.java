package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author Ilya Ivanov
 */
public class AdminControllerTest {
    @Test
    public void adminMethodSecured() throws Exception {
        AdminController controller = new AdminController();

        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/admin.jsp"))
                .build();

        mockMvc.perform(get("/admin"))
                .andExpect(view().name("admin"));
    }

}