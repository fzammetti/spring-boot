package com.etherient.json_handling;


import java.lang.reflect.Field;


/**
 * A class representing a person.
 *
 * @author <a href="mailto:fzammetti@etheriebt.com">Frank W. Zammetti</a>.
 */
public class Person {


  // A unique ID to identify the person with.
  private int id;


  // The person's first name.
  private String firstName;


  // The person's last name.
  private String lastName;


  // The person's age.
  private int age;


  /**
   * Constructor.
   */
  public Person() { }


  /**
   * Accessor for the id field.
   *
   * @return The current value of the field.
   */
  public int getId() {

    return this.id;

  } /* End getId(). */


  /**
   * Mutator for the id field.
   *
   * @param inNewValue The new value for the field.
   */
  public void setId(final int inNewValue) {

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
   * Accessor for the age field.
   *
   * @return The current value of the field.
   */
  public int getAge() {

    return this.age;

  } /* End getAge(). */


    /**
   * Mutator for the age field.
   *
   * @param inNewValue The new value for the field.
   */
  public void setAge(final int inNewValue) {

    this.age = inNewValue;

  } /* End setAge(). */


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
