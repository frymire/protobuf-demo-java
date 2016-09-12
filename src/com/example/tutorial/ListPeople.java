package com.example.tutorial;

import com.example.tutorial.AddressBookProtos.AddressBook;
import com.example.tutorial.AddressBookProtos.Person;

import java.io.FileInputStream;
import java.util.List;

class ListPeople {

  public static void main(String[] args) throws Exception {

    List<Person> people = AddressBook.parseFrom(new FileInputStream("MyAddressBook")).getPeopleList();
    
    for (Person person: people) {

      System.out.println("Person ID: " + person.getId());
      System.out.println("  Name: " + person.getName());
      if (!person.getEmail().isEmpty()) System.out.println("  E-mail address: " + person.getEmail());

      for (Person.PhoneNumber phoneNumber : person.getPhonesList()) {
        switch (phoneNumber.getType()) {
        case MOBILE:
          System.out.print("  Mobile phone #: ");
          break;
        case HOME:
          System.out.print("  Home phone #: ");
          break;
        case WORK:
          System.out.print("  Work phone #: ");
          break;
        case UNRECOGNIZED:
          break;
        }
        
        System.out.println(phoneNumber.getNumber());
      }

    }    
  }
}
