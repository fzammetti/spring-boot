package com.etherient.jpa_example;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * A controller to handle the getAccount POST request.
 *
 * @author <a href="mailto:fzammetti@etheriebt.com">Frank W. Zammetti</a>.
 */
@Controller
@RequestMapping("/api")
public class APIController {


  /**
   * Log instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(APIController.class);


  /**
   * An injected instance of our JPA repository for storing Person entities.
   */
  private final PersonRepository repository;


  /**
   * An injected Jackson ObjectMapper for converting objects to JSON.
   */
  private final ObjectMapper objectMapper;


  /**
   * A constructor to accept the injected bean instances and also to load up some test data.
   */
  public APIController(final PersonRepository inRepository, final ObjectMapper inObjectMapper) {

    APIController.LOG.info("***** APIController()");

    // Cache injected beans.
    this.repository = inRepository;
    this.objectMapper = inObjectMapper;

    // Populate database if it's empty.
    if (inRepository.count() == 0) {
      APIController.LOG.info("***** Populating database...");
      inRepository.save(new Person("Daniel", "Jackson", 1965));
      inRepository.save(new Person("Jack", "O'Neill", 1952));
      inRepository.save(new Person("Samantha", "Carter", 1968));
      inRepository.save(new Person("Teal'c", "Shol'va", 1899));
      inRepository.save(new Person("Reggie", "Jackson", 1946));
      inRepository.save(new Person("Sam", "Jackson", 1948));
    }

    // Dump all Person entities to output so that we can see the ID's to use for queries later.
    APIController.LOG.info("***** Dumping database contents...");
    for (Person person : inRepository.findAll()) {
      APIController.LOG.info(person.toString());
    }

  } /* End constructor. */


  /**
   * Method to handle a POST request to /getByID.  Gets a single Person by ID.
   *
   * @param  inPerson A Person object constructed from JSON in the POST body in the form:
   *                    { id : 999 }
   * @param  inModel  The model the view template will use to get data from.
   * @return          The name of the template to render.
   */
  @PostMapping(
    value = "/getByID",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public String getById(@RequestBody Person inPerson, final Model inModel) {

    APIController.LOG.info("***** getById()");

    // Log the ID in the incoming Person object (that's the only field we care about).
    APIController.LOG.info("***** inPerson.id = " + inPerson.getId());

    // Find the Persona and add it to the model (or null if not found).
    final Optional<Person> person = this.repository.findById(inPerson.getId());
    APIController.LOG.info("***** Person = " + person);
    try {
      if (person.isPresent()) {
        String json = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        inModel.addAttribute("person", json);
      }
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return "show_person";

  } /* End getByID(). */


  /**
   * Method to handle a POST request to /getByLastName.  Gets a List of Person entities by last name.
   *
   * @param  inPerson A Person object constructed from JSON in the POST body in the form:
   *                    { lastName : "" }
   * @param  inModel The model the view template will use to get data from.
   * @return         The name of the template to render.
   */
  @PostMapping(
    value = "/getByLastName",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public String getByLastName(@RequestBody Person inPerson, final Model inModel) {

    APIController.LOG.info("***** getByLastName()");

    // Log the lastName in the incoming Person object (that's the only field we care about).
    APIController.LOG.info("***** inPerson.lastName = " + inPerson.getLastName());

    // Find the Persona and add it to the model (or null if not found).
    final List<Person> people = this.repository.findByLastName(inPerson.getLastName());
    APIController.LOG.info("***** people = " + people);
    try {
      String json = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(people);
      inModel.addAttribute("people", json);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
//    inModel.addAttribute("people", people);

    return "show_people";

  } /* End getByID(). */


} /* End class. */
