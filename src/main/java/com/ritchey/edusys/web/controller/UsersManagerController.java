package com.ritchey.edusys.web.controller;

import com.ritchey.edusys.web.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/23.
 */
@Controller
@EnableSwagger2
@RequestMapping(value = "/userManage")
public class UsersManagerController {
    private List<Users> usersList;

    @RequestMapping(value = "/userquery")
    public void getUsersList(String username,Integer userAge){
        Map<String,Object> paramMap = new HashMap<String,Object>();

        if(username!=null && username.equals("")){
            paramMap.put("username",username);
        }
        if(userAge!=null){
            paramMap.put("userage",userAge);
        }


    }

}
