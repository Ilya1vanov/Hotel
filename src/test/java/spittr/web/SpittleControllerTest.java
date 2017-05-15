package spittr.web;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * @author Ilya Ivanov
 */
public class SpittleControllerTest {
//    @Test
//    public void shouldShowRecentSpittles() throws Exception {
//        List<Spittle> expectedSpittles = createSpittleList(20);
//        SpittleRepository mockRepository = mock(SpittleRepository.class);
//
//        when(mockRepository.findAll()).thenReturn(expectedSpittles);
//
//        SpittleController controller = new SpittleController(mockRepository);
//
//        MockMvc mockMvc = standaloneSetup(controller)
//                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
//                .build();
//
//        mockMvc.perform(get("/spittles"))
//                .andExpect(view().name("spittles"))
//                .andExpect(model().attributeExists("spittleList"))
//                .andExpect(model().attribute("spittleList",
//                        hasItems(expectedSpittles.toArray())));
//    }
//
//    private List<Spittle> createSpittleList(int count) {
//        List<Spittle> spittles = new ArrayList<>();
//        for (int i=0; i < count; i++) {
//            spittles.add(new Spittle("Spittle " + i, new Date()));
//        }
//        return spittles;
//    }

}