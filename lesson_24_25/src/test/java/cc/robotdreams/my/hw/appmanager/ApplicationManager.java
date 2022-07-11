package cc.robotdreams.my.hw.appmanager;

import cc.robotdreams.my.hw.appmanager.elements.ButtonsHelper;
import cc.robotdreams.my.hw.appmanager.elements.WebTableHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.fail;

/**
 * Created by asvidersky on 7/11/2022.
 */

public class ApplicationManager {
    private WebDriver driver;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ButtonsHelper buttonsHelper;
    private WebTableHelper webTableHelper;

    private final StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        System.clearProperty("webdriver.chrome.driver");
        System.setProperty("webdriver.chrome.driver", "d:\\Personal\\Tools\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        webTableHelper = new WebTableHelper(driver);
        buttonsHelper = new ButtonsHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        driver.manage().window().maximize();
        sessionHelper.login();
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public WebTableHelper getWebTableHelper() {
        return webTableHelper;
    }

    public ButtonsHelper getButtonsHelper() {
        return buttonsHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
