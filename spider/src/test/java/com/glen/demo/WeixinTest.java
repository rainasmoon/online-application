package com.glen.demo;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class WeixinTest {

    private static Logger log = LoggerFactory.getLogger("TTT");

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = getRealPhone();
        // 初始化
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    private DesiredCapabilities getRealPhone() {
        
        // 设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "zte_q505t-Q505T");

        // 设置安卓系统版本
        capabilities.setCapability("platformVersion", "4.3");

        // 设置app的主包名和主类名
        capabilities.setCapability("app", "");
        capabilities.setCapability("appPackage", "com.tencent.mm");
        capabilities.setCapability("appActivity", ".ui.LauncherUI");
        
        capabilities.setCapability("fastReset", "false");
        capabilities.setCapability("fullReset", "false");
        capabilities.setCapability("noReset", "true");
        
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyBoard", "True");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("androidProcess", "com.tencent.mm:appbrand1");

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        return capabilities;
    }

    // adb connect 127.0.0.1:62001

    private DesiredCapabilities getPhoneAVD() {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "weixin.apk");

        // 设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "test");
        // capabilities.setCapability("deviceName", "127.0.0.1:62001");
        // capabilities.setCapability("udid", "127.0.0.1:62001");

        // 设置安卓系统版本
        capabilities.setCapability("platformVersion", "4.3");
        capabilities.setCapability("fastReset", "false");
        capabilities.setCapability("fullReset", "false");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("newCommandTimeout", 24000);
        capabilities.setCapability("device", "appium");

        // 设置app的主包名和主类名
        capabilities.setCapability("app", app.getAbsolutePath());

        capabilities.setCapability("appPackage", "com.tencent.mm");
        capabilities.setCapability("appActivity", ".ui.LauncherUI");

        return capabilities;
    }

    @Test
    public void openWebWeixin() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        loginWeixin();
        
        
        driver.findElementByXPath("//*[@text='泰康在线保险']").click();
        driver.findElementByXPath("//*[@text='保险商城']").click();
        

        println(driver.getContextHandles());
//        driver.context("WEBVIEW_com.tencent.mm:tools");
        Thread.sleep(5000);
        println(driver.getPageSource());
//        driver.findElementByXPath("//*[contains(@url, '全部')]").click();
//        driver.findElementByXPath("//*[contains(., '全部')]").click();
    }

    private void loginWeixin() {
        
        WebElement needLogin = driver.findElement(By.name("登录"));
        
        if (needLogin != null) {
            needLogin.click();

            List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
            textFieldsList.get(0).sendKeys("13691300925");

            driver.findElement(By.name("下一步")).click();

            textFieldsList = driver.findElementsByClassName("android.widget.EditText");
            textFieldsList.get(0).sendKeys("bsnpb6p0");

            driver.findElement(By.name("登录")).click();

            driver.findElement(By.name("否")).click();

        }
    }

    private void println(Object o) {
        log.info(o.toString());

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}