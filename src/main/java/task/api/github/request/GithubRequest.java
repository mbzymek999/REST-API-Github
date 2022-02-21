package task.api.github.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class GithubRequest {
    private String fullName;
    private String description;
    private String cloneUrl;
    private int stars;
    private Date createdAt;
}
