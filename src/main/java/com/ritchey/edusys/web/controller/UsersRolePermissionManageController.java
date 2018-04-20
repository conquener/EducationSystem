package com.ritchey.edusys.web.controller;

import com.ritchey.edusys.core.feature.orm.mybatis.Page;
import com.ritchey.edusys.core.util.Constants;
import com.ritchey.edusys.core.util.FtpUtils;
import com.ritchey.edusys.web.model.Role;
import com.ritchey.edusys.web.model.Users;
import com.ritchey.edusys.web.service.IUserRelationService;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统用户管理
 * @author  Ritchey Huang
 * Created by Administrator on 2017/10/23.
 */
@Controller
@EnableSwagger2
@RequestMapping(value = "/urpManage")
public class UsersRolePermissionManageController {
    @Autowired
    private IUserRelationService userRelationService;
    /**
     * 用户信息查询
     * @return
     */
    @RequestMapping(value = "/userquery",method = RequestMethod.GET)
    @ApiOperation(value = "查询/修改用户信息",notes = "进入用户信息界面，查询或者修改用户信息")
    public String getUsersList(HttpServletRequest request, String username, Integer userAge,Integer indexPage,Integer pageSize){
        if(indexPage==null || indexPage == 0){
            indexPage = 1;
        }
        if (pageSize == null || pageSize == 0){
            pageSize = 15;
        }

        Map<String,Object> paramMap = new HashMap<String,Object>();

        if(username!=null && !"".equals(username.trim())){
            paramMap.put("username",username);
        }
        if(userAge!=null){
            paramMap.put("userage",userAge);
        }
        Page<Users> page = new Page<Users>(indexPage,pageSize);
        page = userRelationService.selectUsersList(paramMap,page);
        request.setAttribute("page",page);
        request.setAttribute("username",username);
        request.setAttribute("userage",username);
        request.setAttribute("indexPage",indexPage);
        request.setAttribute("pageSize",pageSize);
        return "user/userInfo";
    }

    /**
     * 角色信息
     * @return
     */
    @RequestMapping("/roleInfo")
    @ApiOperation(value = "查询/修改角色信息",notes = "进入角色信息界面，查询或者修改角色信息")
    public  String roleInfo(HttpServletRequest request,String roleName,Integer indexPage,Integer pageSize){
        if(indexPage==null || indexPage == 0){
            indexPage = 1;
        }
        if (pageSize == null || pageSize == 0){
            pageSize = 15;
        }

        Map<String,Object> paramMap = new HashMap<String,Object>();

        if(roleName!=null && !"".equals(roleName.trim())){
            paramMap.put("roleName",roleName);
        }
        Page<Role> page = new Page<Role>(indexPage,pageSize);
        page = userRelationService.selectRolesList(paramMap,page);
        request.setAttribute("page",page);
        request.setAttribute("indexPage",indexPage);
        request.setAttribute("pageSize",pageSize);
        return "role/roleInfo";
    }

    /**
     * 修改个人信息
     * @return
     */
    @RequestMapping(value = "/modifyUserInfo")
    @ApiOperation(value = "查询/修改个人信息",notes = "进入权限信息界面，查询或者修改个人信息")
    public  String modifyUserInfo(HttpServletRequest request){
        return "modifyUserInfo";
    }

    /**
     *
     */
    @RequestMapping(value = "/uploadUserInfoFile" ,produces = "text/html;charset=utf-8" )
    @ResponseBody
    @ApiOperation(value = "上传个人信息档案",notes = "上传个人信息档案")
    public  String uploadUserInfoFile(@RequestParam("userInfoFile")MultipartFile file,HttpServletRequest request)
        throws Exception{
        String name = null;
        String path = null;
        String result = null;
        InputStream fileInput  = file.getInputStream();
        name = file.getOriginalFilename();
        path = file.getOriginalFilename();

        FtpUtils ftpUtils = new FtpUtils();
        if (ftpUtils.loginFtpCilent()){
            if(ftpUtils.uploadFtp(path,name,fileInput)){
                result =  "success";
            }else{
                result =  "error";
            }
        }else{
            result =  "error";
        }
        fileInput.close();
        return  result;
    }

}
