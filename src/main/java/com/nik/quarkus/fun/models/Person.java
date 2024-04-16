package com.nik.quarkus.fun.models;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@MongoEntity(collection = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends PanacheMongoEntity {

  private String name;
  private String email;
  private String password;
  private String phone;
  private String dob;

}
