package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class Utility {
    public WebDriver driver;

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void selectByValueFromDropDown(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);

    }

    public void selectByIndex(By by, int value) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(value);
    }

    public WebElement mouseHover(By by) {
        Actions actions = new Actions(driver);
        WebElement move = driver.findElement(by);
        actions.moveToElement(move).perform();
        return move;
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void sendTextToElement(By by, int num) {
        driver.findElement(by).sendKeys();
    }

    public void clearValue(By by) {
        driver.findElement(by).clear();
    }

    public String getUrl() {
        String actualUrl = driver.getCurrentUrl();
        return actualUrl;
    }

    public Random randomGenerator = new Random();
    public int randomInt = randomGenerator.nextInt(1000);

    public <BY, attribute> String getAttributefromelement(By by, String value){
        return driver.findElement(by).getAttribute("value");
    }
    public void selectByIndexFromDropDown(By by, int value) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(value);

    }
    public void selectByVisibleTextFromDRopDown(By by, int value){
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(value);
    }
    public void clear(By by) {
        driver.findElement(by).clear();
    }

}

