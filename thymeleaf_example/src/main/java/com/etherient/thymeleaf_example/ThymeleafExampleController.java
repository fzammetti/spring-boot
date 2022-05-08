package com.etherient.thymeleaf_example;


import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * A simple MVC controller.
 *
 * @author <a href="mailto:fzammetti@etherient.com">Frank W. Zammetti</a>.
 */
@Controller
public class ThymeleafExampleController {


  /**
   * Values comes from application.properties.
   */
  @Value("${message}")
  private String message;
  @Value("${maven.app}")
  private String mavenApp;


  /**
   * The list of Babylon 5 characters to show.
   */
  private final List<String> characters =
    Arrays.asList( "John", "Delenn", "Michael", "Zack", "Stephen", "Lita", "Susan" );


  /**
   * Handler for the "index", or home, page.
   *
   * @param  inModel The model the view template will use to get data from.
   * @return         The name of the template to render.
   */
  @GetMapping("/")
  public String index(final Model inModel) {

    System.out.println("mavenApp = " + this.mavenApp);

    // Add the message and character list to the model that the view template will use.
    inModel.addAttribute("message", this.message);
    inModel.addAttribute("characters", this.characters);

    // Return the name of the template to render.
    return "babylon5_characters";

  } /* End index(). */


} /* End class. */
