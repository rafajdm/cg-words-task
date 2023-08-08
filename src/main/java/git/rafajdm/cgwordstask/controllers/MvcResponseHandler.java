package git.rafajdm.cgwordstask.controllers;

import git.rafajdm.cgwordstask.controllers.exceptions.BadParameterException;
import git.rafajdm.cgwordstask.webclient.exceptions.WordsApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MvcResponseHandler {

    @ExceptionHandler(BadParameterException.class)
    public ResponseEntity<Object> handleBadParameter(BadParameterException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WordsApiException.class)
    public ResponseEntity<Object> handleGenericError(WordsApiException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
