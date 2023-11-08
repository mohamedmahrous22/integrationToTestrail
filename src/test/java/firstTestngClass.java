import com.qa.testrailmanager.testRailManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class firstTestngClass {
    public WebDriver driver;
    protected String testCaseID;
    @BeforeTest
    public void prepare()
    {
        WebDriverManager.chromedriver().setup();

         driver = new ChromeDriver();
    }
    @AfterTest
    public void closeDriver()
    {
        driver.quit();
    }

    @Test
    public void openBrowser()
    {   testCaseID="182";
        driver.get("http://10.3.4.64:8081/OMSPortal");    }

    @AfterMethod
    public void addResultToTestRail(ITestResult result){
        if(result.getStatus() == ITestResult.SUCCESS){
            testRailManager.addResultForTestCase(testCaseID, testRailManager.Testrail_Pass_Status,"");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            testRailManager.addResultForTestCase(testCaseID,testRailManager.Testrail_Fail_Status,"test go failed "+ result.getName()+" : Failed");
        }

    }
}
