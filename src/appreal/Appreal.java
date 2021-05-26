package appreal;

import homepage.TopMenuTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class Appreal extends TopMenuTest {
    @Test
    public void verifyUserShouldNavigateToAccesoriesPageSuccessfully() throws InterruptedException {

        //Mouse Hover on “Appreal” Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/apparel']"));

        //Mouse Hover on "Accessories" and click
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHover(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[3]/a[1]"))).click().build().perform();
        //Verify the text “Accessories”
        Thread.sleep(1000);
        String expectedMessage = "Accessories";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Accessories')]"));
        Assert.assertEquals("Accesories not Match", expectedMessage, actualMessage);

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {


        //1 Click on "Register" tab
        Thread.sleep(1000);
        mouseHover(By.xpath("//a[contains(text(),'Register')]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        //2 Verify the text “Register”
        Thread.sleep(1000);
        String expectedMessage8 = "Register";
        String actualMessage8 = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Register page is not showing", expectedMessage8, actualMessage8);

        //3  Fill the mandatory fields
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Vrajesh");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Patel");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='Email']"), "vrajeshpatel" + randomInt + "@yahoo.com");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='Password']"), "Abcd1234");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Abcd1234");

        //4 Click on “REGISTER” Button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //5 Verify the message “Your registration completed”
        Thread.sleep(1000);
        String expectedMessage9 = "Your registration completed";
        String actualMessage9 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Registration Not Completed", expectedMessage9, actualMessage9);
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        this.verifyUserShouldNavigateToAccesoriesPageSuccessfully();

        //4 Click on List View Tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //5 Click on product name “Obey Propaganda Hat” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[text()='Obey Propaganda Hat']"));

        //6 Verify the text “Obey Propaganda Hat”
        Thread.sleep(1000);
        String expectedMessage1 = "Obey Propaganda Hat";
        String actualMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Obey Propaganda Hat')]"));
        Assert.assertEquals("This is Not Hat", expectedMessage1, actualMessage1);

        //7 Select the Size
        Thread.sleep(1000);
        selectByIndexFromDropDown(By.cssSelector("#product_attribute_13"), 3);

        //7 1 Click on “ADD TO CART” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-31' and @class='button-1 add-to-cart-button']"));

        //10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(1000);
        String expectedMessage3 = "The product has been added to your shopping cart";
        String actualMessage3 = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("Product not added", expectedMessage3, actualMessage3);

        //10 1 close the bar clicking on the cross button.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[@class='close']"));

        //11 Then MouseHover on "Shopping cart"
        Thread.sleep(1000);
        mouseHover(By.xpath("//span[text()='Shopping cart']"));

        //11 1 Click on "GO TO CART" button.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[text()='Go to cart']"));

        //12 Verify the message "Shopping cart"
        Thread.sleep(1000);
        String expectedMessage4 = "Shopping cart";
        String actualMessage4 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shopping cart not Match", expectedMessage4, actualMessage4);

        //13 Change the quantity and update the shopping cart
        clear(By.xpath("//tbody/tr[1]/td[5]/input[1]"));
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//tbody/tr[1]/td[5]/input[1]"), "5");
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[contains(text(),'Update shopping cart')]"));

        //14 Verify the Total $150.00
        Thread.sleep(1000);
        String expectedMessage6 = "$150.00";
        String actualMessage6 = getTextFromElement(By.xpath("//tbody/tr[1]/td[2]/span[1]"));
        Assert.assertEquals("Price is not Match", expectedMessage6, actualMessage6);

        //15 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //16 Click on “CHECKOUT”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //17 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
        String expectedMessage7 = "Welcome, Please Sign In!";
        String actualMessage7 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Welcome Message is not display", expectedMessage7, actualMessage7);

        //18 Enter as a Existing user
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='Email']"), "vrajeshpatel" + randomInt + "@yahoo.com");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='Password']"), "Abcd1234");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));


        //19 Click on “CHECKOUT”/ and accept terms and condition
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));


        //20 Fill the Mandatory fields
        Thread.sleep(1000);
        clearValue(By.xpath("//input[@id='BillingNewAddress_FirstName']"));
        clearValue(By.xpath("//input[@id='BillingNewAddress_LastName']"));
        clearValue(By.xpath("//input[@id='BillingNewAddress_Email']"));
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Vrajesh");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Patel");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "vrajeshpatel13583@yahoo.com");
        Thread.sleep(500);
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "233");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "12 Foxlees");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA0 2PR");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07535302262");

        //21 Click on “CONTINUE”
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 new-address-next-step-button']"));

        //22 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//label[contains(text(),'2nd Day Air ($0.00)')]"));

        //23 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //24 Select Radio Button “Credit Card”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));

        //25 Click on continue
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']//button[text()='Continue']"));

        //26 Select “Amex” From Select credit card dropdown
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//select[@id='CreditCardType']"), "4");

        //27 Fill all the details
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Vrajesh Patel");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "372861488602199");
        Thread.sleep(1000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "7");
        Thread.sleep(1000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2023");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "471");

        //28 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']//button[contains(text(),'Continue')]"));

        //29 Verify “Payment Method” is “Credit Card”
        Thread.sleep(1000);
        String expectedMessage11 = "Credit Card";
        String actualMessage11 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Credit card not match", expectedMessage11, actualMessage11);

        //30 Verify “Shipping Method” is “2nd Day Air”
        Thread.sleep(1000);
        String expectedMessage12 = "2nd Day Air";
        String actualMessage12 = getTextFromElement(By.xpath("//li[@class='shipping-method']//span[2]"));
        Assert.assertEquals("Shipping method not correct", expectedMessage12, actualMessage12);


        //31 Verify Total is “$150.00”
        Thread.sleep(1000);
        String expectedMessage13 = "$150.00";
        String actualMessage13 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[text()='$150.00']"));
        Assert.assertEquals("Total not Match", expectedMessage13, actualMessage13);

        //32 Click on “CONFIRM”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //33 Verify the Text “Thank You”
        Thread.sleep(500);
        String expectedMessage14 = "Thank you";
        String actualMessage14 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Message is not Match", expectedMessage14, actualMessage14);

        //34 Verify the message “Your order has been successfully processed!”
        Thread.sleep(500);
        String expectedMessage15 = "Your order has been successfully processed!";
        String actualMessage15 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Thankful message is not Match", expectedMessage15, actualMessage15);

        //35 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //36 Verify the text “Welcome to our store”
        Thread.sleep(500);
        String expectedMessage16 = "Welcome to our store";
        String actualMessage16 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Promising message appear not Sucessfully", expectedMessage16, actualMessage16);

        //37 Click on “Logout” link
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //38 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = getUrl();
        Assert.assertEquals("Url is NotMatch", expectedUrl, actualUrl);


    }


}
