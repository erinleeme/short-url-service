package kr.co.shorturlservice.application;

import kr.co.shorturlservice.domain.NotFoundShortenUrlException;
import kr.co.shorturlservice.domain.ShortenUrl;
import kr.co.shorturlservice.domain.ShortenUrlRepository;
import kr.co.shorturlservice.presentation.ShortenUrlCreateRequestDto;
import kr.co.shorturlservice.presentation.ShortenUrlCreateResponseDto;
import kr.co.shorturlservice.presentation.ShortenUrlInformationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleShortenUrlService {

    private final ShortenUrlRepository shortenUrlRepository;

    @Autowired
    public SimpleShortenUrlService(ShortenUrlRepository shortenUrlRepository) {
        this.shortenUrlRepository = shortenUrlRepository;
    }

    public ShortenUrlCreateResponseDto generateShortenUrl(ShortenUrlCreateRequestDto shortenUrlCreateRequestDto) {
        /*단축 url 키 생성*/
        String originalUrl = shortenUrlCreateRequestDto.getOriginalUrl();
        String shortenUrlKey = ShortenUrl.generateShortenUrlKey();

        /*원래의 url과 단축 url 키를 통해 ShortenUrl 도메인 객체 생성*/
        ShortenUrl shortenUrl = new ShortenUrl(originalUrl, shortenUrlKey);

        /*생성된 ShortenUrl을 레포지토리를 통해 저장*/
        shortenUrlRepository.saveShortenUrl(shortenUrl);

        /*ShortenUrl을 ShortenUrlCreateResponseDto로 변환하여 반환*/
        return new ShortenUrlCreateResponseDto(shortenUrl);
    }

    public ShortenUrlInformationDto getShortenUrlInformationByShortenUrlKey(String shortenUrlKey) {
        ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

        if(shortenUrl == null) {
            throw new NotFoundShortenUrlException();
        }
        return new ShortenUrlInformationDto(shortenUrl.getOriginalUrl(), shortenUrl.getShortenUrlKey(), shortenUrl.getRedirectCount());
    }

    public String getOriginalUrlByShortenUrlKey(String shortenUrlKey) {
        ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

        if(shortenUrl == null) {
            throw new NotFoundShortenUrlException();
        }

        shortenUrl.increaseRedirectUrl();
        shortenUrlRepository.saveShortenUrl(shortenUrl);

        return shortenUrl.getOriginalUrl();
    }
}
