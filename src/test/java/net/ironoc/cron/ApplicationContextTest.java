package net.ironoc.cron;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationContextTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        // This test ensures the Spring application context loads without errors
    }

    @Test
    void homePageLoadsAndResolvesJspView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk()) // HTTP 200
                .andExpect(view().name("home")) // Logical view name
                .andExpect(forwardedUrl("/WEB-INF/views/home.jsp")); // JSP path
    }
}
