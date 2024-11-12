package kr.co.shorturlservice.domain;

public interface ShortenUrlRepository {
    void saveShortenUrl(ShortenUrl shortenUrl);

    ShortenUrl findShortenUrlByShortenUrlKey(String shortenUrlKey);
}
