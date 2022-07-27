package PageObjects;

/**
 * Created by Thomas on 2016-06-15.
 */
public interface ContactSearchPage {

    void search(String name);

    void assertSearchResult(String expectedResult);

    void navigateToSearchResultDetails();

    boolean waitDisplayed();

    void assertSearchResultNotification(String expectedResultNotification);
}
