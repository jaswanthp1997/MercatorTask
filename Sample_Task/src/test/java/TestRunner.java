import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Login.feature",
         // glue = {"src/test/java/MyStepdefs.java"},
        tags = "@sample",
        plugin = {"pretty","html:target1/crept.html"}
)



public class TestRunner {

    public static WebDriver driver;

    @BeforeClass
    public  static void startBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }


    @AfterClass

    public static void end(){
        driver.close();
    }


}

