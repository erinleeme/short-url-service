package kr.co.shorturlservice.application;

import kr.co.shorturlservice.presentation.ShortenUrlCreateRequestDto;
import kr.co.shorturlservice.presentation.ShortenUrlCreateResponseDto;
import org.springframework.stereotype.Service;

@Service
public class SimpleShortenUrlService {
    public ShortenUrlCreateResponseDto generateShortenUrl(ShortenUrlCreateRequestDto shortenUrlCreateRequestDto) {
        /*단축 url 키 생성*/

        /*원래의 url과 단축 url 키를 통해 ShortenUrl 도메인 객체 생성*/

        /*생성된 ShortenUrl을 레포지토리를 통해 저장*/

        /*ShortenUrl을 ShortenUrlCreateResponseDto로 변환하여 반환*/

        return null;
    }
}
