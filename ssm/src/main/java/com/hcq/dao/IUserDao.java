package com.hcq.dao;

import com.hcq.bean.TbUser;
import com.hcq.page.Page;

import java.util.List;

public interface IUserDao {
    List<TbUser> findAll();
    void add(TbUser user);
    void delete(int id);
    void update(TbUser user);
    TbUser findOneById(int id);
    List<TbUser> list(Page page);
    int total();
}
