package com.benmorant.game.holycraap.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

  @Autowired private HelloController controller;

  @Autowired private MockMvc mockMvc;

  @Test
  public void contextLoads() {
    assertThat(controller).isNotNull();
  }

  @Test
  public void shouldReturnYo() throws Exception {
    mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string("Yo !"));
  }
}
