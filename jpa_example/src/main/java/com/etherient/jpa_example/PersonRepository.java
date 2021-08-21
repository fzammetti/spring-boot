package com.etherient.jpa_example;


import java.util.List;
import org.springframework.data.repository.CrudRepository;


/**
 * A JPA repository for performing CRUD operations on Person entities.
 *
 * @author <a href="mailto:fzammetti@etheriebt.com">Frank W. Zammetti</a>.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {


  /**
   * Find all Person's with a specified last name.
   *
   * @param  inLastName The last name to find.
   * @return            A List of Person entities, or null if none found.
   */
  List<Person> findByLastName(final String inLastName);


  /**
   * Find a specific person by ID.
   *
   * @param  inID The ID to look for.
   * @return      A Person entity, or null if not found.
   */
  Person findById(final long inID);


} /* End class. */
