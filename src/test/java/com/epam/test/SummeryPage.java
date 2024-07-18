package com.epam.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummeryPage {

    WebDriver driver;
    public SummeryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy( xpath = "//span[contains(text(), 'Number of Instances')]/following-sibling::span")
    WebElement numberOfInstances;

    @FindBy( xpath = "//span[contains(text(), 'Operating System / Software')]/following-sibling::span")
    WebElement operatingSystem;

    @FindBy( xpath = "//span[contains(text(), 'Provisioning Model')]/following-sibling::span")
    WebElement provisioningModel;

    @FindBy( xpath = "//span[contains(text(), 'Machine type')]/following-sibling::span")
    WebElement machineType;

    @FindBy( xpath = "//span[contains(text(), 'Add GPUs')]/following-sibling::span")
    WebElement gpuToggle;

    @FindBy( xpath = "//span[contains(text(), 'GPU Model')]/following-sibling::span")
    WebElement gpuModel;

    @FindBy( xpath = "//span[contains(text(), 'Number of GPUs')]/following-sibling::span")
    WebElement numberOfGpus;

    @FindBy( xpath = "//span[contains(text(), 'Local SSD')]/following-sibling::span")
    WebElement localSsd;

    @FindBy( xpath = "//span[contains(text(), 'Region')]/following-sibling::span")
    WebElement region;

    @FindBy( xpath = "//span[contains(text(), 'Committed use discount options')]/following-sibling::span")
    WebElement commitedUse;

    public String getNumberOfInstances() {
        return numberOfInstances.getText();
    }

    public String getOperatingSystem() {
        return operatingSystem.getText();
    }

    public String getProvisioningModel() {
        return provisioningModel.getText();
    }

    public String getMachineType() {
        return machineType.getText();
    }

    public String getGpuToggle() {
        return gpuToggle.getText();
    }

    public String getGpuModel() {
        return gpuModel.getText();
    }

    public String getNumberOfGpus() {
        return numberOfGpus.getText();
    }

    public String getLocalSsd() {
        return localSsd.getText();
    }

    public String getRegion() {
        return region.getText();
    }

    public String getCommitedUse() {
        return commitedUse.getText();
    }

}