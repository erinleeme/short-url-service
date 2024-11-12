package kr.co.shorturlservice.presentation;

import kr.co.shorturlservice.application.SimpleShortenUrlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ShortenUrlRestController.class)
public class ShortenUrlRestControllerTest {
    @MockBean
    private SimpleShortenUrlService simpleShortenUrlService;

    @Autowired
    private MockMvc mockmvc;

    @Test
    void redirectShortenUrl_Success() throws Exception {
        String originalUrl = "https://www.naver.com";

        when(simpleShortenUrlService.getOriginalUrlByShortenUrlKey(any())).thenReturn(originalUrl);

        mockmvc.perform(get("/any-key"))
                .andExpect(status().isMovedPermanently())
                .andExpect(header().string("Location", originalUrl))
                .andDo(print());
    }
}
