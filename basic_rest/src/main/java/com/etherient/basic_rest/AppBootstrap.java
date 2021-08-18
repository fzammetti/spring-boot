package com.etherient.basic_rest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * App bootstrap class.
 *
 * @author <a href="mailto:fzammetti@etheriebt.com">Frank W. Zammetti</a>.
 */
@SpringBootApplication
public class AppBootstrap {


  /**
   * Main entry point.
   *
   * @param inArgs Command line arguments.
   */
  public static void main(final String[] inArgs) {

    SpringApplication.run(AppBootstrap.class, inArgs);

  } /* End main(). */


} /* End class. */
