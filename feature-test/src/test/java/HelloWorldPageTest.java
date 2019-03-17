import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.configuration.ConfigurationProperties;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

//@FluentConfiguration(screenshotPath = "target/screenshots", screenshotMode = ConfigurationProperties.TriggerMode.AUTOMATIC_ON_FAIL, capabilities = "{\"chromeOptions\": {\"args\": [\"disable-gpu\"]}}")
@FluentConfiguration(screenshotPath = "target/screenshots", screenshotMode = ConfigurationProperties.TriggerMode.AUTOMATIC_ON_FAIL, capabilities = "{\"chromeOptions\": {\"args\": [\"headless\",\"disable-gpu\"]}}")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloWorld.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloWorldPageTest extends FluentTest {
    @LocalServerPort
    private int port;
    @Page
    private HelloWorldPage helloWorldPage;

    @Test
    public void helloWorldPage_TitleShouldContainTitleText() {
        String expectedTitleText = "Welcome to Your Vue";
        System.out.println("port = " + port);
        goTo(helloWorldPage).await().until(() -> helloWorldPage.find("h1").first().text().contains(expectedTitleText));
    }

}
