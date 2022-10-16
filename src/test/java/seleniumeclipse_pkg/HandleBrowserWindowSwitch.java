package seleniumeclipse_pkg;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindowSwitch {

    public static WebDriver driver;

    public static void main (String[] args) throws InterruptedException {
         String browser = "Chrome";

        if (browser.toUpperCase().equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\morgan.nwaiku\\Downloads\\app\\web Drivers\\chrome driver\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browser.toUpperCase().equals("EDGE")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\morgan.nwaiku\\Downloads\\app\\web Drivers\\Edge driver\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
                    //Url of the application
            driver.get("https://demo.automationtesting.in/Windows.html");
            driver.manage().window().maximize();

            driver.findElement(By.xpath("//a[text()='Open New Seperate Windows']")).click();
                    // This would help us fall back to our parent window.
            String parentwindowHandle = driver.getWindowHandle();
            System.out.println("Parent browser Title: " + driver.getTitle() );

            driver.findElement(By.xpath("//button[text()='click']")).click();

            String popupwindowHandle = null;
                    //This means that if your handle is not a parent window then it's a child window
            for ( String handle : driver.getWindowHandles()) {
                if (!handle.equals(parentwindowHandle)) {
                    popupwindowHandle = handle;
                }
            }
            driver.switchTo().window(popupwindowHandle);
                    // Fetch child window title.
            System.out.println("Child browser Title: " + driver.getTitle() );
                    // close child browser window
            driver.close();
                    //switch to parent window
            driver.switchTo().window(parentwindowHandle);
                     // Fetch parent window title.
            String browsertitle = driver.getTitle();
            System.out.println("Parent browser page title: " + browsertitle);


            driver.quit();

    }
}
