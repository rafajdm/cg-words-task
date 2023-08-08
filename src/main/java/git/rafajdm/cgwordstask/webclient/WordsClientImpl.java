package git.rafajdm.cgwordstask.webclient;

import git.rafajdm.cgwordstask.webclient.exceptions.WordsApiException;
import git.rafajdm.cgwordstask.webclient.model.SynonymsResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class WordsClientImpl implements WordsClient {
    private final WebClient webClient;

    @Override
    public SynonymsResponse getSynonyms(String word) {
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/words/{word}/synonyms")//.path("{word}").path("/synonyms")
                        .build(word))
                .retrieve()
                .bodyToMono(SynonymsResponse.class)
                .doOnError(throwable -> {
                    log.error("An error has ocurred: {}", throwable.getMessage());
                })
                .onErrorResume(throwable ->
                    Mono.error(new WordsApiException("There has been a problem with the words server.")))
                .block();
    }
}
