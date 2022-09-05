package parser.service;

import java.util.Map;
import parser.model.Url;

public interface TreatmentService {
    void handle(Map<String, Url> storage, Url currentUrl, String domen);
}
