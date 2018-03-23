package rozetkaFramework;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Page {
    private JavascriptExecutor js = (JavascriptExecutor) driver;;

    @FindBy(xpath = ".//a[@name='signin']")
    WebElement signInLink;

    @FindBy(xpath = ".//input[@name='login']")
    WebElement loginInput;

    @FindBy(xpath = ".//input[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = ".//button[@name='auth_submit']")
    WebElement submitBtn;

    @FindBy(xpath = ".//a[contains(@href,'computers-notebooks')]")
    public WebElement noteBooksMainMenu;

    @FindBy(xpath = ".//p[@class='pab-h3']/a[contains(@href, 'notebooks/c80004/')]")
    public WebElement noteBooksSubMenu;

    @FindBy(xpath = ".//a[contains(@href, 'price=10000-12999')]")
    public WebElement priceFilter;

    @FindBy(xpath = ".//span[@class='g-rating-reviews']")
    public List<WebElement> userReviews;

    @FindBy(xpath = ".//div[@name='content']//a[@name='towishlist']")
    public WebElement wishList;

    @FindBy(xpath = ".//span[@class='header-user-pre-title']")
    public WebElement helloUser;

    @FindBy(xpath = ".//div[@id='wishlist']/a[contains(@href, 'wishlists')]")
    public WebElement wishListPanel;

    @FindBy(xpath = ".//img[@class='sprite wishlist-g-i-remove-icon']")
    public WebElement wishListDeleteSign;

    @FindBy(xpath = "//a[@class='confirm-email-popup-i-close novisited']")
    WebElement confirmEmail;

    @FindBy(xpath = "//a[@class='social-bind-tiny-close novisited']")
    WebElement social;



    public void login(String name, String pass) {
        clickOnWebElement(signInLink);
        loginInput.sendKeys(name);
        passwordInput.sendKeys(pass);
        clickOnWebElement(submitBtn);
        Assert.assertFalse(driver.findElements(
                By.name(".//a[@name='signin']")).size() >0);
        confirmEmail.click();
    }

    public void goToNoteBooksPage() {
        clickOnWebElement(noteBooksMainMenu);
        clickOnWebElement(noteBooksSubMenu);
    }

    public void filterByPrice() {
        priceFilter.click();
    }

    public void getProdWithMaxReviews() {
        WebElement maxReviewedProduct = userReviews.get(0);
        int max = 0;
        for (WebElement review : userReviews) {
           int reviewsNum = getReviewsNum(review.getText());
           if (max < reviewsNum) {
               max = reviewsNum;
               maxReviewedProduct = review;
           }
        }
        maxReviewedProduct.click();
    }

    public int getReviewsNum(String review) {
        String result = "";
        int reviewsNum = 0;
        for (int i = 0; i < review.length(); i++) {
           if (StringUtils.isNumeric(review.substring(i, i + 1))) {
               result += review.substring(i, i + 1);
               reviewsNum = Integer.parseInt(result);
            } else {
               break;
           }
        }
        return reviewsNum;
    }

    public void addToWishList() {
        social.click();
        clickOnWebElement(wishList);
    }

    public void deleteFromWishList() {
        wishListPanel.click();
        wishListDeleteSign.click();
    }


    public HomePage(WebDriver driver) {
        super(driver);
    }

}
