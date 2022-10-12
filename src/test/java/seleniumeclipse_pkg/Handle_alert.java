package seleniumeclipse_pkg;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Handle_alert {

    public static WebDriver driver;

    public static void main (String[] args) throws InterruptedException {

        String browser = "chrome";

        if (browser.toUpperCase().equals("CHROME")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\morgan.nwaiku\\Downloads\\app\\web Drivers\\chrome driver\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browser.toUpperCase().equals("EDGE")){
            System.setProperty("webdriver.edge.driver","C:\\Users\\morgan.nwaiku\\Downloads\\app\\web Drivers\\Edge driver\\msedgedriver.exe");
            driver = new EdgeDriver();

                 //The below automation is for prompt (type in),confirm(cancel) and alert(ok)

        }
                 //This url is used for a prompt
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
                 //This url takes you to click on either 'ok' or 'cancel'
        //driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
                 //This url takes you to the main page
        // driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        driver.manage().window().maximize();

        String title = driver.getTitle();
                System.out.println(title);

        //switch to frame where 'Try it' is
        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
                //click on 'Try it'
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        Thread.sleep(3000);
                //switch the automation to the alert
        Alert alert = driver.switchTo().alert();
                //print the alert text
        String alertText = alert.getText();
        System.out.println("Alert Text : " + alertText);

                //To click on cancel
        //alert.dismiss();
                //Type into a prompt
        alert.sendKeys("Morgan Zee");
                //To click on ok
        alert.accept();
        Thread.sleep(3000);
                //takes you back to the parent page
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
