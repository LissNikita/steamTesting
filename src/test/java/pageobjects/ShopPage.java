package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage {

    private WebDriver driver ;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement sliderWithNewGames;

    public WebDriverWait creatNewWebDriverWaitElement(){
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean checkShopPageIsOpened(){
        sliderWithNewGames = (creatNewWebDriverWaitElement())
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'home_cluster_ctn home_ctn']")));
        return sliderWithNewGames.isDisplayed();
    }
}
