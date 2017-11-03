package com.ritchey.edusys.web.controller;

import com.ritchey.edusys.core.feature.orm.mybatis.Page;
import com.ritchey.edusys.web.model.Role;
import com.ritchey.edusys.web.model.Users;
import com.ritchey.edusys.web.service.IUserRelationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ritchey Huang
 * Created by Administrator on 2017/8/17.
 */
@Controller
@EnableSwagger2
@RequestMapping(value = "/page")
public class IndexAndErrorController {
    @Autowired
    private IUserRelationService userRelationService;
    /**
     * 登录页
     */
    @RequestMapping("/login")
   @ApiOperation(value = "系统登录",notes = "进入系统登录界面")
    public String login() {
        return "login";
    }

    /**
     * 首页
     */
    @RequestMapping("/dashboard")
    @ApiOperation(value = "首页",notes = "进入首页")
    public String dashboard() {
        return "dashboard";
    }

    /**
     * group
     * @return
     */
    @RequestMapping("/groupInfo")
    @ApiOperation(value = "查询/修改Group信息",notes = "进入Group信息界面，查询或者修改Group信息")
    public  String groupInfo(){
        return "groupInfo";
    }

    /**
     * 权限
     * @return
     */
    @RequestMapping("/permissionInfo")
    @ApiOperation(value = "查询/修改权限信息",notes = "进入权限信息界面，查询或者修改权限信息")
    public  String permissionInfo(){
        return "permissionInfo";
    }


    /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    /**
     * 401页
     */
    @RequestMapping("/401")
    public String error401() {
        return "401";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
        return "500";
    }

}
