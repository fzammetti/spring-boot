package com.etherient.jpa_example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * A controller to handle the getAccount POST request.
 *
 * @author <a href="mailto:fzammetti@etherient.com">Frank W. Zammetti</a>.
 */
@Controller
public class IndexController {


  /**
   * Log instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);


  /**
   * A constructor to accept the injected repository instance and also to load up some test data.
   */
  public IndexController() {

    super();

    IndexController.LOG.info("***** IndexController()");

  } /* End constructor. */


  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() {

    IndexController.LOG.info("***** Redirecting to index.html");
    return "redirect:/index.html";

  } /* End index(). */


} /* End class. */
