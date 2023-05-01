package br.com.fiap.Ondoor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends NoSuchElementException {

    public ObjectNotFoundException() {
        super();
    }

    public ObjectNotFoundException(String s, Throwable cause) {
        super(s, cause);
    }

    public ObjectNotFoundException(Throwable cause) {
        super(cause);
    }

    public ObjectNotFoundException(String s) {
        super(s);
    }
}
