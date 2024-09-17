package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final ElementsCollection searchSection = $$x("//section//input");
    private final SelenideElement startFrom = $x("//section//ul//li[2]");
    private final SelenideElement endPlace = $x("//section//ul[@class=\"rzd-suggestion-block bg-accessible\"]//li[2]");
    private final SelenideElement findButton = $x("//section//div[@class=\"rzd-button-wrapper rzd-cell rzd-cell-15\"]//a");


    public MainPage(String url){
        Selenide.open(url);
    }

    public SearchPage inputStartAndEnd(String start, String end, String time){

        searchSection.first().setValue(start);
        startFrom.click();

        searchSection.get(1).setValue(end);
        endPlace.click();

        searchSection.get(4).setValue(time);

        findButton.click();
        return new SearchPage();
    }
}
