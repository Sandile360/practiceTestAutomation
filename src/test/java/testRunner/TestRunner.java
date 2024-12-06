package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"/home/sandile/Desktop/git/practiceTestAutomation/src/test/java/features"},
        glue = {"stepDefinition"},
        monochrome = true,
        plugin = {"html:target/cucumber-reports.html",
                "junit:target/cucumber.xml"
        }
)
public class TestRunner {

}
