package WebScrape;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class WebScrape {

    public static void main(String[] args) {

        String url = "https://sportalic.com/tip/crystal-palace-arsenal-premier-league-england-721075";
        String separator = " | ";

        try {
            Document document = Jsoup.connect(url).get();
            Element content = document.getElementById("game-details-wrapper");
            Elements gameTime = content.getElementsByClass("game-time");
            Elements homeTeam = content.getElementsByClass("team-flag-left");
            Elements awayTeam = content.getElementsByClass("team-flag-right");
            Elements finalResult = content.getElementsByClass("game-result");
            Elements result1H2H = content.getElementsByClass("game-extended-result");
            String homeTeamWinnerBet = "";
            String homeTeamWinnerProbability = "";
            String drawBet = "";
            String drawProbability = "";
            String awayTeamWinnerBet = "";
            String awayTeamWinnerProbability = "";
            String homeOrDrawBet = "";
            String homeOrDrawProbability = "";
            String awayOrDrawBet = "";
            String awayOrDrawProbability = "";

            System.out.println(gameTime.text().substring(0, (gameTime.text().length() - 6)));
            System.out.println(homeTeam.text()+ " - "+awayTeam.text());
            System.out.println(finalResult.text()+" "+result1H2H.text());

            for (Element row : document.select("table.sodds:nth-of-type(1)")) {
                homeTeamWinnerBet = row.select("td.down.odd:nth-of-type(1)").text();
                homeTeamWinnerProbability = row.select("td.tip:nth-of-type(1)").text();
                drawBet = row.select("td.down.odd:nth-of-type(2)").text();
                drawProbability = row.select("td.tip:nth-of-type(2)").text();
                awayTeamWinnerBet = row.select("td.up.win.odd:nth-of-type(3)").text();
                homeOrDrawBet = row.select(".down.unknown.odd").text();
                homeOrDrawProbability = row.select(".unknown.tip").text();
                awayOrDrawBet = row.select("td.up.win.odd:nth-of-type(9)").text();
                awayOrDrawProbability = row.select("td.win.tip:nth-of-type(9)").text();
                System.out.println(homeTeamWinnerBet+separator+drawBet+separator+awayTeamWinnerBet);
                System.out.println(homeTeamWinnerProbability+separator+drawProbability+separator+awayTeamWinnerProbability);
                System.out.println(homeOrDrawBet+separator+awayOrDrawBet);
                System.out.println(homeOrDrawProbability+separator+awayOrDrawProbability);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}