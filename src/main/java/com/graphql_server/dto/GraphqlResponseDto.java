package com.graphql_server.dto;

import com.graphql_server.model.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GraphqlResponseDto {
    private int count;
    private String next;
    private String previous;
    private Person results[];

    @Override
    public String toString() {
        return "GraphqlResponseDto{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + Arrays.toString(results) +
                '}';
    }
}
