package pkg;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class WebIntegrationTest {
    @LocalServerPort
    int port;

    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        this.restTemplate = new RestTemplate();
    }

    @Test
    public void todoApplicationShouldReturnAListOfTodos() {
        ResponseEntity<Todo[]> todos = restTemplate.getForEntity(getUrl("/todos"), Todo[].class);
        assertThat(todos.getBody().length, equalTo(2));
    }


    @Test(expected = HttpClientErrorException.class)
    public void testANonExistentPage() {
        try {
            restTemplate.getForObject(getUrl("/nonexistent"), String.class);
        } catch (HttpClientErrorException e) {
            assertThat(e.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
            throw e;
        }
    }

    private String getUrl(String endpoint) {
        return String.format("http://localhost:%d%s", port, endpoint);
    }
}
