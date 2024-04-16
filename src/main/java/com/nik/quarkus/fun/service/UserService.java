package com.nik.quarkus.fun.service;

import com.nik.quarkus.fun.models.user;
import com.nik.quarkus.fun.repository.UserRepo;
import io.quarkus.redis.client.RedisClient;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class UserService {

  private final UserRepo userRepo;
  private final RedisClient redisClient;

  public void saveUser(user user) {
    userRepo.persist(user);
//    redisClient.set(List.of(user.getId().toString(),user.toString()));
    log.info("User saved successfully");
  }

  //  @CacheResult(cacheName = "user")
  public user getUserById(String id) {

//   Object user= redisClient.get(id);
//   log.info("User fetched from cache  USER :: {}",user);
//   if(user!=null) {
//     log.info("User fetched from cache");
//     return user;
//   }
    log.info("User fetched from db");
    ObjectId objectId = new ObjectId(id);
    return userRepo.findById(objectId);
  }

  public List<user> getAllUsers() {
    return userRepo.listAll();
  }

  public void deleteUser(String id) {
    ObjectId objectId = new ObjectId(id);
    userRepo.deleteById(objectId);
  }

  public user updateUser(String id, user user) {
    user user1 = getUserById(id);
    user1.setName(user.getName());
    user1.setAddress(user.getAddress());
    user1.setDob(user.getDob());
    user1.setEmail(user.getEmail());
    user1.setPhone(user.getPhone());
    user1.setPassword(user.getPassword());
    userRepo.update(user1);

    return user1;


  }


}
