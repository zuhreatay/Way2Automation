package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import pages.US_02_Alert_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_02_Alert_Test extends TestBase {

    US_02_Alert_Page us02AlertPage = new US_02_Alert_Page();
    US_01_Login_Page us01LoginPage = new US_01_Login_Page();

    @BeforeMethod
    public void giris(){
        us01LoginPage.signinButton.click();
        ReusableMethods.waitFor(2);
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        us01LoginPage.submitButton.click();
    }

    @Test
    public void TC_004(){
        //Simple Alert butonuna tiklanabildigini assert ediniz
        ReusableMethods.clickStaleElement(us02AlertPage.AlertMenu);
        Assert.assertTrue(us02AlertPage.simpleAlert.isEnabled());
    }

    @Test
    public void TC_005(){
        //"Click to button to display an alert box" yazisini iceren button'un tiklanabildigini assert ediniz
        ReusableMethods.clickStaleElement(us02AlertPage.AlertMenu);//Alert menuye tiklamak icin :yeni bir method tiklamaya devam et anlaminda
        Driver.getDriver().switchTo().frame(us02AlertPage.SimpleFrame);
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.simpleAlertBttn));
        Assert.assertTrue(us02AlertPage.simpleAlertBttn.isEnabled());
    }

    @Test
    public void TC_006(){
        //Texbox'a tikladiginizda Alert mesaj kutusunda "I am an alert box!" yazisinin ciktigini dogrulayiniz
        ReusableMethods.clickStaleElement(us02AlertPage.AlertMenu);//Alert menuye tiklamak icin : yeni birmethod tiklamaya devam et anlaminda
        Driver.getDriver().switchTo().frame(us02AlertPage.SimpleFrame);
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.simpleAlertBttn));
        actions.click(us02AlertPage.simpleAlertBttn).perform();
        // buraya wait koyulabilir
        Driver.getDriver().switchTo().alert();
        ReusableMethods.waitFor(2);
        String actualAlertText = Driver.getDriver().switchTo().alert().getText();
        String expectedAlertText = "I am an alert box!";
        Assert.assertEquals(actualAlertText,expectedAlertText);
    }

    @Test
    public void TC_007(){
        //ok butonuna tiklanabildigini assert ediniz
        ReusableMethods.clickStaleElement(us02AlertPage.AlertMenu);//Alert menuye tiklamak icin : yeni birmethod tiklamaya devam et anlaminda
        Driver.getDriver().switchTo().frame(us02AlertPage.SimpleFrame);
        actions.click(us02AlertPage.simpleAlertBttn).perform();
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertTrue(us02AlertPage.simpleAlertBttn.isEnabled());

    }

    @Test
    public void TC_008(){
        //Input alert butonuna tiklanabildigini dogrulayiniz
        ReusableMethods.clickStaleElement(us02AlertPage.AlertMenu);//Alert menuye tiklamak icin :yeni bir method tiklamaya devam et anlaminda
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.inputAlert));
        Assert.assertTrue(us02AlertPage.inputAlert.isEnabled());
    }

    @Test
    public void TC_009(){
        //"Click the button to demonstrate the input box" yazisini iceren buttonun tiklanabildigini assert ediniz
        ReusableMethods.clickStaleElement(us02AlertPage.AlertMenu);//Alert menuye tiklamak icin :yeni bir method tiklamaya devam et anlaminda
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.inputAlert));
        us02AlertPage.inputAlert.click();
        Driver.getDriver().switchTo().frame(us02AlertPage.inputFrame);
        Assert.assertTrue(us02AlertPage.inputAlertBttn.isEnabled());

    }

    @Test
    public void TC_010(){
        //Texbox'a tikladiginizda Alert mesaj kutusunun aciliyor oldugunu dogrulayiniz
        ReusableMethods.clickStaleElement(us02AlertPage.AlertMenu);//Alert menuye tiklamak icin :yeni bir method tiklamaya devam et anlaminda
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.inputAlert));
        us02AlertPage.inputAlert.click();
        Driver.getDriver().switchTo().frame(us02AlertPage.inputFrame);
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.inputAlertBttn));
        actions.click(us02AlertPage.inputAlertBttn).perform();
        Driver.getDriver().switchTo().alert();
        String actualinputAlertText = Driver.getDriver().switchTo().alert().getText();
        String expectedinputAlertText="Please enter your name";
        Assert.assertEquals(actualinputAlertText,expectedinputAlertText);
       //Assert.assertTrue(actualinputAlertText.contains(expectedinputAlertText));
    }



    @Test
    public void TC_011(){
        //Input mesaj kutusuna mesaj yazilabildigini dogrulayiniz
        ReusableMethods.clickStaleElement(us02AlertPage.AlertMenu);//Alert menuye tiklamak icin :yeni bir method tiklamaya devam et anlaminda
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.inputAlert));
        us02AlertPage.inputAlert.click();
        Driver.getDriver().switchTo().frame(us02AlertPage.inputFrame);
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.inputAlertBttn));
        actions.click(us02AlertPage.inputAlertBttn).perform();
        wait.until(ExpectedConditions.alertIsPresent());// alert hazir olana kadar bekle
        Driver.getDriver().switchTo().alert().sendKeys("Girls Team!");
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(us02AlertPage.inputDogrulamaText.isDisplayed());


    }

    @Test
    public void TC_012(){
        //Ok butonuna tiklanabildigini dogrulayiniz

        ReusableMethods.clickStaleElement(us02AlertPage.AlertMenu);//Alert menuye tiklamak icin :yeni bir method tiklamaya devam et anlaminda
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.inputAlert));
        us02AlertPage.inputAlert.click();
        Driver.getDriver().switchTo().frame(us02AlertPage.inputFrame);
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.inputAlertBttn));
        actions.click(us02AlertPage.inputAlertBttn).perform();
        Driver.getDriver().switchTo().alert();
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.waitFor(3);
        System.out.println(us02AlertPage.inputDogrulamaText);
        Assert.assertTrue(us02AlertPage.inputDogrulamaText.isDisplayed());

    }

    @Test
    public void TC_013(){
        //Cancel butonuna tiklanabildigini dogrulayiniz
        ReusableMethods.clickStaleElement(us02AlertPage.AlertMenu);//Alert menuye tiklamak icin :yeni bir method tiklamaya devam et anlaminda
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.inputAlert));
        us02AlertPage.inputAlert.click();
        Driver.getDriver().switchTo().frame(us02AlertPage.inputFrame);
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.inputAlertBttn));
        actions.click(us02AlertPage.inputAlertBttn).perform();
        Driver.getDriver().switchTo().alert();
        Driver.getDriver().switchTo().alert().dismiss();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(us02AlertPage.inputAlertBttn.isEnabled());
    }
}
