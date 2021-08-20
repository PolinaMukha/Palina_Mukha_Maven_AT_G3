package day10;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {".day10"},
        features = {"src/test/resources/features/MyFirstFeature.feature"},
        strict = true)

public class CucumberRunner {
}
