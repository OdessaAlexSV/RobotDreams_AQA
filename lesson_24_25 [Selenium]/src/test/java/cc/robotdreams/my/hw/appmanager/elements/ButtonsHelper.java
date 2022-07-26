package cc.robotdreams.my.hw.appmanager.elements;

import cc.robotdreams.my.hw.appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by asvidersky on 7/11/2022.
 */

public class ButtonsHelper extends HelperBase {

    public ButtonsHelper(WebDriver driver) {
        super(driver);
    }

    public void clickToClickMeButton() {
        click(By.xpath("//button [text()='Click Me']"));
    }

    public String getTextClickMeButton()    {
        return driver.findElement(By.xpath("//p [@id='dynamicClickMessage']")).getText().trim();
    }

    public void gotoButtonsItemElementsMenu() {
        click(By.xpath("//ul[@class='menu-list']//span [text()='Buttons']"));
    }
}
