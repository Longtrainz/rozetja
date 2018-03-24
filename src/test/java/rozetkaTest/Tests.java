package rozetkaTest;

import org.testng.annotations.Test;
import rozetkaFramework.HomePage;

public class Tests extends TestBase {


    @Test
    public void loginTest() {
        HomePage hp = new HomePage(driver);
/*        hp.login("test123321@mail.ru","123QWE");
        hp.goToNoteBooksPage();
        hp.filterByPrice();
        hp.getProdWithMaxReviews();
        hp.addToWishList();
        hp.deleteFromWishList();*/
    }
}
