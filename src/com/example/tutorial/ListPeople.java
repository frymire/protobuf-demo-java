package com.example.tutorial;

import com.google.protobuf.util.JsonFormat;

import java.io.FileInputStream;
import java.util.List;

class ListPeople {

  public static void main(String[] args) throws Exception {

    // Parse from file
    List<Person> people = AddressBook.parseFrom(new FileInputStream("MyAddressBook")).getPeopleList();

    // Print each Person using PersonPlus.toString()
    for (Person person: people) System.out.println(new PersonPlus(person));

    // Print each Person as JSON.
    for (Person person: people) System.out.println(JsonFormat.printer().print(person));
  }
}
