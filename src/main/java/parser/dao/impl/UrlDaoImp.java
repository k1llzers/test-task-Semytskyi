package parser.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import parser.dao.UrlDao;
import parser.exception.DataProcessingException;
import parser.model.Url;

@Repository
public class UrlDaoImp implements UrlDao {
    private final SessionFactory sessionFactory;

    public UrlDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Url create(Url url) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(url);
            transaction.commit();
            return url;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert url: " + url, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
