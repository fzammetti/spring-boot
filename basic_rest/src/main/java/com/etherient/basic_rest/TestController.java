package com.etherient.basic_rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * A simple controller for RESTful requests.
 *
 * @author <a href="mailto:fzammetti@etheriebt.com">Frank W. Zammetti</a>.
 */
@RestController
public class TestController {


  // Injected value from application.properties file.
  @Value("${myProp}")
  private String myProp;


  /**
   * Handler for the /helloWorld endpoint.
   *
   * @return A simple greeting.
   */
  @RequestMapping("/helloWorld")
  public String helloWorld() {

    System.out.println("myProp = " + this.myProp);

    return "Hello, from the TestController!";

  } /* End helloWorld().  */


} /* End class. */
