import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Login_Page;
import pages.Product_Page;

import java.util.List;

public class MyStepdefs {

    WebDriver driver;

    Login_Page login_page;
    Product_Page product_page;

    @Before
    public void start(){
    driver = TestRunner.driver;
    login_page=new Login_Page(driver);
    product_page=new Product_Page(driver);
    }
    @Given("User navigates to the application")
    public void userNavigatesToTheApplication() {
        String acttitle = driver.getTitle();
        String exptitle = "Swag Labs";
        Assert.assertEquals(exptitle,acttitle);

    }

    @And("User logins with {string} and {string}")
    public void userLoginsWithAnd(String id, String pwd) {
            login_page.userid.sendKeys(id);
            login_page.pwd.sendKeys(pwd);
            login_page.login_btn.click();

    }

    @Then("Select the highest value product to add to cart")
    public void selectTheHighestValueProductToAddToCart() {

        product_page.sorting_highest_product();

    }

    @Then("User navigates to the checkout page to complete transaction")
    public void userNavigatesToTheCheckoutPageToCompleteTransaction() {
        product_page.shopping_cart_icon.click();
        product_page.checkout_btn.click();
        product_page.firstname.sendKeys("data1");
        product_page.lastname.sendKeys("datalastname");
        product_page.postalcode.sendKeys("EC4");
        product_page.cont_btn.click();
        product_page.finish_btn.click();
    }

    @Then("Order confirmation is displayed")
    public void orderConfirmationIsDisplayed() {

        String ordermsg = product_page.order_header.getText();
        String expordermsg = "Thank you for your order!";
        Assert.assertEquals(expordermsg,ordermsg);
    }
}
