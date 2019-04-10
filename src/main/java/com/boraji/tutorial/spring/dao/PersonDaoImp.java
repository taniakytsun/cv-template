package com.boraji.tutorial.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.boraji.tutorial.spring.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("personDao")
@Repository
public class PersonDaoImp implements BookDao<Person> {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Person person) {
      sessionFactory.getCurrentSession().save(person);
      return person.getId();
   }

   @Override
   public Person get(long id) {

      return sessionFactory.getCurrentSession().get(Person.class, id);
   }

   @Override
   public List<Person> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Person> cq = cb.createQuery(Person.class);
      Root<Person> root = cq.from(Person.class);
      cq.select(root);
      Query<Person> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(long id, Person person) {
      Session session = sessionFactory.getCurrentSession();
      Person.Builder builder = new Person.Builder();
      builder.withName(person.getName());
      builder.withAge(person.getAge());
      builder.withAddress(person.getAddress());
      builder.withSpecialization(person.getSpecialization());
      builder.withEmail(person.getEmail());
      Person person2 = session.byId(Person.class).load(id);

      person2 = builder.build();
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Person person = session.byId(Person.class).load(id);
      session.delete(person);
   }

}
