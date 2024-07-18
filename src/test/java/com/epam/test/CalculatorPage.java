package com.epam.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class CalculatorPage {
    WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy( xpath = "//button//*[text()='Add to estimate']" )
    WebElement addEstimateButton;

    @FindBy( xpath = "//h2[text()='Compute Engine']" )
    WebElement computeEngineOption;

    @FindBy( id = "c13" )
    WebElement numberOfInstancesInput;

    @FindBy( xpath = "(//div[@class='VfPpkd-aPP78e'])[7]" )
    WebElement machineTypeDropDown;

    @FindBy( xpath = "(//div[@class='VfPpkd-aPP78e'])[8]" )
    WebElement gpuModelDropDown;

    @FindBy( xpath = "(//div[@class='VfPpkd-aPP78e'])[10]" )
    WebElement ssdDropDown;

    @FindBy( xpath = "(//div[@class='VfPpkd-aPP78e'])[11]" )
    WebElement regionDropDown;

    @FindBy( css = "button[aria-label='Add GPUs']" )
    WebElement addGpuButton;

    public void calculate(String instanceNumber, String machineType, String gpuModel, String ssd, String region, String discountOption) throws InterruptedException {
        addEstimateButton.click();

        computeEngineOption.click();

        numberOfInstancesInput.clear();
        numberOfInstancesInput.sendKeys( instanceNumber );

        machineTypeDropDown.click();
        Thread.sleep(500L);
        machineType = machineType.split(" ")[0];
        driver.findElement(By.cssSelector("li[data-value= '" + machineType + "' ]")).click();

        addGpuButton.click();
        Thread.sleep(1000L);

        gpuModelDropDown.click();
        Thread.sleep(500L);
        gpuModel = gpuModel.replace(" ", "-").toLowerCase();
        driver.findElement(By.cssSelector("li[data-value=" + gpuModel + "]")).click();

        ssdDropDown.click();
        Thread.sleep(500L);
        driver.findElement(By.xpath("//ul[@aria-label='Local SSD']//li[.//span[text()='"+ ssd +"']]") ).click();

        regionDropDown.click();
        int start = region.indexOf("(") + 1;
        int end = region.lastIndexOf(")");
        String zone = region.substring(start, end);
        Thread.sleep(500L);
        driver.findElement(By.cssSelector("li[data-value= " + zone + "]") ).click();

        driver.findElement(By.xpath("//label[text()='"+ discountOption +"']")).click();

        Thread.sleep(2000L);
        driver.findElement(By.xpath("//button[@aria-label='Open Share Estimate dialog']")).click();
        Thread.sleep(1000L);
        driver.findElement(By.linkText("Open estimate summary")).click();
        Thread.sleep(500L);



        // switching tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));




    }

}
