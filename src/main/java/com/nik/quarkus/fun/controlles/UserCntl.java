package com.nik.quarkus.fun.controlles;


import com.nik.quarkus.fun.models.user;
import com.nik.quarkus.fun.service.UserService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Path("/user")
@RequiredArgsConstructor
@Slf4j
public class UserCntl {

  private final UserService userService;


  @GET
  @Path("/get")
  public String test() {
    return "User";
  }


  @POST
  @Path("/post")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public user SaveUser(user user) {
    log.info("saving user process started the is User: {}", user);
    userService.saveUser(user);
    return user;
  }

  @GET
  @Path("/get/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public user getUserById(@PathParam("id") String id) {
    log.info("fetching user process started the is User: {}", id);
    return userService.getUserById(id);
  }

  @DELETE
  @Path("/delete/{id}")
  public String deleteUser(@PathParam("id") String id) {
    log.info("deleting user process started the is User: {}", id);
    userService.deleteUser(id);
    return "User deleted successfully";
  }

  @GET
  @Path("/getAll")
  @Produces(MediaType.APPLICATION_JSON)
  public List<user> getAllUsers() {
    log.info("fetching all users process started");
    return userService.getAllUsers();
  }

  @PUT
  @Path("/update/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public user updateUser(@PathParam("id") String id, user user) {
    log.info("updating user process started the is User: {}", user);
    return userService.updateUser(id, user);
  }
}
