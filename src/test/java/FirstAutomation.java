import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.By.cssSelector;

public class FirstAutomation {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    // Method to log in
    public void login() {
        driver.get("http://103.191.178.87:8080/crimson-admin-portal-staging/login");
        driver.findElement(By.id("username")).sendKeys("Tanim.Test");
        driver.findElement(By.id("password")).sendKeys("Redcash@#123456");
        driver.findElement(By.xpath("//*[@id='loginform']/div[3]/div[3]/button")).click();
    }

    @Test
    public void getTitle() {
        driver.get("http://103.191.178.87:8080/crimson-admin-portal-staging/login");
        String title_actual = driver.getTitle();
        String title_expected = "Red Cash - Login";
        System.out.println(title_actual);
        Assert.assertEquals(title_actual, title_expected);
    }

    @Test
    public void Redcash_signin() {
        login(); // Call the login method
    }

    @Test
    public void Bank_Cash_In() {
        login(); // Call the login method

        driver.findElement(By.xpath("/html/body/div/aside/div[1]/section/ul/li[4]/a")).click();
        driver.findElement(By.xpath("/html/body/div/aside/div[1]/section/ul/li[4]/ul/li[1]/a")).click();

        driver.findElement(By.className("select2-selection__rendered")).click();
        //Thread.sleep(2000); // Add a delay (pause) of 2 seconds
        driver.findElement(By.className("select2-search__field")).sendKeys("018331837111");
        //Thread.sleep(2000); // Add a delay (pause) of 2 seconds
        //driver.findElement(By.id("select2-Distributor_NAME-container")).click();
        //Thread.sleep(2000); // Add a delay (pause) of 2 seconds
        //driver.findElement(By.xpath("//span[contains(text(), '018331837111')]")).click();
        //Thread.sleep(2000); // Add a delay (pause) of 2 seconds

        driver.findElement(By.cssSelector("span[title='Select Distributor Wallet']")).click();











    }


    @After
    public void closeBrowser() {
        //driver.quit();
    }
}
