package com.example.javamavenjunithelloworld;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;

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
       

//File file = new File("C:\\Selenium\\IEDriverServer_x64_2.53.1\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
WebDriver driver = new FirefoxDriver();
driver.get("http://www.guru99.com/selenium-tutorial.html");
assertThat(out.getLog(), is(equalTo(thrice)));
    }
}
