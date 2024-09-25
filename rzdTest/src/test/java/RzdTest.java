import Pages.MainPage;

import Pages.PlacePage;
import Pages.SearchPage;
import Pages.TicketPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class RzdTest {
    public final static String URL = "https://www.rzd.ru/";
    public static String start = "Санкт-Петербург";
    public static String end = "Москва";
    public static String time = "20.09.2024";

/*
Сравнение количества доступных к покупке поездов на странице и их количество во вкладке "фильтр"
 */
    @Test
    public void RzdTestNumberOfTrains(){
        MainPage mainPage = new MainPage(URL);
        SearchPage searchPage = new SearchPage();
        Assert.assertEquals(String.format("%d рейсов",
                mainPage.inputStartAndEnd(start, end, time).findAllTrains()),
                searchPage.getNumberOfTrains());
    }
/*
Проверка хэддера на странице выбора класса обслуживания
 */
    @Test
    public void RzdHeaderForSelectTicket(){
        MainPage mainPage = new MainPage(URL);
        TicketPage ticketPage = new TicketPage();
        mainPage.inputStartAndEnd(start, end, time).openTicketPage();
        Assert.assertEquals(ticketPage.getHeader1(),"Выберите класс обслуживания");
    }
/*
Проверка хэддера на странице выбора мест
 */
    @Test
    public void RzdHeaderForSelectPlace(){
        MainPage mainPage = new MainPage(URL);
        PlacePage placePage = new PlacePage();
        mainPage.inputStartAndEnd(start, end, time).openTicketPage().openPlacePage();
        Assert.assertEquals(placePage.getHeader(),"Выберите до 9 мест или задайте параметры");
    }
/*
Проверка поп-апа если места не выбраны
 */
    @Test
    public void RzdTextOfPopUp(){
        MainPage mainPage = new MainPage(URL);
        PlacePage placePage = new PlacePage();
        mainPage.inputStartAndEnd(start, end, time).openTicketPage().openPlacePage();
        Assert.assertEquals(placePage.getTextOfPopUp(),"Выберите, пожалуйста, место.");
    }
}
