package com.nik.quarkus.fun.repository;
import com.nik.quarkus.fun.models.user;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepo implements PanacheMongoRepository<user> {

}
