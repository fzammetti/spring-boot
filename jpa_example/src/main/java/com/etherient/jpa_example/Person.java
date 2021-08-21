package com.etherient.jpa_example;


import java.lang.reflect.Field;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * A class representing a person.  Used as a JPA entity.
 *
 * @author <a href="mailto:fzammetti@etheriebt.com">Frank W. Zammetti</a>.
 */
@Entity
public class Person {


  /**
   * A unique ID to identify the person with.
   */
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;


  /**
   * The person's first name.
   */
  private String firstName;


  /**
   * The person's last name.
   */
  private String lastName;


  /**
   * The person's birth year.
   */
  private int birthYear;


  /**
   * Default constructor.
   */
  protected Person() { }


  /**
   * Constructor.
   */
  public Person(final String inFirstName, final String inLastName, final int inBirthYear) {

    this.setFirstName(inFirstName);
    this.setLastName(inLastName);
    this.setBirthYear(inBirthYear);

  } /* End constructor. */


  /**
   * Accessor for the id field.
   *
   * @return The current value of the field.
   */
  public Long getId() {

    return this.id;

  } /* End getId(). */


  /**
   * Mutator for the id field.
   *
   * @param inNewValue The new value for the field.
   */
  public void setId(final Long inNewValue) {

    this.id = inNewValue;

  } /* End setId(). */


  /**
   * Accessor for the firstName field.
   *
   * @return The current value of the field.
   */
  public String getFirstName() {

    return this.firstName;

  } /* End getFirstName(). */


  /**
   * Mutator for the firstName field.
   *
   * @param inNewValue The new value for the field.
   */
  public void setFirstName(final String inNewValue) {

    this.firstName = inNewValue;

  } /* End setFirstName(). */


  /**
   * Accessor for the lastName field.
   *
   * @return The current value of the field.
   */
  public String getLastName() {

    return this.lastName;

  } /* End getLastName(). */


  /**
   * Mutator for the lastName field.
   *
   * @param inNewValue The new value for the field.
   */
  public void setLastName(final String inNewValue) {

    this.lastName = inNewValue;

  } /* End setLastName(). */


  /**
   * Accessor for the birthYear field.
   *
   * @return The current value of the field.
   */
  public int getBirthYear() {

    return this.birthYear;

  } /* End getBirthYear(). */


    /**
   * Mutator for the birthYear field.
   *
   * @param inNewValue The new value for the field.
   */
  public void setBirthYear(final int inNewValue) {

    this.birthYear = inNewValue;

  } /* End setBirthYear(). */


  /**
   * Overridden toString method.
   *
   * @return A reflexively-built string representation of this bean.
   */
  public String toString() {

    String str = null;
    StringBuilder sb = new StringBuilder(1000);
    sb.append("[").append(super.toString()).append("]={");
    boolean firstPropertyDisplayed = false;
    try {
      java.lang.reflect.Field[] fields = this.getClass().getDeclaredFields();
      for (Field field : fields) {
        if (firstPropertyDisplayed) {
          sb.append(", ");
        } else {
          firstPropertyDisplayed = true;
        }
        sb.append(field.getName()).append("=").append(field.get(this));
      }
      sb.append("}");
      str = sb.toString().trim();
    } catch (IllegalAccessException iae) {
      iae.printStackTrace();
    }
    return str;

  } // End toString().


} /* End class. */
