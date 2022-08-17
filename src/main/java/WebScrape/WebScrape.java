package WebScrape;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class WebScrape {

    public static void main(String[] args) {

        String url = "https://sportalic.com/tip/crystal-palace-arsenal-premier-league-england-721075";

        try {
            Document document = Jsoup.connect(url).get();
            Element content = document.getElementById("game-details-wrapper"); 
            Elements gameTime = content.getElementsByClass("game-time");
            Elements homeTeam = content.getElementsByClass("team-flag-left");
            Elements awayTeam = content.getElementsByClass("team-flag-right");
            Elements finalResult = content.getElementsByClass("game-result");
            Elements result1H2H = content.getElementsByClass("game-extended-result");
            Elements homeTeamWinnerBet = content.getElementsByClass("game-stat-wrapper");
//            Elements drawBet = content.getElementsByClass("odd down ");
//            Elements awayTeamWinnerBet = content.getElementsByClass("odd up ");

            System.out.println(gameTime.text().substring(0, (gameTime.text().length() - 6)));
            System.out.println(homeTeam.text()+ " - "+awayTeam.text());
            System.out.println(finalResult.text()+" "+result1H2H.text());
//            System.out.println(homeTeamWinnerBet.text()+" ; "+drawBet.text()+" ; "+awayTeamWinnerBet.text());
            System.out.println(homeTeamWinnerBet.text());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}