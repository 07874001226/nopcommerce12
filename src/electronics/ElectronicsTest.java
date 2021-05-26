package electronics;

import homepage.TopMenuTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class ElectronicsTest extends TopMenuTest {

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {

        // Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));

        //Mouse Hover on “Cell phones” and click
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHover(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"))).click().build().perform();

        //Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Cell Phone is not Match", expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        this.verifyUserShouldNavigateToCellPhonesPageSuccessfully();

        //4 Click on List View Tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));

        //6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(1000);
        String expectedMessage1 = "Nokia Lumia 1020";
        String actualMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("This is Not Lumia 1020", expectedMessage1, actualMessage1);

        //7 Verify the price “$349.00”
        Thread.sleep(1000);
        String expectedMessage2 = "$349.00";
        String actualMessage2 = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals("This is Not Match", expectedMessage2, actualMessage2);

        //7 1 Clear the value
        Thread.sleep(1000);
        clearValue(By.xpath("//input[@id='product_enteredQuantity_20']"));

        //8 Change quantity to 2
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        //9 Click on “ADD TO CART” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(1000);
        String expectedMessage3 = "The product has been added to your shopping cart";
        String actualMessage3 = getTextFromElement(By.xpath("//p[text()='The product has been added to your ']"));
        Assert.assertEquals("Product not added", expectedMessage3, actualMessage3);

        //10 1 close the bar clicking on the cross button.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[@class='close']"));

        //11 MouseHover on "Shopping cart"
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

        //13Verify the quantity is 2
        Thread.sleep(1000);
        String expectedMessage5 = "2";
        String actualMessage5 = getAttributefromelement(By.xpath("//tbody/tr[1]/td[5]/input[1]"),"value");
        Assert.assertEquals("not purchased", expectedMessage5, actualMessage5);

        //14 Verify the Total $698.00
        Thread.sleep(1000);
        String expectedMessage6 = "$698.00";
        String actualMessage6 = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]"));
        Assert.assertEquals("Price not Match", expectedMessage6, actualMessage6);

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

        //18 Click on “REGISTER” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //19 Verify the text “Register”
        Thread.sleep(1000);
        String expectedMessage8 = "Register";
        String actualMessage8 = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Register page is not showing", expectedMessage8, actualMessage8);

        //20  Fill the mandatory fields
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

        //21 Click on “REGISTER” Button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //22 Verify the message “Your registration completed”
        Thread.sleep(1000);
        String expectedMessage9 = "Your registration completed";
        String actualMessage9 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Registration Not Completed", expectedMessage9, actualMessage9);

        //23 Click on “CONTINUE” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //24 Verify the text “Shopping card”
        Thread.sleep(1000);
        String expectedmessage10 = "Shopping cart";
        String actualmessage10 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shopping cart is empty", expectedmessage10, actualmessage10);


        //25 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //26 Click on “CHECKOUT”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //27 Fill the Mandatory fields
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
        Thread.sleep(500);

        //28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 new-address-next-step-button']"));
        Thread.sleep(1000);

        //29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//label[contains(text(),'2nd Day Air ($0.00)')]"));

        //30 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //31 Select Radio Button “Credit Card”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));

        //31 1 Click on continue
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']//button[text()='Continue']"));

        //32 Select “Visa” From Select credit card dropdown
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//select[@id='CreditCardType']"), "1");

        //33 Fill all the details
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Vrajesh Patel");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "4916360129110618");
        Thread.sleep(1000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "6");
        Thread.sleep(1000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2026");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "671");

        //34 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']//button[contains(text(),'Continue')]"));

        //35 Verify “Payment Method” is “Credit Card”
        Thread.sleep(1000);
        String expectedMessage11 = "Credit Card";
        String actualMessage11 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Credit card not match", expectedMessage11, actualMessage11);

        //36 Verify “Shipping Method” is “2nd Day Air”
       Thread.sleep(1000);
        String expectedMessage12 = "2nd Day Air";
        String actualMessage12 = getTextFromElement(By.xpath("//li[@class='shipping-method']//span[2]"));
        Assert.assertEquals("Shipping method not correct", expectedMessage12, actualMessage12);


        //37 Verify Total is “$698.00”
        Thread.sleep(1000);
        String expectedMessage13 = "$698.00";
        String actualMessage13 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[text()='$698.00']"));
        Assert.assertEquals("Total not Match", expectedMessage13, actualMessage13);

        //38 Click on “CONFIRM”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //39 Verify the Text “Thank You”
        Thread.sleep(500);
        String expectedMessage14 = "Thank you";
        String actualMessage14 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Message is not Match", expectedMessage14, actualMessage14);

        //40 Verify the message “Your order has been successfully processed!”
        Thread.sleep(500);
        String expectedMessage15 = "Your order has been successfully processed!";
        String actualMessage15 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Thankful message is not Match", expectedMessage15, actualMessage15);

        //41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //42 Verify the text “Welcome to our store”
        Thread.sleep(500);
        String expectedMessage16 = "Welcome to our store";
        String actualMessage16 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Promising message appear not Sucessfully", expectedMessage16, actualMessage16);

        //43 Click on “Logout” link
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));


        //44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = getUrl();
        Assert.assertEquals("Url is NotMatch",expectedUrl,actualUrl);











    }


}
