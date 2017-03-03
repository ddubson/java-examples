package pkg;

import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FluentleniumIntegrationTest extends FluentTest {
    @LocalServerPort
    int port;

    @Test
    public void exampleFluentleniumTest() {
        goTo(getUrl("/"));
        assertThat($("#hello").text(), equalTo("Hello World!"));
    }

    private String getUrl(String endpoint) {
        return String.format("http://localhost:%d%s", port, endpoint);
    }
}
