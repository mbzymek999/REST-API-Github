package task.api.github.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import task.api.github.request.GithubRequest;
import task.external.facade.GithubFacade;

@RestController
@RequiredArgsConstructor
public class GithubRepositoryDetailsController {

    private final GithubFacade facade;

    @GetMapping("/repositories/{owner}/{repositoryName}")
    GithubRequest readGithubRepositoryDetails(@PathVariable String owner, @PathVariable String repositoryName) {
        return facade.getGithubDetails(owner, repositoryName);
    }
}
