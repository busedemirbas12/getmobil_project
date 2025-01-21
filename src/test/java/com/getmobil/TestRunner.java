package com.getmobil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/TelefonSat",
                "src/test/resources/Bayilik"
        },
        plugin = { "pretty", "junit:target/surefire-reports/junitreports/testNGReport.xml" },
        
        monochrome = true,
        glue = "com.getmobil",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Before
    public void setUp(Scenario scenario) {
        Logger.info("-----  TEST STARTED \n" + scenario.getName() + "  SCENARIO --------");
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        Thread.sleep(5);
        Logger.info("---------- TEST FINISHED ---------\n" + scenario.getName());
    }
}
