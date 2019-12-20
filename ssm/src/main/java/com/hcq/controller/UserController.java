package com.hcq.controller;

import com.hcq.bean.TbUser;
import com.hcq.page.Page;
import com.hcq.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.util.List;

@RequestMapping("user")
@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        List<TbUser> users = userService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("us",users);
        mv.setViewName("allUser");
        return mv;
    }

    @RequestMapping("delete.do")
    public String delete(int id){
        userService.delete(id);
        return "redirect:list.do";
    }

    @RequestMapping("add.do")
    public String add(TbUser user){
        if (user != null){
            userService.add(user);
        }
        return "redirect:list.do";
    }

    @RequestMapping("toUpdate.do")
    public ModelAndView toUpdate(int id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("u",userService.findOneById(id));
        mv.setViewName("updateUser");
        return mv;
    }

    @RequestMapping("update.do")
    public String update(TbUser user){
        userService.update(user);
        return "redirect:list.do";
    }

    @RequestMapping("list.do")
    public ModelAndView list(Page page){
        ModelAndView mv = new ModelAndView();
        List<TbUser> users = userService.list(page);
        int total = userService.total();
        page.calculateLast(total);
        mv.addObject("cs",users);
        mv.setViewName("allUser");
        return mv;
    }

    @RequestMapping("toList.do")
    public String toList(HttpServletRequest request){
        List<TbUser> list = userService.findAll();
        for (TbUser user : list){
            if (user.getUsername().equals(request.getParameter("username"))&&user.getPassword().equals(request.getParameter("password"))){
                return "redirect:list.do";
            }
        }
        JOptionPane.showMessageDialog(null, "用户名或密码错误！请重新登录", "认证失败！", JOptionPane.ERROR_MESSAGE);
        return "../index";
    }
}
