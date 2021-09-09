package com.ivoronline.springboot_db_query_native_create_projections_dto.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivoronline.springboot_db_query_native_create_projections_dto.dto.PersonDTO;
import com.ivoronline.springboot_db_query_native_create_projections_dto.entities.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@RestController
public class MyController {

  @PersistenceContext EntityManager entityManager;

  //================================================================
  // RETURN PERSON DTO
  //================================================================
  @RequestMapping("ReturnPersonDTO")
  PersonDTO returnPersonDTO() throws JsonProcessingException {

    //CREATE QUERY
    String select = "SELECT name, age FROM Person WHERE name = :name";
    Query  query  = entityManager.createNativeQuery(select);
           query.setParameter("name", "John");

    //RETURN PERSON
    Object[] columns = (Object[]) query.getSingleResult();                //["John",20]

    //DISPLAY COLUMNS
    String columnsJSON = new ObjectMapper().writeValueAsString(columns);  //["John",20]
    System.out.println(columnsJSON);

    //MAP COLUMNS INTO DTO
    PersonDTO personDTO      = new PersonDTO();
              personDTO.name = (String ) columns[0];
              personDTO.age  = (Integer) columns[1];

    //RETURN DTO
    return personDTO;

  }

}


