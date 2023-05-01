package com.graphql_server.controller;

import com.graphql_server.dto.GraphqlResponseDto;
import com.graphql_server.model.Person;
import com.graphql_server.service.PersonService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @QueryMapping
    public GraphqlResponseDto fetchAllPersons()  {
        return personService.fetchPersonsData();
    }

    @QueryMapping
    public Person fetchPersonByName(@Argument String name) {
        return personService.findPersonByName(name);
    }
}

