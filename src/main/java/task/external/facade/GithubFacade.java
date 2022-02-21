package task.external.facade;

import task.api.github.request.GithubRequest;

public interface GithubFacade  {

    GithubRequest getGithubDetails(String owner, String repositoryName);
}
