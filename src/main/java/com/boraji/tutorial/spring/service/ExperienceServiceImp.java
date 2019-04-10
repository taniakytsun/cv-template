package com.boraji.tutorial.spring.service;

import com.boraji.tutorial.spring.dao.BookDao;
import com.boraji.tutorial.spring.model.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component("experienceService")
@Service
@Transactional(readOnly = true)
public class ExperienceServiceImp implements BookService<Experience>{

    @Resource(name = "experienceDao")
    private BookDao<Experience> bookDao;


    @Override
    public long save(Experience experience) {
        return bookDao.save(experience);
    }

    @Override
    public Experience get(long id) {
        return bookDao.get(id);
    }

    @Override
    public List<Experience> list() {
            return bookDao.list();
    }

    @Override
    public void update(long id, Experience experience) {

            bookDao.update(id, experience);
    }

    @Override
    public void delete(long id) {
            bookDao.delete(id);
    }
}
