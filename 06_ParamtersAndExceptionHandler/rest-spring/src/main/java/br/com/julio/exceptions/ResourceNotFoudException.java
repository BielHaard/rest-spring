package br.com.julio.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoudException extends RuntimeException{

    private static final Long serialVersionUID = 1L;

    public ResourceNotFoudException(String ex){
        super(ex);
    }

}
