import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoryKeyboardShortcutTests {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void storyFirstTest() throws InterruptedException {
        //1. Go to story site
        driver.get("http://tanveer-pc:9724/web/story/story.html?debug&storyhub=tanveer-pc&gh=Guest/@tanveer-pc&pilot=tanveer-pc&preview=tanveer-pc&mediaservice=tanveer-pc");
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='http://tanveer-pc:9724/web/story/story/sc/skins/vizrt/images/Editor/Close.png']")));

        //2. Close the license popup
        WebElement okButton = driver.findElement(By.cssSelector("img[src='http://tanveer-pc:9724/web/story/story/sc/skins/vizrt/images/Editor/Close.png']"));
        okButton.click();

        //Click on Media tab
        WebElement uploadButton = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[1]/div[1]/div/table/tbody/tr/td"));
        uploadButton.click();

        //Click on video tab
        WebElement videoTab = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[2]/div[1]/div/div/div/table[1]/tbody[2]/tr[1]/td[1]/div/div/div[2]"));
        videoTab.click();
        WebElement searchText = driver.findElement(By.id("isc_30"));
        searchText.sendKeys("SSS_2477_01.mov");


        Thread.sleep(5000);
        WebElement selectVideo = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[2]/div[2]/div[3]/div[1]/div[3]"));

        selectVideo.click();

        WebElement selectVideo1 = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[2]/div[2]/div[3]/div[1]/div[3]"));
        selectVideo1.click();

        Thread.sleep(2000) ;
        WebElement timeLine = driver.findElement(By.cssSelector("svg[id=multimedia_ClearInOut]"));
        timeLine.click();

        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.SPACE).build().perform();
        int ourtime = 9000;
        Thread.sleep(ourtime);
        int xp = (ourtime-1000)/1000;
        action.sendKeys(Keys.SPACE).build().perform();
        Thread.sleep(2000);

        //timeLine.click();
        Thread.sleep(2000);
        WebElement testtimecode = driver.findElement(By.xpath("//*[contains(text(),'00:0"+xp+":')]"));

        System.out.println(testtimecode.getText());
        System.out.println("Test");



    }
/*
@After
public void tearDown() {
    driver.quit();
}

*/

}


