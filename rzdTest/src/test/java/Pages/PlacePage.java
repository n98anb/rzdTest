package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PlacePage {

    public String getHeader(){
        SelenideElement header = $x("//rzd-seats-autoselect-toolbar/h2");
        return header.text();
    }

    public String getTextOfPopUp(){
        Selenide.sleep(1000);
        ElementsCollection continueButtons = $$x("//button[@class = 'button--terminal']");
        continueButtons.first().click();
        Selenide.sleep(1000);
        SelenideElement popUp = $x("//span[@class = 'message-text ng-star-inserted']");
        return popUp.text();
    }
}
