package parser.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import parser.service.SelectService;

@Service
public class SelectServiceImpl implements SelectService {
    public List<String> getHrefs(String domen) {
        Elements elements;
        try {
            elements = Jsoup.connect(domen)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get()
                    .select("a");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> hrefs = new ArrayList();
        for (Element element: elements) {
            hrefs.add(element.attr("href"));
        }
        return hrefs;
    }
}
