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

        if(username!=null && !username.equals("")){
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
            pageSize = 1;
        }

        Map<String,Object> paramMap = new HashMap<String,Object>();

        if(roleName!=null && !roleName.equals("")){
            paramMap.put("roleName",roleName);
        }
        Page<Role> page = new Page<Role>(indexPage,pageSize);
        page = userRelationService.selectRolesList(paramMap,page);
        request.setAttribute("page",page);
        request.setAttribute("indexPage",indexPage);
        request.setAttribute("pageSize",pageSize);
        return "role/roleInfo";
    }

}
