package com.boraji.tutorial.spring.dao;

import java.util.List;

import com.boraji.tutorial.spring.model.Person;

public interface BookDao<T> {

   long save(T t);

   T get(long id);

   List<T> list();

   void update(long id, T t);

   void delete(long id);

}
