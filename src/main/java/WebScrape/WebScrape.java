package WebScrape;

import org.jsoup.*;
import org.jsoup.nodes.*;

public class WebScrape {

    public static void main(String[] args) {

        final String url = "https://sportalic.com/tip/crystal-palace-arsenal-premier-league-england-721075";

        try {
            final Document document = Jsoup.connect(url).get();
            System.out.println(document.outerHtml());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}