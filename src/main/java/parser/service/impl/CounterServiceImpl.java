package parser.service.impl;

import java.util.List;
import parser.service.CounterService;

public class CounterServiceImpl implements CounterService {
    public long countExternalHref(List<String> hrefs,String domen) {
        long countOfExternalHref = hrefs.stream()
                .filter((href) -> !href.startsWith(domen))
                .count();
        return countOfExternalHref;
    }
}
