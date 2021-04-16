package Model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestModel {
    public static WebDriver driver;

    public TestModel(WebDriver webDriver) {
        driver = webDriver;

    }

    public WebElement txtEmail() {
        return driver.findElement(By.id("L-UserNameField"));
    }
    public WebElement txtPassword() { return driver.findElement(By.id("L-PasswordField")); }
    public WebElement btnLogin() {
        return driver.findElement(By.id("gg-login-enter"));
    }
    public WebElement search() {
        return driver.findElement(By.name("k"));
    }
    public WebElement searchButton(){
        return driver.findElement(By.cssSelector(".hKfdXF"));
    }
    public WebElement secondPage(){
        return driver.findElement(By.xpath("//a[@href='/arama/?k=bilgisayar&sf=2']"));
    }
    public WebElement seeDetail(){
        return driver.findElement(By.xpath("//li[@product-index='2']"));
    }
    public WebElement addBasket(){
        return driver.findElement(By.id("add-to-basket"));
    }
    public WebElement price(){
        return driver.findElement(By.id("sp-price-discountPrice"));
    }
    public WebElement basketPrice(){
        return driver.findElement(By.className("new-price"));
    }
    public WebElement delete(){
        return driver.findElement(By.xpath("//*[@class='btn-delete btn-update-item']"));
    }
    public WebElement increaseAmount(){
        return driver.findElement(By.xpath("//*[@class='amount']"));
    }


}
