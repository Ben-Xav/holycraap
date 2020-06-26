package com.benmorant.game.holycraap.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.benmorant.game.holycraap.model.entity.People;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@SpringBootTest
@AutoConfigureMockMvc
class PeopleControllerTest {
  private static final String PEOPLE_API = "/api/people";

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  @Autowired private PeopleController controller;
  @Autowired private MockMvc mockMvc;

  private Collection<People> getAllPeople() throws Exception {
    final MockHttpServletRequestBuilder request = get(PEOPLE_API);
    final MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    return OBJECT_MAPPER.readValue(
        result.getResponse().getContentAsString(), new TypeReference<Collection<People>>() {});
  }

  private People createPeople(final People people) throws Exception {
    final String content = OBJECT_MAPPER.writeValueAsString(people);
    final MockHttpServletRequestBuilder request =
        post(PEOPLE_API).contentType(MediaType.APPLICATION_JSON).content(content);
    final MvcResult result = mockMvc.perform(request).andExpect(status().isCreated()).andReturn();
    return OBJECT_MAPPER.readValue(result.getResponse().getContentAsString(), People.class);
  }

  @Test
  public void contextLoads() {
    assertThat(controller).isNotNull();
  }

  @Test
  public void shouldReturnAllPeople() throws Exception {
    final String name = "somename";
    final int hp = 10;
    final int hpMax = 11;
    final int mp = 12;
    final int mpMax = 13;
    final Collection<People> firstList = getAllPeople();
    assertThat(firstList).isNotNull();

    final People input = new People();
    input.setCurrentHp(hp);
    input.setCurrentMp(mp);
    input.setHpMax(hpMax);
    input.setMpMax(mpMax);
    input.setName(name);

    final People result = createPeople(input);
    assertThat(result).isNotNull();
    assertThat(result.getCurrentHp()).isEqualTo(hp);
    assertThat(result.getCurrentMp()).isEqualTo(mp);
    assertThat(result.getHpMax()).isEqualTo(hpMax);
    assertThat(result.getMpMax()).isEqualTo(mpMax);
    assertThat(result.getName()).isEqualTo(name);

    final Collection<People> resultList = getAllPeople();
    assertThat(firstList).doesNotContain(result);
    assertThat(resultList).contains(result);
  }
}
