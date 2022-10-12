package seleniumeclipse_pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstWebDriverProgram {

     static WebDriver driver;
public static void main(String[] args){

    System.setProperty("webdriver.chrome.driver","C:\\Users\\morgan.nwaiku\\Downloads\\app\\web Drivers\\chrome driver\\chromedriver.exe");
    driver = new ChromeDriver();

    driver.get("https://www.google.com");
    driver.manage().window().maximize();
    //get page title
    String title = driver.getTitle();
    System.out.println(title);


    }
}
