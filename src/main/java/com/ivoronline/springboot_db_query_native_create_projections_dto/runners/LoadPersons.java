package com.ivoronline.springboot_db_query_native_create_projections_dto.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class LoadPersons implements CommandLineRunner {

  @PersistenceContext EntityManager entityManager;

  @Override
  @Transactional
  public void run(String... args) throws Exception {

    //INSERT PERSON
    String insert = "INSERT INTO PERSON (name, age) VALUES (:name, :age)";
    Query  query  = entityManager.createNativeQuery(insert);
           query.setParameter("name", "John");
           query.setParameter("age" , 20);
           query.executeUpdate();

  }

}

