package com.benmorant.game.holycraap.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.benmorant.game.holycraap.model.entity.Item;
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
class ItemControllerTest {
  private static final String ITEMS_API = "/api/items";

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  @Autowired private ItemController controller;
  @Autowired private MockMvc mockMvc;

  private Collection<Item> getAllItems() throws Exception {
    final MockHttpServletRequestBuilder request = get(ITEMS_API);
    final MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
    return OBJECT_MAPPER.readValue(
        result.getResponse().getContentAsString(), new TypeReference<Collection<Item>>() {});
  }

  private Item createItem(final Item item) throws Exception {
    final String content = OBJECT_MAPPER.writeValueAsString(item);
    final MockHttpServletRequestBuilder request =
        post(ITEMS_API).contentType(MediaType.APPLICATION_JSON).content(content);
    final MvcResult result = mockMvc.perform(request).andExpect(status().isCreated()).andReturn();
    return OBJECT_MAPPER.readValue(result.getResponse().getContentAsString(), Item.class);
  }

  @Test
  public void contextLoads() {
    assertThat(controller).isNotNull();
  }

  @Test
  public void shouldReturnAllItems() throws Exception {
    final String name = "SomeItemController";
    final int slot = 2;
    final double price = 1.45;

    final Collection<Item> firstList = getAllItems();
    assertThat(firstList).isNotNull();

    final Item input = new Item();
    input.setPrice(price);
    input.setSlot(slot);
    input.setName(name);

    final Item result = createItem(input);
    assertThat(result).isNotNull();
    assertThat(result.getPrice()).isEqualTo(price);
    assertThat(result.getSlot()).isEqualTo(slot);
    assertThat(result.getName()).isEqualTo(name);

    final Collection<Item> resultList = getAllItems();
    assertThat(firstList).doesNotContain(result);
    assertThat(resultList).contains(result);
  }
}
