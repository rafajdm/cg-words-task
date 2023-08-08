package git.rafajdm.cgwordstask.controllers;

import git.rafajdm.cgwordstask.controllers.exceptions.BadParameterException;
import git.rafajdm.cgwordstask.webclient.WordsClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class SynonymsAPI {
    private final String BASE_URL = "synonyms";
    private final String GET_SYNONYM = BASE_URL + "/{word}";
    private final WordsClient wordsClient;

    @GetMapping(GET_SYNONYM)
    public ArrayList<String> getSynonyms(@PathVariable("word") String word) {
        if (word == null || word.trim().equals("")) throw new BadParameterException("Word must be a valid string.");
        return wordsClient.getSynonyms(word).getSynonyms();
    }
}
