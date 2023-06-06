package com.example.tutorial;

import com.google.protobuf.Struct;
import com.google.protobuf.util.JsonFormat;

import java.io.FileOutputStream;

class AddPerson {

  // Create an address book in file "MyAddressBook" with two entries.
  public static void main(String[] args) throws Exception {

    // Instantiate a Person using the Person.Builder
    Person mark = Person.newBuilder()
        .setId(1)
        .setName("Mark")
        .setEmail("mark@server.com")
        .addPhones( Person.PhoneNumber.newBuilder().setNumber("111-222-3333").setType(Person.PhoneType.MOBILE) )
        .addPhones( Person.PhoneNumber.newBuilder().setNumber("444-555-6666").setType(Person.PhoneType.HOME) )
        .addPhones( Person.PhoneNumber.newBuilder().setNumber("777-888-9999").setType(Person.PhoneType.WORK) )
        .build();  

    // Instantiate a Person by parsing from JSON
    String json = """
            { "id": 2, "name": "Kurt", "email": "kurt@server.com" }""";
    Person.Builder kurt = Person.newBuilder();
    JsonFormat.parser().merge(json, kurt);

    AddressBook.Builder addressBook = AddressBook.newBuilder()
        .addPeople(mark)
        .addPeople(kurt);

    try (FileOutputStream output = new FileOutputStream("MyAddressBook")) {
      addressBook.build().writeTo(output);
    }
    
    System.out.println("Done. Run ListPeople.java to see the result.");
  }
}
