package kr.co.shorturlservice.domain;

public class ShortenUrl {
    private String originalUrl;
    private String shortenUrlKey;
    private Long redirectCount;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortenUrlKey() {
        return shortenUrlKey;
    }

    public Long getRedirectCount() {
        return redirectCount;
    }
}
