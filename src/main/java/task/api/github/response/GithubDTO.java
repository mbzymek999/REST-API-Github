package task.api.github.response;

import lombok.Getter;

import java.util.Date;

@Getter
public class GithubDTO {
    private String full_name;
    private String description;
    private String clone_url;
    private int watchers;
    private Date created_at;
}
