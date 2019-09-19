package edu.udacity.java.nano;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class WebSocketChatApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    static final String WEBSOCKET_URI = "ws://localhost:8080/chat";

    @Test
    public void login() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("/login"));
    }

    @Test
    public void join() throws Exception {
        this.mockMvc.perform(get("/index").param("username", "Lisa")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("/chat")).andExpect(model().	attribute("username","Lisa"));
    }

}