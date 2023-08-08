package git.rafajdm.cgwordstask.webclient;

import git.rafajdm.cgwordstask.webclient.model.SynonymsResponse;

public interface WordsClient {
    SynonymsResponse getSynonyms(String word);
}
