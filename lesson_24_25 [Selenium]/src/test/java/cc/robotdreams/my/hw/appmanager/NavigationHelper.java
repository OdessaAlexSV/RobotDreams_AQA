package cc.robotdreams.my.hw.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by asvidersky on 7/11/2022.
 */

public class NavigationHelper extends HelperBase {
    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoMainPage() {
        click(By.xpath("//img[@src=\"/images/Toolsqa.jpg\"]"));
    }

    public void gotoElementsSection() {
        click(By.xpath("//div [@class='category-cards']//h5 [text()='Elements']"));
    }
}
