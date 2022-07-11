package cc.robotdreams.my.hw.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Используя Selenium WebDriver
 *
 * Напишите тест, который открывает страницу https://demoqa.com/elements, нажимаеи на Buttons,
 * кликает кнопку Click Me, считает и выводит в консоль текст появившегося сообщения.
 *
 * Напишите тест, который открывает страницу https://demoqa.com/webtables,
 * нажимает кноку ADD, заполняет форму добавления, проверяет что запись добавилась,
 * редактирует запись через функцию редактирования.
 */

public class testDemoElements extends TestBase {

    @Test
    public void testElementsButtonsItem() {
        app.getNavigationHelper().gotoElementsSection();
        app.getButtonsHelper().gotoButtonsItemElementsMenu();
        app.getButtonsHelper().clickToClickMeButton();
        Assert.assertEquals(app.getButtonsHelper().getTextClickMeButton(),"You have done a dynamic click");
        System.out.println("After clicking on 'Click Me' button follow test appears: " + app.getButtonsHelper().getTextClickMeButton());
        app.getNavigationHelper().gotoMainPage();
    }

    @Test
    public void testElementsWebTablesItem() {
        app.getNavigationHelper().gotoElementsSection();
        app.getWebTableHelper().gotoWebTablesItemElementsMenu();
        int recordNumBefore = app.getWebTableHelper().recordCounter();
        app.getWebTableHelper().addNewRecord();
        app.getWebTableHelper().fillRegistrationForm(app.getWebTableHelper().registrationFormData);
        app.getWebTableHelper().submitRegistrationForm();
        int recordNumAfter = app.getWebTableHelper().recordCounter();
        Assert.assertEquals(recordNumAfter, recordNumBefore + 1);
        String firstName = app.getWebTableHelper().findRecord(app.getWebTableHelper().registrationFormData);
        Assert.assertEquals(firstName, app.getWebTableHelper().registrationFormData.getFirstName());
        app.getWebTableHelper().editRecord();
        firstName = app.getWebTableHelper().findRecord(app.getWebTableHelper().changedRegistrationFormData);
        Assert.assertEquals(firstName, app.getWebTableHelper().changedRegistrationFormData.getFirstName());
        app.getNavigationHelper().gotoMainPage();
    }
}
