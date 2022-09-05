package parser.service;

import java.util.List;

public interface CounterService {
    long countExternalHref(List<String> hrefs, String domen);
}
