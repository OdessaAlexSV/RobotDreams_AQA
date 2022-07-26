package cc.robotdreams.my.hw.appmanager;

import org.openqa.selenium.WebDriver;

/**
 * Created by asvidersky on 7/11/2022.
 */

public class SessionHelper {
    private WebDriver driver;

    public SessionHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        driver.navigate().to("https://demoqa.com/");
    }
}
