package parser.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import parser.model.Url;
import parser.service.impl.TreatmentServiceImpl;

@Controller
public class StatisticController {
    private TreatmentServiceImpl treatmentService;

    public StatisticController(TreatmentServiceImpl treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("/getStatistic")
    public String getStatistic(@RequestParam String url, Model model) {
        Map<String, Url> storage = new HashMap<>();
        treatmentService.handle(storage,new Url(url,0),url);
        Collection<Url> urls = storage.values();
        int countOfPages = urls.size();
        int countOfExternalLink = 0;
        for (Url page:urls) {
            countOfExternalLink += page.getCountOfExternalHrefs();
        }
        model.addAttribute("urls",urls);
        model.addAttribute("domenCountOfPages",countOfPages);
        model.addAttribute("domenCountofExternal",countOfExternalLink);
        return "statistic_page";
    }
}
