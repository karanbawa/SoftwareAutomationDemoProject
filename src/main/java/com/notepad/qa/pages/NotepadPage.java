package com.notepad.qa.pages;

import com.notepad.qa.base.TestBase;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotepadPage extends TestBase {

    @FindBy(name="File")
    WebElement fileBtn;

    @FindBy(name="Edit")
    WindowsElement editBtn;

//    public NotepadPage()
//    {
//        PageFactory.initElements(driver,this);
//    }

    public FilePage clickonFile()
    {
        driver.findElementByName("File").click();
        return new FilePage();
    }
}
