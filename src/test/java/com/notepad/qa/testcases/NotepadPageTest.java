package com.notepad.qa.testcases;

import com.notepad.qa.base.TestBase;
import com.notepad.qa.pages.EditPage;
import com.notepad.qa.pages.FilePage;
import com.notepad.qa.pages.NotepadPage;

import org.testng.Assert;
import org.testng.annotations.*;


public class NotepadPageTest extends TestBase {

    NotepadPage notepadPage;
    FilePage filePage;
    EditPage editPage;

    public NotepadPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp()
    {
        initialization();
        notepadPage = new NotepadPage();
        filePage = new FilePage();
        editPage = new EditPage();
    }

    @AfterMethod
    public void cleanUp()
    {
        driver.quit();
        setUp();
    }

    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }

    @Test(priority = 1)
    public void checkifEditbuttonExists()
    {
        Assert.assertTrue(editPage.checkEditOption(),"Not available");
    }

    @Test(priority = 2)
    public void checkSaveNewTXTFile() throws InterruptedException {
        notepadPage.clickonFile();
        filePage.clickOnNewButton();
        driver.findElementByClassName("Scintilla").sendKeys("hello");
        notepadPage.clickonFile();
        filePage.clickOnSaveButton();
        driver.findElementByName("Desktop").click();
        Thread.sleep(1000);
        driver.findElementByAccessibilityId("1148").click();
        driver.findElementByAccessibilityId("1148").sendKeys("successfulSaveTest");
        driver.findElementByName("Save").click();
        Assert.assertEquals("successfulSaveTest.txt",driver.findElementByName("successfulSaveTest.txt").getText());
    }

}