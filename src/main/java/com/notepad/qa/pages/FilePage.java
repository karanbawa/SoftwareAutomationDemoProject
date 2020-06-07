package com.notepad.qa.pages;

import com.notepad.qa.base.TestBase;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilePage extends TestBase {

    @WindowsFindBy(accessibility="41001")
    WebElement newBtn;

    public FilePage()
    {
        PageFactory.initElements(driver,this);
    }

    public void clickOnNewButton()
    {
        driver.findElementByAccessibilityId("41001").click();
        //newBtn.click();
    }

    public void clickOnSaveButton()
    {
        driver.findElementByAccessibilityId("41008").click();
    }
}
