// Story ticket link : https://jira.vizrt.com/browse/TSSTORY-83
// Keyboard shortcuts automation list :
// Keyboard frame forward, keyboard frame backward, Space shortcut, Delete shortcut, audio shortcut


import org.junit.Assert;
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
        int xp1=0;
        WebElement testtimecode1 = driver.findElement(By.xpath("//*[contains(text(),'00:0"+xp1+":')]"));
        final String starttime = testtimecode1.getText();

        Actions action = new Actions(driver);
        action.sendKeys(Keys.SPACE).build().perform();
        System.out.println(testtimecode1.getText());

        int ourtime = 9000;
        Thread.sleep(ourtime);
        int xp = (ourtime-1000)/1000;
        action.sendKeys(Keys.SPACE).build().perform();
        Thread.sleep(2000);

        timeLine.click();
        Thread.sleep(2000);
        WebElement testtimecode = driver.findElement(By.xpath("//*[contains(text(),'00:0"+xp+":')]"));

        System.out.println(testtimecode.getText());
        System.out.println(testtimecode1.getText());

        Assert.assertNotEquals(testtimecode.getText(), starttime);
        //Assert.assertNotEquals("111", "1");

    }

    @Test
    public void storyKeyboardFrameForward() throws InterruptedException {

        //a. Launch story in firefox
        driver.get("http://tanveer-pc:9724/web/story/story.html?debug&storyhub=tanveer-pc&gh=Guest/@tanveer-pc&pilot=tanveer-pc&preview=tanveer-pc&mediaservice=tanveer-pc");
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='http://tanveer-pc:9724/web/story/story/sc/skins/vizrt/images/Editor/Close.png']")));

        //Close the license popup
        WebElement okButton = driver.findElement(By.cssSelector("img[src='http://tanveer-pc:9724/web/story/story/sc/skins/vizrt/images/Editor/Close.png']"));
        okButton.click();

        //Click on Media tab
        WebElement uploadButton = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[1]/div[1]/div/table/tbody/tr/td"));
        uploadButton.click();

        //From storytab double click on story named 'storytest'
        Thread.sleep(2000);
        WebElement storytest = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[2]/div[2]/div[3]/div/div[3]"));
        storytest.click();
        WebElement storytest1 = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[2]/div[2]/div[3]/div/div[3]"));

        storytest1.click();
        storytest1.click();

        Thread.sleep(3000);
        //Select the video element in timeline div[class="thumbnailStrip"]
        WebElement timelinebar = driver.findElement(By.cssSelector("div[class='thumbnailStrip']"));
        timelinebar.click();

        Thread.sleep(2000);


        WebElement timebarnumber = driver.findElement(By.xpath("//div[contains(@style,'POSITION') and @eventproxy='sta_timeline_cursorlabel_1']"));
        final String timevalue = timebarnumber.getText();


        WebElement timebarnumber1 = driver.findElement(By.xpath("//div[contains(@style,'POSITION') and @eventproxy='sta_timeline_cursorlabel_1']"));
        final String timevalue1 = timebarnumber.getText();

        System.out.println(timevalue);
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.DECIMAL).build().perform();

        WebElement timebarnumber2 = driver.findElement(By.xpath("//div[contains(@style,'POSITION') and @eventproxy='sta_timeline_cursorlabel_1']//small"));
        final String timevalue2 = timebarnumber.getText();

        final String firsttime=(timevalue1.substring(timevalue2.lastIndexOf(":") + 1));
        int timer1 = Integer.parseInt(firsttime);

        final String secondtime=(timevalue2.substring(timevalue2.lastIndexOf(":") + 1));
        int timer2 = Integer.parseInt(secondtime);

        System.out.println(timer1);
        System.out.println(timer2);
        Assert.assertEquals(timer1+1, timer2);

    }

    @Test
    public void storyKeyboardFrameBackward() throws InterruptedException {
        //a. Launch story in firefox
        driver.get("http://tanveer-pc:9724/web/story/story.html?debug&storyhub=tanveer-pc&gh=Guest/@tanveer-pc&pilot=tanveer-pc&preview=tanveer-pc&mediaservice=tanveer-pc");
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='http://tanveer-pc:9724/web/story/story/sc/skins/vizrt/images/Editor/Close.png']")));

        //Close the license popup
        WebElement okButton = driver.findElement(By.cssSelector("img[src='http://tanveer-pc:9724/web/story/story/sc/skins/vizrt/images/Editor/Close.png']"));
        okButton.click();

        //Click on Media tab
        WebElement uploadButton = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[1]/div[1]/div/table/tbody/tr/td"));
        uploadButton.click();

        //From storytab double click on story named 'storytest'
        Thread.sleep(2000);
        WebElement storytest = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[2]/div[2]/div[3]/div/div[3]"));
        storytest.click();
        WebElement storytest1 = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[2]/div[2]/div[3]/div/div[3]"));

        storytest1.click();
        storytest1.click();

        Thread.sleep(3000);
        //Select the video element in timeline div[class="thumbnailStrip"]
        WebElement timelinebar = driver.findElement(By.cssSelector("div[class='thumbnailStrip']"));
        timelinebar.click();

        Thread.sleep(2000);


        WebElement timebarnumber = driver.findElement(By.xpath("//div[contains(@style,'POSITION') and @eventproxy='sta_timeline_cursorlabel_1']"));
        final String timevalue = timebarnumber.getText();


        WebElement timebarnumber1 = driver.findElement(By.xpath("//div[contains(@style,'POSITION') and @eventproxy='sta_timeline_cursorlabel_1']"));
        final String timevalue1 = timebarnumber.getText();

        System.out.println(timevalue);
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.SEPARATOR).build().perform();

        WebElement timebarnumber2 = driver.findElement(By.xpath("//div[contains(@style,'POSITION') and @eventproxy='sta_timeline_cursorlabel_1']//small"));
        final String timevalue2 = timebarnumber.getText();

        final String firsttime=(timevalue1.substring(timevalue2.lastIndexOf(":") + 1));
        int timer1 = Integer.parseInt(firsttime);

        final String secondtime=(timevalue2.substring(timevalue2.lastIndexOf(":") + 1));
        int timer2 = Integer.parseInt(secondtime);

        System.out.println(timer1);
        System.out.println(timer2);
        Assert.assertEquals(timer1-1, timer2);

    }

    @Test
    public void storyKeyDelete() throws InterruptedException {

        //a. Launch story in firefox
        driver.get("http://tanveer-pc:9724/web/story/story.html?debug&storyhub=tanveer-pc&gh=Guest/@tanveer-pc&pilot=tanveer-pc&preview=tanveer-pc&mediaservice=tanveer-pc");
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='http://tanveer-pc:9724/web/story/story/sc/skins/vizrt/images/Editor/Close.png']")));

        //Close the license popup
        WebElement okButton = driver.findElement(By.cssSelector("img[src='http://tanveer-pc:9724/web/story/story/sc/skins/vizrt/images/Editor/Close.png']"));
        okButton.click();

        //Click on Media tab
        WebElement uploadButton = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[1]/div[1]/div/table/tbody/tr/td"));
        uploadButton.click();

        //From storytab double click on story named 'storytest'
        Thread.sleep(2000);
        WebElement storytest = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[2]/div[2]/div[3]/div/div[3]"));
        storytest.click();
        WebElement storytest1 = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[2]/div[2]/div[3]/div/div[3]"));

        storytest1.click();
        storytest1.click();

        Thread.sleep(3000);
        //Select the video element in timeline div[class="thumbnailStrip"]
        WebElement timelinebar = driver.findElement(By.cssSelector("div[class='thumbnailStrip']"));
        timelinebar.click();

        Thread.sleep(2000);

        WebElement timebarnumber = driver.findElement(By.xpath("//div[contains(@style,'POSITION') and @eventproxy='sta_timeline_cursorlabel_1']"));
        final String timevalue = timebarnumber.getText();

        WebElement timebarnumber1 = driver.findElement(By.xpath("//div[contains(@style,'POSITION') and @eventproxy='sta_timeline_cursorlabel_1']"));
        final String timevalue1 = timebarnumber.getText();

        Actions action = new Actions(driver);

        //Asserting if presence of element shows false after deletion button is pressed
        action.sendKeys(Keys.DELETE).build().perform();
        Boolean isPresent2 = driver.findElements(By.cssSelector("div[class='thumbnailStrip']")).size() > 0 ;
        Assert.assertEquals(false , isPresent2);


        // Undoing the change to timeline by pressing 'CTRL + Z'
        Thread.sleep(2000);
        Actions action2 = new Actions(driver);
        action2.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u007A')).perform();


        /*
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        //String selectAll = Keys.chord(Keys.CONTROL, "a");

        action.sendKeys(".").perform();
       // action.sendKeys(selectAll).build().perform();
        //action.sendKeys(Keys.getKeyFromUnicode('selectAll')).build().perform();
*/

    }

    @Test
    public void storyKeyVolumeBar() throws InterruptedException {

        //a. Launch story in firefox
        driver.get("http://tanveer-pc:9724/web/story/story.html?debug&storyhub=tanveer-pc&gh=Guest/@tanveer-pc&pilot=tanveer-pc&preview=tanveer-pc&mediaservice=tanveer-pc");
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='http://tanveer-pc:9724/web/story/story/sc/skins/vizrt/images/Editor/Close.png']")));

        //Close the license popup
        WebElement okButton = driver.findElement(By.cssSelector("img[src='http://tanveer-pc:9724/web/story/story/sc/skins/vizrt/images/Editor/Close.png']"));
        okButton.click();

        //Click on Media tab
        WebElement uploadButton = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[1]/div[1]/div/table/tbody/tr/td"));
        uploadButton.click();

        //From storytab double click on story named 'storytest'
        Thread.sleep(2000);
        WebElement storytest = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[2]/div[2]/div[3]/div/div[3]"));
        storytest.click();
        WebElement storytest1 = driver.findElement(By.xpath("html/body/div[4]/div/div[1]/div/div[1]/div/div[2]/div[3]/div/div/div/div/div[2]/div[2]/div[3]/div/div[3]"));

        storytest1.click();
        storytest1.click();

        Thread.sleep(3000);
        //Select the video element in timeline div[class="thumbnailStrip"]
        WebElement timelinebar = driver.findElement(By.cssSelector("div[class='thumbnailStrip']"));
        timelinebar.click();
        Thread.sleep(3000);
        Actions action = new Actions(driver);
        action.sendKeys("a").perform();
        //html/body/div[7]/div/div
        Boolean isPresent2 = driver.findElements(By.xpath("html/body/div[7]/div/div")).size() > 0 ;

        System.out.println(isPresent2);
        Assert.assertEquals(false , isPresent2);
        

    }


    @Test
    public void storyKeyboardMute() throws InterruptedException {

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

/*
        Thread.sleep(2000) ;
        WebElement timeLine = driver.findElement(By.cssSelector("svg[id=multimedia_ClearInOut]"));
        timeLine.click();

        Thread.sleep(2000);
        int xp1=0;
        WebElement testtimecode1 = driver.findElement(By.xpath("//*[contains(text(),'00:0"+xp1+":')]"));
        final String starttime = testtimecode1.getText();

        Actions action = new Actions(driver);
        action.sendKeys(Keys.SPACE).build().perform();
        System.out.println(testtimecode1.getText());

        int ourtime = 9000;
        Thread.sleep(ourtime);
        int xp = (ourtime-1000)/1000;
        action.sendKeys(Keys.SPACE).build().perform();
        Thread.sleep(2000);

        timeLine.click();
        Thread.sleep(2000);
        WebElement testtimecode = driver.findElement(By.xpath("//*[contains(text(),'00:0"+xp+":')]"));

        System.out.println(testtimecode.getText());
        System.out.println(testtimecode1.getText());

        Assert.assertNotEquals(testtimecode.getText(), starttime);
        //Assert.assertNotEquals("111", "1");
*/
    }


    /*
@After
public void tearDown() {
    driver.quit();
}
*/


}


