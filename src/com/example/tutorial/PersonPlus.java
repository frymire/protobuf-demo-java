// UNCLASSIFIED

package com.example.tutorial;

import com.example.tutorial.AddressBookProtos.Person;

/**
 * Since you're not supposed to edit person directly, we have to make another Person-like
 * class that contains a Person instance and gives it functionality.
 *
 */
public class PersonPlus {
  
  Person person;
  
  PersonPlus(Person person) { this.person = person; }
  
  @Override public String toString() {
    
    StringBuilder sb = new StringBuilder();
    
    sb.append("Person ID: " + person.getId() + "\n");
    sb.append("  Name: " + person.getName() + "\n");
    if (!person.getEmail().isEmpty()) sb.append("  E-mail address: " + person.getEmail() + "\n");

    for (Person.PhoneNumber phoneNumber : person.getPhonesList()) {
      switch (phoneNumber.getType()) {
      case MOBILE:
        sb.append("  Mobile phone #: ");
        break;
      case HOME:
        sb.append("  Home phone #: ");
        break;
      case WORK:
        sb.append("  Work phone #: ");
        break;
      case UNRECOGNIZED:
        break;
      }
      
      sb.append(phoneNumber.getNumber() + "\n");
    }

    
    return sb.toString();
  }

}
