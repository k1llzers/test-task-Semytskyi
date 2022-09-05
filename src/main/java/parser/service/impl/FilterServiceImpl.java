package parser.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import parser.service.FilterService;

@Service
public class FilterServiceImpl implements FilterService {
    public List<String> filterHrefs(List<String> hrefs) {
        List<String> filteredHrefs = hrefs.stream()
                .distinct()
                .filter((href) -> href.startsWith("http") && !href.endsWith("jpg"))
                .collect(Collectors.toList());
        return filteredHrefs;
    }

    public List<String> deleteExternalHref(List<String> hrefs,String domen) {
        List<String> clearHrefs = hrefs.stream()
                .filter((href) -> href.startsWith(domen))
                .collect(Collectors.toList());
        return clearHrefs;
    }
}
