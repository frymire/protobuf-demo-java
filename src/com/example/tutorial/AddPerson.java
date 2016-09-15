package com.example.tutorial;

import java.io.FileOutputStream;

import com.example.tutorial.AddressBookProtos.AddressBook;
import com.example.tutorial.AddressBookProtos.Person;


class AddPerson {

  // Create an address book in file "MyAddressBook" with two entries.
  public static void main(String[] args) throws Exception {

    Person mark = Person.newBuilder()
        .setId(1)
        .setName("Mark")
        .setEmail("mark@server.com")
        .addPhones( Person.PhoneNumber.newBuilder().setNumber("111-222-3333").setType(Person.PhoneType.MOBILE) )
        .addPhones( Person.PhoneNumber.newBuilder().setNumber("444-555-6666").setType(Person.PhoneType.HOME) )
        .addPhones( Person.PhoneNumber.newBuilder().setNumber("777-888-9999").setType(Person.PhoneType.WORK) )
        .build();  

    Person kurt = Person.newBuilder()
        .setId(2)
        .setName("Kurt")
        .setEmail("kurt@server.com")
        .build();

    AddressBook.Builder addressBook = AddressBook.newBuilder()
        .addPeople(mark)
        .addPeople(kurt);

    try (FileOutputStream output = new FileOutputStream("MyAddressBook")) {
      addressBook.build().writeTo(output);
    }
    
    System.out.println("Done. Run ListPeople.java to see the result.");
    
  }
  
}
