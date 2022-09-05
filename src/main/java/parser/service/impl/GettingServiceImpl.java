package parser.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import parser.service.GettingService;

@Service
public class GettingServiceImpl implements GettingService {
    private FilterServiceImpl filterService;
    private SelectServiceImpl selectService;

    public GettingServiceImpl() {
        this.filterService = new FilterServiceImpl();
        this.selectService = new SelectServiceImpl();
    }

    public List<String> getHrefs(String domen) {
        List<String> hrefs = selectService.getHrefs(domen);
        hrefs = filterService.filterHrefs(hrefs);
        return hrefs;
    }
}
