package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Product_Page {


    WebDriver driver;

    @FindBy(className = "shopping_cart_link")
    public WebElement shopping_cart_icon;

    @FindBy(id = "checkout")
    public WebElement checkout_btn;

    @FindBy(id = "first-name")
    public WebElement firstname;

    @FindBy(id = "last-name")
    public WebElement lastname;

    @FindBy(id = "postal-code")
    public WebElement postalcode;

    @FindBy(id = "continue")
    public  WebElement cont_btn;

    @FindBy(id = "finish")
    public  WebElement finish_btn;


    @FindBy(xpath = "//h2[contains(text(),'Thank you for your order!')]")
    public WebElement order_header;


    public void sorting_highest_product(){

        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        List<WebElement>  addtocart = driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));

        double maxPrice = 0.0;
        int maxPriceIndex = -1;

        for (int i = 0; i < prices.size(); i++) {

            double price = Double.parseDouble(prices.get(i).getText().replace("$", ""));

            if (price > maxPrice) {
                maxPrice = price;
                maxPriceIndex = i;
            }
        }

        if (maxPriceIndex != -1) {
            addtocart.get(maxPriceIndex).click();
            System.out.println("Added the highest priced item: $" + maxPrice);
        }

    }




    public Product_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
