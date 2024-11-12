package kr.co.shorturlservice.presentation;

import kr.co.shorturlservice.domain.LackOfShortenUrlKeyException;
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

    @ExceptionHandler(LackOfShortenUrlKeyException.class)
    public ResponseEntity<String> lackOfShortenUrlException(LackOfShortenUrlKeyException e) {
        return new ResponseEntity<>("중복된 단축 URL 값입니다.");
    }
}
