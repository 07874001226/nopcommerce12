package computer;

import homepage.TopMenuTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestSuite extends TopMenuTest {
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        clickOnElement(By.linkText("Computers"));
        Thread.sleep(1000);
        clickOnElement(By.linkText("Desktops"));
        selectByIndex(By.xpath("//select[@id='products-orderby']"), 2);
        String expectedmessage = "Name: Z to A";
        String actualmessage = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals("text did not match", expectedmessage, actualmessage);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        //Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));
        Thread.sleep(1000);

        //Click on Desktop
        clickOnElement(By.linkText("Desktops"));

        //Select Sort By position "Name: A to Z"
        selectByIndex(By.xpath("//select[@id='products-orderby']"), 1);
        Thread.sleep(1000);

        //Click on "Add To Cart"
        clickOnElement(By.xpath("//div[@class='item-box'][1]//button[text()='Add to cart']"));

        //Verify the Text "Build your own computer"
        String expectedmessage = "Build your own computer";
        Thread.sleep(1000);
        String actualmessage = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("text did not match", expectedmessage, actualmessage);
        Thread.sleep(1000);

        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByIndex(By.xpath("//select[@id='product_attribute_1']"), 1);
        Thread.sleep(1000);

        //Select "8GB [+$60.00]" using Select class.
        selectByIndex(By.xpath("//select[@id='product_attribute_2']"), 3);
        Thread.sleep(1000);

        //Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//dd[@id='product_attribute_input_3']//label[text()='400 GB [+$100.00]']"));
        Thread.sleep(1000);

        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        Thread.sleep(1000);

        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        clickOnElement(By.xpath("//input[@name='product_attribute_5' and @id='product_attribute_5_12']"));

        //Verify the price "$1,475.00"
        String expectedMessage = "$1,475.00";
        String actualMessage = getTextFromElement(By.xpath("//span[text()='$1,475.00']"));
        Assert.assertEquals("Price did not Match", expectedMessage, actualMessage);

        //Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        Thread.sleep(1000);

        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage1 = "The product has been added to your shopping cart";
        String actualMessage1 = getTextFromElement(By.xpath("//p[text()='The product has been added to your ']"));
        Assert.assertEquals("Product not added", expectedMessage1, actualMessage1);

        //Close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));

        //Then MouseHover on "Shopping cart"
        mouseHover(By.xpath("//span[text()='Shopping cart']"));

        //Click on "GO TO CART" button.
        clickOnElement(By.xpath("//button[text()='Go to cart']"));

        //Verify the message "Shopping cart"
        String expectedMessage2 = "Shopping cart";
        String actualMessage2 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shopping cart not Match", expectedMessage2, actualMessage2);
        Thread.sleep(1000);

        //Clear the value
        clearValue(By.xpath("//input[@class='qty-input']"));
        Thread.sleep(1000);
        //Change the Qty to "2"
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");

        //Click on "Update shopping cart"
        clickOnElement(By.xpath("//button[contains(text(),'Update shopping cart')]"));
        Thread.sleep(1000);

        //Verify the Total"$2,950.00"
        String expectedMessage3 = "$2,950.00";
        String actulaMessage3 = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong"));
        Assert.assertEquals("Price not Match", expectedMessage, actualMessage);
        Thread.sleep(1000);

        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);

        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(500);

        //Verify the Text “Welcome, Please Sign In!”
        String expectedMessage4 = "Welcome, Please Sign In!";
        String actualMessage4 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Sign in not match", expectedMessage4, actualMessage4);
        Thread.sleep(500);

        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        Thread.sleep(500);

        //Fill the all mandatory field
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

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 new-address-next-step-button']"));
        Thread.sleep(500);

        //Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        Thread.sleep(1000);

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(1000);

        //Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(1000);

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 payment-method-next-step-button']"));
        Thread.sleep(1000);


        //Select “Master card” From Select credit card dropdown
        selectByIndex(By.xpath("//select[@id='CreditCardType']"), 1);
        Thread.sleep(1000);
        //Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Vrajesh Patel");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5391365024451901");
        Thread.sleep(1000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "10");
        Thread.sleep(1000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2023");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "394");
        Thread.sleep(1000);

        //Click on “CONTINUE
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(1000);

        //Verify “Payment Method” is “Credit Card”
        String expectedMessage5 = "Credit Card";
        String actualMessage5 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Payment is not Credit Card", expectedMessage5, actualMessage5);
        Thread.sleep(500);

        //Verify “Shipping Method” is “Next Day Air”
        String expectedMessage6 = "Next Day Air";
        String actualMessage6 = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        Assert.assertEquals("Shipping is not Match", expectedMessage6, actualMessage6);
        Thread.sleep(500);

        //Verify Total is “$2,950.00”
        String expectedMessage7 = "$2,950.00";
        String actualMessage7 = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong"));
        Assert.assertEquals("Total Price is not Match", expectedMessage7, actualMessage7);
        Thread.sleep(500);

        //Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //Verify the Text “Thank You”
        String expectedMessage8 = "Thank you";
        String actualMessage8 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Message is not Match", expectedMessage8, actualMessage8);
        Thread.sleep(500);

        //Verify the message “Your order has been successfully processed!”
        String expectedMessage9 = "Your order has been successfully processed!";
        String actualMessage9 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Thankful message is not Match", expectedMessage9, actualMessage9);
        Thread.sleep(500);

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //Verify the text “Welcome to our store”
        String expectedMessage10 = "Welcome to our store";
        String actualMessage10 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Promising message appear not Sucessfully", expectedMessage10, actualMessage10);
        Thread.sleep(500);

    }
}