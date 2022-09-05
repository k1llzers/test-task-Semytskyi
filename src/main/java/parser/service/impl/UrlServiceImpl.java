package parser.service.impl;

import org.springframework.stereotype.Service;
import parser.dao.UrlDao;
import parser.model.Url;
import parser.service.UrlService;

@Service
public class UrlServiceImpl implements UrlService {
    private UrlDao urlDao;

    public UrlServiceImpl(UrlDao urlDao) {
        this.urlDao = urlDao;
    }

    @Override
    public Url create(Url url) {
        return urlDao.create(url);
    }
}
