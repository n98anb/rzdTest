package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class TicketPage {

    public String getHeader1(){
        Selenide.sleep(15000);
        SelenideElement header = $x("//div[@class = 'inner']//h2");
        return header.text();
    }

    public PlacePage openPlacePage(){
        Selenide.sleep(15000);
        ElementsCollection continueButtons = $$x("//button[@class = 'button--terminal']");
        continueButtons.last().click();
        return new PlacePage();
    }
}
