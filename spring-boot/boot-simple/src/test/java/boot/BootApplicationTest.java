package boot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BootApplicationTest {
    @LocalServerPort
    private String serverPort;

    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        this.restTemplate = new RestTemplate();
    }

    @Test
    public void springBootEnvironmentShouldStartAndStopSuccessfully() {
        String helloWorldResponse = this.restTemplate.getForObject(String.format("http://localhost:%s", serverPort), String.class);
        assertThat(helloWorldResponse, equalTo("Hello World!"));
    }
}