package com.graphql_server.service;

import com.graphql_server.dto.GraphqlResponseDto;
import com.graphql_server.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {
    @Value("${baseDataUrl}")
    private  String url;
    private final WebClient webClient;

    public PersonService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl(url)
                .build();
    }
    public GraphqlResponseDto fetchPersonsData() {
        return  webClient.get()
                .uri(url + "api/people/")
                .retrieve()
                .bodyToMono(GraphqlResponseDto.class)
                .block();
    }
    public Person findPersonByName(String name) {
        return  Arrays.stream(fetchPersonsData().getResults())
                .filter(person -> person.getName()
                .equals(name))
                .collect(Collectors.toList())
                .get(0);
    }

}



