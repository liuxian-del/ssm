package com.gisinfo.sand.user;

import com.gisinfo.sand.core.auth.IUser;
import com.gisinfo.sand.core.auth.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuzhibin
 */
@RestController
@Api(tags = "用户管理")
public class UserController  {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/user/info", method = RequestMethod.POST)
    @ApiOperation(value = "获取当前用户信息")
    public IUser user(){
        return userService.getCurrentUserObject();
    }

}
