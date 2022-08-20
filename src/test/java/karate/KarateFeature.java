package karate;

import com._42talents.spring_boot_karate_example.SpringBootKarateExampleApplication;
import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.util.SocketUtils;

@SpringBootTest(
        classes = {SpringBootKarateExampleApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KarateFeature {

    @LocalServerPort
    private String localServerPort;

    protected Karate karateSzenario(String scenarioName) {
        int h2Port = SocketUtils.findAvailableTcpPort();

        return Karate.run()
                .scenarioName(scenarioName)
                .tags("junit")
                .relativeTo(getClass())
                .systemProperty("karate.port", localServerPort)
                .systemProperty("h2.port", h2Port + "")
                .karateEnv("dev");
    }
}
