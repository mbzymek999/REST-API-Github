package task.api.github.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import task.api.github.response.GithubResponse;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class GithubRepositoryDetailsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testReadGithubRepositoryDetails() throws Exception{
        // given
        String owner = "mbzymek999";
        String repositoryName = "REST-API-Github";
        //when
        MvcResult mvcResult = mockMvc.perform(get("/repositories/" +  owner + "/" +repositoryName))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        // then
        GithubResponse githubResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), GithubResponse.class);
        assertThat(githubResponse).isNotNull();
    }
}