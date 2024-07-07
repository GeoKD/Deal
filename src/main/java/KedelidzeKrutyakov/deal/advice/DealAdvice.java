package KedelidzeKrutyakov.deal.advice;

import KedelidzeKrutyakov.deal.api.DTO.ExceptionResponse;
import KedelidzeKrutyakov.deal.exception.UniquenessCheckException;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DealAdvice {

    @ExceptionHandler ( UniquenessCheckException.class )
    public ResponseEntity<ExceptionResponse> handleUniquenessCheckException
            ( UniquenessCheckException e ) {
        ExceptionResponse response = new ExceptionResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler ( EntityNotFoundException.class )
    public ResponseEntity<ExceptionResponse> handleEntityNotFoundException
            ( EntityNotFoundException e ) {
        ExceptionResponse response = new ExceptionResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
