package homepage;

import browsertesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {

        clickOnElement(By.linkText("Computers"));
        clickOnElement(By.linkText("Electronics"));
        clickOnElement(By.linkText("Apparel"));
        clickOnElement(By.linkText("Digital downloads"));
        clickOnElement(By.linkText("Books"));
        clickOnElement(By.linkText("Jewelry"));
        clickOnElement(By.linkText("Gift Cards"));
    }

    @Test
    public void verifyPageNavigation() throws InterruptedException {
        selectMenu("Computers");
        Thread.sleep(1000);
        String expectedmessage = "Computers";
        Thread.sleep(1000);
        String actualmessage = getTextFromElement(By.partialLinkText("Computers"));
        Assert.assertEquals("text did not match", expectedmessage, actualmessage);

    }

    @Test
    public void verifyPageElectronicsNavigation() throws InterruptedException {
        selectMenu("Electronics");
        Thread.sleep(1000);
        String expectedMessage1 = "Electronics";
        Thread.sleep(1000);
        String actualMessage1 = getTextFromElement(By.partialLinkText("Electronics"));
        Assert.assertEquals("User not Navigate to Page + ", expectedMessage1, actualMessage1);
    }

    @Test
    public void verifyPageApparelNavigation() throws InterruptedException {
        selectMenu("Apparel");
        Thread.sleep(1000);
        String expectedMessage = "Apparel";
        Thread.sleep(1000);
        String actualMessage = getTextFromElement(By.partialLinkText("Apparel"));
        Assert.assertEquals("User not Navigate to Page+", expectedMessage, actualMessage);
    }

    @Test
    public void verifyPageDigitalDownloadsNavigation() throws InterruptedException {
        selectMenu("Digital downloads");
        Thread.sleep(1000);
        String expectedMessage = "Digital downloads";
        Thread.sleep(1000);
        String actualMessage = getTextFromElement(By.partialLinkText("Digital downloads"));
        Assert.assertEquals("User not Navigate to Page+", expectedMessage, actualMessage);
    }

    @Test
    public void verifyPageBooksNavigation() throws InterruptedException {
        selectMenu("Books");
        Thread.sleep(1000);
        String expectedMessage = "Books";
        Thread.sleep(1000);
        String actualMessage = getTextFromElement(By.partialLinkText("Books"));
        Assert.assertEquals("User not Navigate to Page+", expectedMessage, actualMessage);
    }

    @Test
    public void verifyPageJewelryNavigation() throws InterruptedException {
        selectMenu("Jewelry");
        Thread.sleep(1000);
        String expectedMessage = "Jewelry";
        Thread.sleep(1000);
        String actualMessage = getTextFromElement(By.partialLinkText("Jewelry"));
        Assert.assertEquals("User not Navigate to Page+", expectedMessage, actualMessage);
    }

    @Test
    public void verifyPageGiftCardsNavigation() throws InterruptedException {
        selectMenu("Gift Cards");
        Thread.sleep(1000);
        String expectedMessage = "Gift Cards";
        Thread.sleep(1000);
        String actualMessage = getTextFromElement(By.partialLinkText("Gift Cards"));
        Assert.assertEquals("User not Navigate to Page+", expectedMessage, actualMessage);
    }

          @After
        public void tearUp(){
         closeBrowser();

}

}
