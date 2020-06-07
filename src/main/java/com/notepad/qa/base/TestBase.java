package com.notepad.qa.base;

import com.notepad.qa.util.TestUtil;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WindowsDriver driver = null;
    public static Properties prop;

    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/notepad"
                    + "/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization()
    {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app",prop.getProperty("app"));
        cap.setCapability("platformName",prop.getProperty("platformName"));
        cap.setCapability("deviceName",prop.getProperty("deviceName"));

        try {
            driver = new WindowsDriver(new URL(prop.getProperty("url")), cap);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

}
