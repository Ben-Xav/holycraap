package com.benmorant.game.holycraap.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.benmorant.game.holycraap.controller.PeopleController;
import com.benmorant.game.holycraap.model.entity.People;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class PeopleControllerTest {

  private static final ObjectMapper objectMapper = new ObjectMapper();
  @Autowired private PeopleController controller;
  @Autowired private MockMvc mockMvc;

  @Test
  public void contextLoads() {
    assertThat(controller).isNotNull();
  }

  @Test
  public void shouldReturnAllPeople() throws Exception {
    final MvcResult result =
        mockMvc.perform(get("/people/all")).andExpect(status().isOk()).andReturn();
    final Collection<People> peopleList =
        objectMapper.readValue(
            result.getResponse().getContentAsString(), new TypeReference<Collection<People>>() {});
    assertThat(peopleList).isNotEmpty();
  }
}
