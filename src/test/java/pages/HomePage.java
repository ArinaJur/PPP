package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HomePage extends BaseLocator {
    public Locator studyThisButton = button("Study This");



    // 1. String Locators:

    // 2. page constructor:

    // 3. page actions/methods:

    public HomePage(Page page, Playwright playwright) {
        super(page, playwright);
    }


}
