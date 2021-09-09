package com.ivoronline.springboot_db_query_native_create_projections_dto.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

  //PROPERTIES
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  public String  name;
  public Integer age;

}
