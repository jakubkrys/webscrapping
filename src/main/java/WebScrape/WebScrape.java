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
            Elements finalResult = content.getElementsByClass("game-result");
            Elements result1H2H = content.getElementsByClass("game-extended-result");

            System.out.println(finalResult.text()+" "+result1H2H.text());
//            for (Element link : links) {
//                String linkText = link.text();
//                System.out.println(linkText);
//            }
            //System.out.println(document.outerHtml());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}