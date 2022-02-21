package task.external.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import task.api.github.request.GithubDTO;
import task.api.github.request.GithubRequest;
import task.external.facade.GithubFacade;

@Service
@Slf4j
@RequiredArgsConstructor
public class GithubRepositoryDetailsService implements GithubFacade {

    private static final String GITHUB_URL = "https://api.github.com/repos/";
    private final RestTemplate restTemplate = new RestTemplate();

    private GithubRequest getGithubDetailsForOwnerAndRepositoryName(String owner, String repositoryName) {
        GithubDTO githubDTO = callGetMethod(
                owner, repositoryName);
        return GithubRequest.builder()
                .fullName(githubDTO.getFull_name())
                .description(githubDTO.getDescription())
                .cloneUrl(githubDTO.getClone_url())
                .stars(githubDTO.getWatchers())
                .createdAt(githubDTO.getCreated_at())
                .build();
    }

    private GithubDTO callGetMethod(Object...objects) {
        return restTemplate.getForObject(GITHUB_URL + "{owner}/{repositoryName}",
                GithubDTO.class,
                objects);
    }

    public GithubRequest getGithubDetails(String owner, String repositoryName) {
        return getGithubDetailsForOwnerAndRepositoryName(owner, repositoryName);
    }
}
