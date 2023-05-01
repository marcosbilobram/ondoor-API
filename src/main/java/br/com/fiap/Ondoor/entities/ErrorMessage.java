package br.com.fiap.Ondoor.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorMessage {

    private HttpStatus status;
    private String message;
}
