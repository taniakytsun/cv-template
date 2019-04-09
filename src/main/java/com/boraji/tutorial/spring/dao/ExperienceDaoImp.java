package com.boraji.tutorial.spring.dao;

import com.boraji.tutorial.spring.model.Experience;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ExperienceDaoImp implements BookDao<Experience> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Experience experience) {
        sessionFactory.getCurrentSession().save(experience);
        return experience.getId();
    }

    @Override
    public Experience get(long id) {
        return sessionFactory.getCurrentSession().get(Experience.class, id);
    }

    @Override
    public List<Experience> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Experience> cq = cb.createQuery(Experience.class);
        Root<Experience> root = cq.from(Experience.class);
        cq.select(root);
        Query<Experience> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(long id, Experience experience) {
        Session session = sessionFactory.getCurrentSession();
        Experience.Builder builder = new Experience.Builder();
        builder.withPlace(experience.getPlace());
        builder.withDateFrom(experience.getDateFrom());
        builder.withDateTo(experience.getDateTo());
        builder.withPosition(experience.getPosition());
        Experience experience1 = session.byId(Experience.class).load(id);
        experience1 = builder.build();
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Experience experience = session.byId(Experience.class).load(id);
        session.delete(experience);
    }
}
