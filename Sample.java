import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Sample {

    public static void run() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilites = new DesiredCapabilities();

        capabilites.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel4");
        capabilites.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilites.setCapability("chromedriverExecutable", "C:\\Users\\Akhil Rajan\\Downloads\\chromedriver_win32\\chromedriver.exe");
        capabilites.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
        capabilites.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
        capabilites.setCapability("noReset", true);

        AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilites);
        driver.get("https://apuat.strata3test.com//");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(5000);

        Set<String> views = driver.getContextHandles();
        for (String view : views) {
            System.out.println("View is :- " + view);
            if (view.contains("WEBVIEW_chrome")) {
                driver.context(view);
                break;

            }

        }

        driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler")).click();
        driver.quit();
       // driver.findElement(By.xpath("")).click();
      //  driver.findElement(By.xpath("//a[@title='My deliveries']")).click();
      //  driver.findElement(By.xpath("LoginBtn")).click();

    }
}
