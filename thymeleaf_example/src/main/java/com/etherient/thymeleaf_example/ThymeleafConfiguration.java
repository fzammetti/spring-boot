package com.etherient.thymeleaf_example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;



/**
 * A configuration bean to make Spring Boot load Thymeleaf templates off the file system rather than the classpath so
 * that any changes to the template happens immediately (just need to refresh the browser you're viewing it in).
 *
 * @author <a href="mailto:fzammetti@etheriebt.com">Frank W. Zammetti</a>.
 */
@Configuration
public class ThymeleafConfiguration {


  /**
   * Return the resolved Spring Boot will use to locate templates.
   *
   * @return The resolver implementation to use, fully configured for finding our templates.
   */
  @Bean
  public ITemplateResolver defaultTemplateResolver() {

    System.out.println("* Configuring template resolver");

    FileTemplateResolver resolver = new FileTemplateResolver();
    resolver.setSuffix(".html");
    resolver.setPrefix("src/main/resources/templates/");
    resolver.setTemplateMode("HTML5");
    resolver.setCharacterEncoding("UTF-8");
    resolver.setCacheable(false);

    return resolver;

  } /* End ITemplateResolver(). */


} /* End class. */
