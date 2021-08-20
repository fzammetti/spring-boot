package com.etherient.json_handling;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * A controller to handle the getAccount POST request.
 *
 * @author <a href="mailto:fzammetti@etheriebt.com">Frank W. Zammetti</a>.
 */
@RestController
@RequestMapping("/api")
public class TestController {


  /**
   * Method to handle a POST request to /getAccount.
   *
   * @param inPerson A Person object constructed from JSON in the POST body in the form:
   *                   { id : 999 }
   * @return         A Person object, which will be serialized to JSON in the form:
   *                   { id : 999, firstName : "xxx", lastName : "xxx", age : 99 }
   */
  @PostMapping(
    value = "/getAccount",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Person getAccount(@RequestBody Person inPerson) {

    // Log the ID in the incoming Person object (that's the only field we care about).
    System.out.println("inPerson.id = " + inPerson.getId());

    // Construct a new Person object to send back.
    Person p = new Person();
    p.setId(inPerson.getId());
    p.setFirstName("Frank");
    p.setLastName("Zammetti");
    p.setAge(48);

    return p;

  } /* End getAccount(). */


} /* End class. */
