package parser.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import parser.model.Url;
import parser.service.TreatmentService;
import parser.service.UrlService;

@Service
public class TreatmentServiceImpl implements TreatmentService {
    private GettingServiceImpl gettingService;
    private CounterServiceImpl counterService;
    private FilterServiceImpl filterService;
    private UrlService urlService;

    public TreatmentServiceImpl(UrlService urlService) {
        this.urlService = urlService;
        this.gettingService = new GettingServiceImpl();
        this.counterService = new CounterServiceImpl();
        this.filterService = new FilterServiceImpl();
    }

    public void handle(Map<String, Url> storage, Url currentUrl,String domen) {
        if (!storage.containsKey(currentUrl.getUrl())) {
            List<String> hrefs = gettingService.getHrefs(currentUrl.getUrl());
            long countExternalHref = counterService.countExternalHref(hrefs, domen);
            currentUrl.setCountOfExternalHrefs(countExternalHref);
            storage.put(currentUrl.getUrl(), currentUrl);
            urlService.create(currentUrl);
            hrefs = filterService.deleteExternalHref(hrefs, domen);
            List<Url> nextLevelUrls = new ArrayList<>();
            for (String href : hrefs) {
                nextLevelUrls.add(new Url(href, currentUrl.getNestingLevel() + 1));
            }
            for (Url url : nextLevelUrls) {
                handle(storage, url, domen);
            }
        }
    }
}
