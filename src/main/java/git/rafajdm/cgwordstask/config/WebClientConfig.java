package git.rafajdm.cgwordstask.config;

import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfig {
    private static final String BASE_URL = "https://wordsapiv1.p.rapidapi.com";

    @Value("${words.api.key-header}")
    private String apiKeyHeader;
    @Value("${words.api.key-value}")
    private String apiKeyValue;
    @Value("${words.api.host-header}")
    private String apiHostHeader;
    @Value("${words.api.host-value}")
    private String apiHostValue;

    @Bean
    public WebClient webClient() {
        HttpClient httpClient = HttpClient.create()
                .wiretap(true)
                .doOnConnected(connection -> {
                    connection.addHandlerFirst(new ReadTimeoutHandler(10, TimeUnit.SECONDS));
                    connection.addHandlerFirst(new WriteTimeoutHandler(10, TimeUnit.SECONDS));
                });

        return WebClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.add(apiKeyHeader, apiKeyValue);
                    httpHeaders.add(apiHostHeader, apiHostValue);
                })
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
