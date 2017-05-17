package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author Ilya Ivanov
 */
public class IndexControllerTest {
    private IndexController controller = new IndexController();

    MockMvc mockMvc = standaloneSetup(controller)
            .setSingleView(new InternalResourceView("/WEB-INF/views/index.jsp"))
            .build();

    @Test
    public void redirectIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(view().name("redirect:/index"));
    }

    @Test
    public void index() throws Exception {
        mockMvc.perform(get("/index"))
                .andExpect(view().name("index"));
    }

}