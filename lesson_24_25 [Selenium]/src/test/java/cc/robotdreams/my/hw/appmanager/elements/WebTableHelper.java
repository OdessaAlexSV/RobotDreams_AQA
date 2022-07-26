package cc.robotdreams.my.hw.appmanager.elements;

import cc.robotdreams.my.hw.appmanager.HelperBase;
import cc.robotdreams.my.hw.model.RegistrationFormData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asvidersky on 7/11/2022.
 */

public class WebTableHelper extends HelperBase {
    public RegistrationFormData registrationFormData = new RegistrationFormData("John", "Snow",
            "foo@test.com", "25", "1000", "Accountant");
    public RegistrationFormData changedRegistrationFormData = new RegistrationFormData("NewJohn", "NewSnow",
            "newfoo@test.com", "50", "500", "Sales");

    public WebTableHelper(WebDriver driver) {
        super(driver);
    }

    public void editRecord() {
        click(By.xpath("//div [@class='action-buttons']//span[@title='Edit']"));
        fillRegistrationForm(changedRegistrationFormData);
        submitRegistrationForm();
    }

    public String findRecord(RegistrationFormData registerFormData) {
        type(By.xpath("//input[@id='searchBox']"), registerFormData.getFirstName());
        return driver.findElement(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group'][1]//div[@role='gridcell'][1]")).getText().trim();
    }

    public int recordCounter() {
        String firstName;
        List<String> listFirstName = new ArrayList<String>();
        int xpathCount = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']")).size();
        for (int i = 1; i <= xpathCount; i++) {
            firstName = driver.findElement(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group'][" + i + "]//div[@role='gridcell'][1]")).getText().trim();
            if (!firstName.isEmpty()) {
                listFirstName.add(firstName);
            } else {
                i = xpathCount;
            }
        }
        return listFirstName.size();
    }

    public void submitRegistrationForm() {
        click(By.id("submit"));
    }

    public void fillRegistrationForm(RegistrationFormData registerFormData) {
        type(By.xpath("//input[@id='firstName']"), registerFormData.getFirstName());
        type(By.xpath("//input[@id='lastName']"), registerFormData.getLastName());
        type(By.xpath("//input[@id='userEmail']"), registerFormData.getEmail());
        type(By.xpath("//input[@id='age']"), registerFormData.getAge());
        type(By.xpath("//input[@id='salary']"), registerFormData.getSalary());
        type(By.xpath("//input[@id='department']"), registerFormData.getDepartment());
    }

    public void addNewRecord() {
        click(By.xpath("//div [@class='web-tables-wrapper']//button [text()='Add']"));
    }

    public void gotoWebTablesItemElementsMenu() {
        click(By.xpath("//ul[@class='menu-list']//span [text()='Web Tables']"));
    }
}