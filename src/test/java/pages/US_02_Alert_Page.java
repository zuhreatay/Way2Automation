package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_02_Alert_Page {

    public US_02_Alert_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='Alert']")
    public WebElement AlertMenu;

    @FindBy(xpath = "//a[.='Simple Alert']")
    public WebElement simpleAlert;

    @FindBy(xpath = "//iframe[@class='demo-frame']")
    public WebElement SimpleFrame;

    @FindBy(xpath = "(//iframe[@class='demo-frame'])[2]")
    public WebElement inputFrame;

    @FindBy(xpath = "//button[.='Click the button to display an alert box:']")
    public WebElement simpleAlertBttn;

    @FindBy(xpath = "//a[.='Input Alert']")
    public WebElement inputAlert;

    @FindBy(xpath = "//button[.='Click the button to demonstrate the Input box.']")
    public WebElement inputAlertBttn;

    @FindBy(id="demo")
    public WebElement inputAlertText;

    @FindBy(xpath = "//p[@id='demo']")
    public WebElement inputDogrulamaText;
}
