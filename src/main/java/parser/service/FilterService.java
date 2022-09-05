package parser.service;

import java.util.List;

public interface FilterService {
    List<String> filterHrefs(List<String> hrefs);

    List<String> deleteExternalHref(List<String> hrefs,String domen);
}
