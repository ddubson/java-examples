package session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
@EnableRedisHttpSession
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    public String welcome(HttpSession session) {
        UUID sessionId = null;
        Optional<UUID> sessionIdOpt = Optional.ofNullable((UUID)session.getAttribute("uid"));
        if(!sessionIdOpt.isPresent()) {
            sessionId = UUID.randomUUID();
            session.setAttribute("uid", sessionId);
        } else {
            sessionId = sessionIdOpt.get();
        }

        return sessionId.toString();
    }
}
