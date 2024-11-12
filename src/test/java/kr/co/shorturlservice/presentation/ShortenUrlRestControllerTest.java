package kr.co.shorturlservice.presentation;

import kr.co.shorturlservice.application.SimpleShortenUrlService;
import kr.co.shorturlservice.domain.NotFoundShortenUrlException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ShortenUrlRestController.class)
public class ShortenUrlRestControllerTest {
    @MockBean
    private SimpleShortenUrlService simpleShortenUrlService;

    @Autowired
    private MockMvc mockmvc;

    @Test
    @DisplayName("원래의 URL로 리다이렉트 되어야한다.")
    void redirectShortenUrl_Success() throws Exception {
        String originalUrl = "https://www.naver.com";

        when(simpleShortenUrlService.getOriginalUrlByShortenUrlKey(any())).thenReturn(originalUrl);

        mockmvc.perform(get("/any-key"))
                .andExpect(status().isMovedPermanently())
                .andExpect(header().string("Location", originalUrl))
                .andDo(print());
    }

    @Test
    @DisplayName("없는 단축 URL인 경우에는 에러를 반환한다.")
    void redirectShortenUrl_Fail() throws Exception {
        when(simpleShortenUrlService.getOriginalUrlByShortenUrlKey(any())).thenThrow(NotFoundShortenUrlException.class);

        mockmvc.perform(get("/any-key"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("단축 url을 찾지 못했습니다."))
                .andDo(print());
    }
}
