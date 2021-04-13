package power.gamer.ui.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import power.gamer.ui.PowerGamerUiApp;

@CucumberContextConfiguration
@SpringBootTest(classes = PowerGamerUiApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
