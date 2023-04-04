package br.com.julio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person implements Serializable {

    private static final Long SerialVersionUID = 1L;

    private Long id;

    private String firstName;

    private String lastName;
    
    private String adress;
    
    private String gender;

}
