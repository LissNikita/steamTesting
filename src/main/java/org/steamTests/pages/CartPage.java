package org.steamTests.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.steamTests.utils.WaitUtils;

@Log4j2
public class CartPage {

    private final String productName = "прайм-статус";
    private final String productPrice = "$14.99";

    private WebDriver driver;

    @FindBy(id = "account_pulldown")
    private WebElement buttonOfYourProfile;

    @FindBy(xpath = "//a[@href='javascript:Logout();']")
    private WebElement buttonLogOut;

    private WebElement nameOfProduct;

    private WebElement priceOfProduct;


    public WebElement setPriceOfProduct(String valueOfPrice) {
        return priceOfProduct = driver.findElement(By.xpath("//div[contains(text(), '" + valueOfPrice + "')][1]"));
    }

    public WebElement setNameOfProduct(String productName) {
        return nameOfProduct = driver.findElement(By.xpath("//a[contains(text(), '" + productName + "')]"));
    }

    private String productNameForCompare;
    private String priceValueOfProductForCompare;

    public String getPriceValueOfProduct() {
        return priceValueOfProductForCompare;
    }

    public String productName() {
        return productNameForCompare;
    }

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getNameOfProduct() {
        log.info("Get name of product in cart");
        WaitUtils.waitForVisibility(setNameOfProduct(productName));
        return productNameForCompare = nameOfProduct.getText();
    }

    public String getPrice() {
        log.info("Get price of product in cart");
        WaitUtils.waitForVisibility(setPriceOfProduct(productPrice));
        return priceValueOfProductForCompare = priceOfProduct.getText();
    }

    public void clickOnProfileButton() {
        log.info("Click on profile button");
        WaitUtils.waitForClickable(buttonOfYourProfile);
        buttonOfYourProfile.click();
    }

    public void clickLogOut() {
        log.info("Click on logOut button");
        WaitUtils.waitForClickable(buttonLogOut);
        buttonLogOut.click();
    }
}
