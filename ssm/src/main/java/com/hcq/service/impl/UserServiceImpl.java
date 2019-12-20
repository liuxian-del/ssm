package com.hcq.service.impl;

import com.hcq.bean.TbUser;
import com.hcq.dao.IUserDao;
import com.hcq.page.Page;
import com.hcq.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public List<TbUser> findAll() {
        return userDao.findAll();
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }


    @Override
    public void add(TbUser user) {
        userDao.add(user);
    }


    @Override
    public void update(TbUser user) {
        userDao.update(user);
    }

    @Override
    public TbUser findOneById(int id) {
        return userDao.findOneById(id);
    }

    @Override
    public List<TbUser> list(Page page) {
        return userDao.list(page);
    }

    @Override
    public int total() {
        return userDao.total();
    }
}
