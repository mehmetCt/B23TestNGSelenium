package com.cydeo.pages;


import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class AdidasPage {

    public AdidasPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h3[@class='price-container']")
    public WebElement purchasePrice;

    //a[.='Add to cart']
    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addCart;


    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    public WebElement homeLink;

    @FindBy(xpath = "//a[.='Cart']")
    public WebElement cart;

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrder;

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "card")
    public WebElement card;

    @FindBy(id = "month")
    public WebElement month;

    @FindBy(id = "year")
    public WebElement year;


    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseButton;

   @FindBy(xpath = "//p[@class='lead text-muted ']")
   public WebElement confirmation;


    @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
    public WebElement OK;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> allProductFromCart;

    public int addProduct(String category,String product){

        // dynamic categories locator //a[.='"+category+"']
        // dynamic products locator //a[normalize-space(.)='"+product+"']

        Driver.getDriver().findElement(By.xpath("//a[.='"+category+"']")).click();
        BrowserUtils.waitFor(1);

        Driver.getDriver().findElement(By.xpath("//a[normalize-space(.)='"+product+"']")).click();
        BrowserUtils.waitFor(1);

        String priceString = purchasePrice.getText();
        System.out.println("priceString = " + priceString);
        String[] priceArray = priceString.split(" ");
        System.out.println("Arrays.toString(priceArray) = " + Arrays.toString(priceArray));
        priceString = priceArray[0].substring(1);
        int price = Integer.parseInt(priceString);

        //AddCart
        addCart.click();

        //Explicit Wait

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.alertIsPresent());

        //Alert
        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();

        //Go back home
        homeLink.click();

        return price;
    }

    public int removeProduct(String product){
        BrowserUtils.waitFor(1);

        // dynamic locator for productPrice in cartPage

        //tbody//td[.='"+product+"']/../td[3]
        String priceString = Driver.getDriver().findElement(By.xpath("//tbody//td[.='" + product + "']/../td[3]")).getText();
        int price = Integer.parseInt(priceString);
        System.out.println("price = " + price);

        //dynamic locator for Delete button
        WebElement deleteButton = Driver.getDriver().findElement(By.xpath("//tbody//td[.='" + product + "']/../td/a"));
        deleteButton.click();

        BrowserUtils.waitFor(3);

        //tbody//[.='"+product+"']/../td/a

        return price;
    }

    public void fillForm() {
        Faker faker=new Faker();

        name.sendKeys(faker.name().fullName());
        country.sendKeys(faker.country().name());
        city.sendKeys(faker.country().capital());
        card.sendKeys(faker.finance().creditCard());
        month.sendKeys(String.valueOf(faker.number().numberBetween(1, 12)));
        year.sendKeys(String.valueOf(faker.number().numberBetween(2022, 2030)));


    }
}
