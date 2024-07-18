

import com.epam.test.CalculatorPage;
import com.epam.test.SummeryPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.ArrayList;

public class Test {

    private WebDriver driver;
    CalculatorPage calculatorPage;
    SummeryPage summaryPage;

    String numberOfInstances = "4";
    String operatingSystem = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
    String provisioningModel = "Regular";
    String machineType = "n1-standard-8 vCPUs: 8, RAM: 30 GB";
    String gpuModel = "NVIDIA Tesla V100";
    String numberOfGPUs =  "1";
    String localSSD =  "2x375 GB";
    String region = "Netherlands (europe-west4)";
    String commitedUse =  "1 year";


    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://cloud.google.com/products/calculator");
    }

    @BeforeClass
    public void createCalculation() throws InterruptedException {
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.calculate(
                numberOfInstances,
                machineType,
                gpuModel,
                localSSD,
                region,
                commitedUse);

        // switching tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        summaryPage = new SummeryPage(driver);

    }

    @org.testng.annotations.Test
    public void testNumberOfInstances() {
        String expectedNumberOfInstances = numberOfInstances;
        String actualNumberOfInstances = summaryPage.getNumberOfInstances();
        Assert.assertEquals(expectedNumberOfInstances, actualNumberOfInstances);
    }

    @org.testng.annotations.Test
    public void testOperatingSystem() {
        String expectedOperatingSystem = operatingSystem;
        String actualOperatingSystem = summaryPage.getOperatingSystem();
        Assert.assertEquals(expectedOperatingSystem, actualOperatingSystem);
    }

    @org.testng.annotations.Test
    public void testProvisioningModel() {
        String expectedProvisioningModel = provisioningModel;
        String actualProvisioningModel = summaryPage.getProvisioningModel();
        Assert.assertEquals(expectedProvisioningModel, actualProvisioningModel);
    }

    @org.testng.annotations.Test
    public void testMachineType() {
        String expectedMachineType = "n1-standard-8, vCPUs: 8, RAM: 30 GB";
        String actualMachineType = summaryPage.getMachineType();
        Assert.assertEquals(expectedMachineType, actualMachineType);
    }

    @org.testng.annotations.Test
    public void testGpuToggle() {
        String expectedGpuToggle = "true";
        String actualGpuToggle = summaryPage.getGpuToggle();
        Assert.assertEquals(expectedGpuToggle, actualGpuToggle);
    }

    @org.testng.annotations.Test
    public void testGpuModel() {
        String expectedGpuModel = "NVIDIA V100";
        String actualGpuModel = summaryPage.getGpuModel();
        Assert.assertEquals(expectedGpuModel, actualGpuModel);
    }

    @org.testng.annotations.Test
    public void testNumberOfGpus() {
        String expectedNumberOfGpus = numberOfGPUs;
        String actualNumberOfGpus = summaryPage.getNumberOfGpus();
        Assert.assertEquals(expectedNumberOfGpus, actualNumberOfGpus);
    }

    @org.testng.annotations.Test
    public void testLocalSsd() {
        String expectedLocalSsd = localSSD;
        String actualLocalSsd = summaryPage.getLocalSsd();
        Assert.assertEquals(expectedLocalSsd, actualLocalSsd);
    }

    @org.testng.annotations.Test
    public void testRegion() {
        String expectedRegion = region;
        String actualRegion = summaryPage.getRegion();
        Assert.assertEquals(expectedRegion, actualRegion);
    }

    @org.testng.annotations.Test
    public void testCommitedUse() {
        String expectedCommitedUse = commitedUse;
        String actualCommitedUse = summaryPage.getCommitedUse();
        Assert.assertEquals(expectedCommitedUse, actualCommitedUse);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}

