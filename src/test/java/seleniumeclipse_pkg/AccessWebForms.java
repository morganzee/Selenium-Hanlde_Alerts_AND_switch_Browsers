package seleniumeclipse_pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AccessWebForms {

    static WebDriver driver;
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\morgan.nwaiku\\Downloads\\app\\web Drivers\\chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        //get page title
        String title = driver.getTitle();
        System.out.println(title);

                     //click on Register
        driver.findElement(By.linkText("Register")).click();
                     //select 'male'
        driver.findElement(By.id("gender-male")).click();
                    //Enter firstname
        driver.findElement(By.id("FirstName")).sendKeys("Morgan");
                    //Enter lastname
        driver.findElement(By.id("LastName")).sendKeys("Zee");
                    //Enter date of birth
        Select select = new Select(driver.findElement(By.name("DateOfBirthDay")));
            select.selectByVisibleText("12");
                    //Enter month of birth
        select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
            select.selectByValue("7");
                    //Enter year of birth
        select = new Select(driver.findElement(By.name("DateOfBirthYear")));
            select.selectByVisibleText("1930");
                     //Enter email address
        driver.findElement(By.id("Email")).sendKeys("morgannwaiku@gmail.com");
                    // close browser
        driver.quit();

    }
}
