package com.etherient.basic_rest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * A simple unit test for the TestController.
 *
 * @author <a href="mailto:fzammetti@etherient.com">Frank W. Zammetti</a>.
 */
@SpringBootTest
@AutoConfigureMockMvc
class BasicRestApplicationTests {


  /**
   * Mock MVC support.
   */
  @Autowired
  private MockMvc mvc;


  /**
   * Confirm that the context loads properly.
   */
  @Test
  void contextLoads() {

    System.out.println("* Testing if context loads");

  } /* End contextLoads(). */


  @Test
  public void testHelloWorld() throws Exception {

    System.out.println("* Testing /helloWorld");
    mvc.perform(MockMvcRequestBuilders.get("/helloWorld").accept(MediaType.TEXT_PLAIN))
      .andExpect(status().isOk())
      .andExpect(content().string(equalTo("Hello, from the TestController!")));

  } /* End testHelloWorld(). */


} /* End class. */
