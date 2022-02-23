package task.external.facade;

import task.api.github.response.GithubResponse;

public interface GithubFacade  {

    GithubResponse getGithubDetails(String owner, String repositoryName);
}
