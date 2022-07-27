package StepDefinitions;

import AppiumSupport.AppiumBaseClass;
import AppiumSupport.AppiumController;
import PageObjects.ContactDetailPage;
import PageObjects.ContactDetailPageAndroid;
import PageObjects.ContactSearchPage;
import PageObjects.ContactSearchPageAndroid;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinitions extends AppiumBaseClass {
    public ContactSearchPage searchPage;
    public ContactDetailPage detailPage;

    @Before
    public void setUp() throws Exception {
        AppiumController.instance.start();
        switch (AppiumController.executionOS) {
            case ANDROID:
            case ANDROID_BROWSERSTACK:
                searchPage = new ContactSearchPageAndroid(driver());
                detailPage = new ContactDetailPageAndroid(driver());
                break;
            case IOS:
            case IOS_BROWSERSTACK:
        }
    }

    @After
    public void tearDown() {
        AppiumController.instance.stop();
    }

    @Given("Search page is displayed")
    public void searchPageIsDisplayed() {
        Assert.assertTrue(searchPage.waitDisplayed());
    }

    @When("I search for {string}")
    public void iSearchFor(String firstName) {
        searchPage.search(firstName);
    }

    @Then("I see {string} in search result")
    public void iSeeInSearchResult(String fullName) {
        searchPage.assertSearchResult(fullName);
    }

    @Then("I see {string} under screen")
    public void iSeeResultNotificationUnderScreen(String resultNotification) {
        searchPage.assertSearchResultNotification(resultNotification);
    }

    @And("I click on contact in search result")
    public void iClickOnFirstName() {
        searchPage.navigateToSearchResultDetails();
    }

    @Then("I see full name {string} is correct")
    public void iSeeFullNameIsCorrect(String fullName) {
        detailPage.assertContactName(fullName);
    }

    @Then("I see contact phone {string} is correct")
    public void iSeeContactPhoneIsCorrect(String contactPhone) {
        detailPage.assertContactPhone(contactPhone);
    }
}