import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Quote> quotes = new WebScrap().get();
        FileUtil.saveJson("quotes.json", quotes);
    }
}
