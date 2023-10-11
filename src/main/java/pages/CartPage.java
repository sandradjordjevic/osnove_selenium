package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasicPage{
    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public int getTheNumberOfItemsInTheCart () {
        List<WebElement> items = driver.findElements(By.cssSelector(".cart_list .cart_item"));
        return items.size();
    }
    public String getNumberInSpan () {
        return driver.findElement(By.className("shopping_cart_badge")).getText();
    }
    public boolean areTheItemsAdded () {
        return elementExists(By.className("cart_item"));
    }
    public boolean doesnItemTitleIsPresented () {
        By by = By.cssSelector("#item_4_title_link .inventory_item_name");
        return elementExists(by);
    }
    public boolean doesnItemDescriptionIsPresented () {
        By by = By.cssSelector(".cart_item .inventory_item_desc");
        return elementExists(by);
    }

}
