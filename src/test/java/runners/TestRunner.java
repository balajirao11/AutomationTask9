package runners;
 
import java.io.*;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 //features = "src/test/resources/functionalTests/List.feature",
 //features = "src/test/resources/functionalTests/automationPractice.feature",		 
 //features = "src/test/resources/functionalTests/Sample.feature",
 //features = "src/tet/resources/functionalTests/hashMap.feature",
 features = "src/test/resources/functionalTests/automationTask.feature",
 glue= {"stepDefinitions"},
 plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
 monochrome = true  //Console o/p for cucumber
 )
 
 
public class TestRunner {
/* @AfterClass
 public static void writeExtentReport() {
 Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
 }
 */
}