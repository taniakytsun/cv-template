package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.BookDao;
import com.boraji.tutorial.spring.model.Person;

@Component("pers")
@Service
@Transactional(readOnly = true)
public class PersonServiceImp  implements BookService<Person>{

   @Autowired
   private BookDao<Person> bookDao;

   @Transactional
   @Override
   public long save(Person person) {
      return bookDao.save(person);
   }

   @Override
   public Person get(long id) {
      return bookDao.get(id);
   }

   @Override
   public List<Person> list() {
      return bookDao.list();
   }

   @Transactional
   @Override
   public void update(long id, Person person) {
      bookDao.update(id, person);
   }

   @Transactional
   @Override
   public void delete(long id) {
      bookDao.delete(id);
   }

}
