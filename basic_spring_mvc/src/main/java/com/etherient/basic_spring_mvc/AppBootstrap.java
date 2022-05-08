package com.etherient.basic_spring_mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;


/**
 * App bootstrap class.
 *
 * @author <a href="mailto:fzammetti@etherient.com">Frank W. Zammetti</a>.
 */
@SpringBootApplication
public class AppBootstrap {


   @SuppressWarnings({"SpringJavaStaticMembersAutowiringInspection", "SpringJavaAutowiredFieldsWarningInspection"})
   @Autowired
   private static BuildProperties buildProperties;


  /**
   * Main entry point.
   *
   * @param inArgs Command line arguments.
   */
  public static void main(final String[] inArgs) {

    //noinspection resource
    SpringApplication.run(AppBootstrap.class, inArgs);

    System.out.println("GIT artifact = " + AppBootstrap.buildProperties.getArtifact());
    System.out.println("GIT version  = " + AppBootstrap.buildProperties.getVersion());

  } /* End main(). */


} /* End class. */
