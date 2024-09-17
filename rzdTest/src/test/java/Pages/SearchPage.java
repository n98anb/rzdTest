package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {

    public int findAllTrains(){
        Selenide.sleep(15000);
        ElementsCollection allTrains = $$x("//rzd-search-results-card-list//rzd-search-results-card-railway-flat-card[@aria-label]");
        List<String> trains = new ArrayList<>();
        for(int i=0; i<allTrains.size(); i++){
            trains.add(allTrains.get(i).getAttribute("aria-label"));
        }
        return trains.size();
    }

    public String getNumberOfTrains(){
        Selenide.sleep(15000);
        SelenideElement number = $x("//div[contains(@class, 'header__result-count')]");
        return number.text();
    }

    public TicketPage openTicketPage(){
        Selenide.sleep(15000);
        SelenideElement firstTrain = $x("//rzd-search-results-card-list//rzd-search-results-card-railway-flat-card[@aria-label]");
        firstTrain.click();
        return new TicketPage();
    }
}