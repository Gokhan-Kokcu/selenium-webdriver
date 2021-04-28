import Model.TestModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log4j;

public class pageTest {
    public WebDriver driver;
    JavascriptExecutor jse;
    Actions action;
    public static TestModel testModelPage;
    protected static String url = "https://www.gittigidiyor.com/";
    public static String email = "Enter Mail";
    public static String userPassword = "Enter Pass";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        testModelPage = new TestModel(driver);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }


    @Test
    public void testing() {
        Log4j.startLog();
        driver.get(url);
        Log4j.info("Opening Page : " + url);
        driver.get(url + "uye-girisi");
        Log4j.info("Login Page : " + url + "uye-girisi");

        testModelPage.txtEmail().clear();
        testModelPage.txtEmail().sendKeys(email);
        Log4j.info("Email : " + email);

        testModelPage.txtPassword().clear();
        testModelPage.txtPassword().sendKeys(userPassword);
        Log4j.info("Password : " + userPassword);
        testModelPage.btnLogin().click();
        Log4j.info("Logged in successfull");

        testModelPage.search().clear();
        testModelPage.search().sendKeys("bilgisayar");
        Log4j.info("Searching");

        testModelPage.searchButton().click();

        Log4j.info("Searched successfull ");

        jse.executeScript("arguments[0].scrollIntoView()", testModelPage.secondPage());
        testModelPage.secondPage().click();
        Log4j.info("Go to 2nd page");

        testModelPage.seeDetail().click();

        Log4j.info("Go to product detail");

        jse.executeScript("arguments[0].scrollIntoView()", testModelPage.addBasket());
        testModelPage.addBasket().click();

        Log4j.info("Added basket successfull");

        String price = testModelPage.price().getText();

        Log4j.info("product detail price: " + price);

        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get(url + "sepetim");

        Log4j.info("Go to basket: " + url + "sepetim");

        String basketPrice = testModelPage.basketPrice().getText();

        Log4j.info("Basket detail price: " + price);

        if (price.equals(basketPrice)) {
            Log4j.info("Prices are equal");
        }

        Select amount = new Select(testModelPage.increaseAmount());
        amount.selectByVisibleText("2");
        amount.selectByValue("2");
        Log4j.info("Increase amount");

        testModelPage.delete().click();
        Log4j.info("Delete product");

    }


    @After
    public void tearDown() {
        Log4j.endLog();
        driver.quit();
    }
}
