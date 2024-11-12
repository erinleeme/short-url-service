package kr.co.shorturlservice.presentation;

import kr.co.shorturlservice.domain.NotFoundShortenUrlException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundShortenUrlException.class)
    public ResponseEntity<String> notFoundShortenUrlException(NotFoundShortenUrlException e) {
        return new ResponseEntity<>("단축 url을 찾지 못했습니다.", HttpStatus.NOT_FOUND);
    }
}
