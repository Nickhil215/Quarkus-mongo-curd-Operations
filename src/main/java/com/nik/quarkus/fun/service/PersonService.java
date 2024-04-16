package com.nik.quarkus.fun.service;

import com.nik.quarkus.fun.models.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import java.util.List;
import org.bson.types.ObjectId;

@ApplicationScoped
public class PersonService {


  public String savePerson(Person person) {
    person.persist();
    return "Person saved successfully";
  }

  public Person getPerson(String id) {
    Person person= Person.findById(new ObjectId(id));
    if (person == null) {
     throw new WebApplicationException("Person with id of " + id + " does not exist.", 404);
    }
    return person;
  }

  public String deletePerson(String id) {
    Person.deleteById(new ObjectId(id));
    return "Person deleted successfully";
  }

  public String updatePerson(String id, Person person) {
    Person person1 = getPerson(id);
    person1.setName(person.getName());
    person1.setDob(person.getDob());
    person1.setEmail(person.getEmail());
    person1.setPhone(person.getPhone());
    person1.setPassword(person.getPassword());
    person1.persistOrUpdate();
    return "Person updated successfully";
  }
public List<Person> getAllPersons() {
    return Person.listAll();
  }
}
