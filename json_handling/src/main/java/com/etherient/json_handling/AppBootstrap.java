package com.etherient.json_handling;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * App bootstrap class.
 *
 * @author <a href="mailto:fzammetti@etherient.com">Frank W. Zammetti</a>.
 */
@SpringBootApplication
public class AppBootstrap {


  /**
   * Main entry point.
   *
   * @param inArgs Command line arguments.
   */
  public static void main(final String[] inArgs) {

    //noinspection resource
    SpringApplication.run(AppBootstrap.class, inArgs);

  } /* End main(). */


} /* End class. */
