import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WebScrap {
    private static final String url = "http://quotes.toscrape.com/page/%d";

    public List<Quote> get() {
        List<Quote> quotes = new ArrayList<>();
        boolean hasNextPage = true;
        int page = 1;

        do {
            Document doc = null;
            try {
                doc = Jsoup.connect(String.format(url,page)).get();
            } catch (IOException e) {
                e.printStackTrace();
                return Collections.emptyList();
            }

            Elements newsHeadlines = doc.select(".container .quote");

            if (newsHeadlines.isEmpty()) hasNextPage = false;

            for (Element headline : newsHeadlines) {
                String text = headline.getElementsByClass("text").text();
                String author = headline.getElementsByClass("author").text();
                String tags = headline.getElementsByClass("tag").text();

                quotes.add(Quote.builder().author(author).text(text).tags(Arrays.asList(tags.split(" "))).build());
            }
            page++;
        }while ( hasNextPage);

        return quotes;
    }
}
