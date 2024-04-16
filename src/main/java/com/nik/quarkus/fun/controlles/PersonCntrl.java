package com.nik.quarkus.fun.controlles;

import com.nik.quarkus.fun.models.Person;
import com.nik.quarkus.fun.service.PersonService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.util.List;
import lombok.Builder.Default;
import lombok.RequiredArgsConstructor;

@Path("/person")
@RequiredArgsConstructor
public class PersonCntrl {

  private final PersonService personService;

  @GET
  @Path("/get")
  public String test() {
    return "Person";
  }

  @POST
  @Path("/post")
  public String post(Person person) {
    personService.savePerson(person);
    return "person saved successfully";
  }

  @GET
  @Path("/get/{id}")
  public Person getPerson(@PathParam("id") String id) {
    return personService.getPerson(id);
  }
  @GET
  @Path("/getall")
  public List<Person> getAllPersons() {
    return personService.getAllPersons();
  }

  @PUT
  @Path("/update/{id}")
  public String updatePerson(@PathParam("id") String id, Person person) {
    personService.updatePerson(id, person);
    return "Person updated successfully";
  }
  @DELETE
  @Path("/delete/{id}")
  public String deletePerson(@PathParam("id") String id) {
    personService.deletePerson(id);
    return "Person deleted successfully";
  }
}
