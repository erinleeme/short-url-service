package kr.co.shorturlservice.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ShortenUrlRestController {

    /*단축 url 생성*/
    @RequestMapping(value = "/shortenUrl", method = RequestMethod.POST)
    public ResponseEntity<?> createShortenUrl() {
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping(value = "/{shortenUrlKey}", method = RequestMethod.GET)
    public ResponseEntity<?> redirectShortenUrl() {
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping(value = "/shortenUrl/{shortenUrlKey}", method = RequestMethod.GET)
    public ResponseEntity<?> getShortenUrlInformation() {
        return ResponseEntity.ok().body(null);
    }
}

