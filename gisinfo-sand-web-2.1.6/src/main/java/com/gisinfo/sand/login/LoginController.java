package com.gisinfo.sand.login;

import com.gisinfo.sand.core.auth.IUser;
import com.gisinfo.sand.core.auth.IUserService;
import com.gisinfo.sand.core.kaptcha.CaptchaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yuzhibin
 */
@Controller
@Profile("session")
@Api(tags = "登录管理")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private IUserService userService;

    @Autowired
    private CaptchaService captchaService;

    /**
     * 返回JSON
     * @param username
     * @param password
     * @param captcha
     * @param key
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username", value = "用户名",required =true,paramType="form"),
        @ApiImplicitParam(name = "password", value = "密码",required =true,paramType="form"),
        @ApiImplicitParam(name = "captcha", value = "验证码",required =true,paramType="form"),
        @ApiImplicitParam(name = "key", value = "密码",required =true,paramType="form")
    })
    public IUser login(String username, String password,String captcha ,String key){
//        if(SandContext.isAuth &&!captcha.equals(captchaService.getCacheToken(key))){
//            throw new LoginException("验证码不正确");
//        }
        IUser user = loginService.login(username,password);
        captchaService.disableCaptcha(key);
        return user;
    }

    /**
     * 返回页面
     * @param username
     * @param password
     * @param captcha
     * @param key
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET,produces = "text/html")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名",required =true,paramType="form"),
            @ApiImplicitParam(name = "password", value = "密码",required =true,paramType="form"),
            @ApiImplicitParam(name = "captcha", value = "验证码",required =true,paramType="form"),
            @ApiImplicitParam(name = "key", value = "密码",required =true,paramType="form")
    })
    public String loginPage(String username, String password,String captcha ,String key){
        loginService.login(username,password);
        return "hello";
    }

    @RequestMapping(value ="/logout", method = RequestMethod.POST)
    @ApiOperation(value = "退出登录")
    public void logout(){
        loginService.logout(userService.getCurrentUserObject().getLoginName());
    }
}