package com.hcq.service;

import com.hcq.bean.TbUser;
import com.hcq.page.Page;

import java.util.List;

public interface IUserService {
    List<TbUser> findAll();
    void delete(int id);
    void add(TbUser user);
    void update(TbUser user);
    TbUser findOneById(int id);
    List<TbUser> list(Page page);
    int total();
}

