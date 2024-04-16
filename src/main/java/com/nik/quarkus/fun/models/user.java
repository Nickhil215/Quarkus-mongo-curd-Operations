package com.nik.quarkus.fun.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {
  @Id
  private ObjectId id;
  private String name;
  private String email;
  private String password;
  private String phone;
  private String dob;

  private Address address;
}
