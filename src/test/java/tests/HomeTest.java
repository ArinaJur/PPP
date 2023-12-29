package tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomeTest extends BaseTest {

    @Test
    public void testLoginNavigation() {

        assertThat(getPage()).hasURL("https://study.traineracademy.org/home");
        assertThat(getPage()).hasTitle("Trainer Academy");
    }

    @DataProvider
    public Object[][] sideMenuItems() {
        return new Object[][]{
                {"Home", "https://study.traineracademy.org/home"},
                {"Study guide", "https://study.traineracademy.org/study-guide"},
                {"Tests", "https://study.traineracademy.org/test-list"},
                {"Flashcards", "https://study.traineracademy.org/flashcard-packs"},
                {"Mnemonic cards", "https://study.traineracademy.org/mnemoniccard-list"},
                {"Performance", "https://study.traineracademy.org/performance"},
                {"Profile", "https://study.traineracademy.org/profile"}
        };
    }

    @Test(dataProvider = "sideMenuItems")
    public void testNavigateToSubMenuItems(String locator, String expectedUrl) {
        getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(locator)).click();

        assertThat(getPage()).hasURL(expectedUrl);
    }

    @Test
    public void testLocators() {
        HomePage homePage = new HomePage(getPage(), getPlaywright());
        assertThat(homePage.studyThisButton).isVisible();
        homePage.studyThisButton.click();

    }

}
