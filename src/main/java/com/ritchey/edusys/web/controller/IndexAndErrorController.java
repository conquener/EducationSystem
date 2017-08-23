package com.ritchey.edusys.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Administrator on 2017/8/17.
 */
@Controller
@EnableSwagger2
@RequestMapping(value = "/page")
public class IndexAndErrorController {

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
     * 用户信息
     * @return
     */
    @RequestMapping("/userInfo")
    @ApiOperation(value = "查询/修改用户信息",notes = "进入用户信息界面，查询或者修改用户信息")
    public  String userInfo(){
        return "userInfo";
    }

    /**
     * 角色信息
     * @return
     */
    @RequestMapping("/roleInfo")
    @ApiOperation(value = "查询/修改角色信息",notes = "进入角色信息界面，查询或者修改角色信息")
    public  String roleInfo(){
        return "roleInfo";
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
