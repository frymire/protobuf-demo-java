package com.example.tutorial;

import java.io.FileInputStream;
import java.util.List;

class ListPeople {

  public static void main(String[] args) throws Exception {
    List<Person> people = AddressBook.parseFrom(new FileInputStream("MyAddressBook")).getPeopleList();
    for (Person person: people) System.out.println(new PersonPlus(person));     
  }
}
