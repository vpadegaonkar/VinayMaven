package com.example.javamavenjunithelloworld;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.jna.platform.FileUtils;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Integration test for the HelloApp program.
 * <p/>
 * An integration test verifies the workings of a complete program, a module, or a set of dependant classes.
 * <p/>
 * This integration test uses system-rules, an extension for JUnit that lets you test System.out and System.exit()
 * etc.:
 * <p/>
 * http://www.stefan-birkner.de/system-rules
 */
public class HelloWithTestsIT {

    @Rule
    public final StandardOutputStreamLog out = new StandardOutputStreamLog();

    @Test
    public void doesItSayHelloTest() {
        String[] args = {"1"};
        HelloApp.main(args);

        assertThat(out.getLog(), is(equalTo(Hello.HELLO + "\n")));
    }

    @Test
    public void doesItSayHelloTest3() {
        String[] args = {"4"};
        HelloApp.main(args);

        String thrice = Hello.HELLO + "\n" + Hello.HELLO + "\n" + Hello.HELLO + "\n" + Hello.HELLO + "\n";
     /* Setup firefox binary to start in Xvfb        
        String Xport = System.getProperty(
                "lmportal.xvfb.id", ":10");
        final File firefoxPath = new File(System.getProperty(
                "lmportal.deploy.firefox.path", "/usr/bin/firefox/"));
        FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxPath);
        firefoxBinary.setEnvironmentProperty("DISPLAY", Xport);

        // Start Firefox driver
        WebDriver driver = new FirefoxDriver(firefoxBinary, null);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://google.com/");

        // Take snapshot of browser
        //File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils f1 =FileUtils.getInstance();
        //f1.copyFile(srcFile, new File("ffsnapshot.png"));
        driver.quit();*/
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        //Close the browser
        driver.quit();



assertThat(out.getLog(), is(equalTo(thrice)));
    }
}
