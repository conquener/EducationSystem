package com.ritchey.edusys.web.controller;

import com.ritchey.edusys.web.model.Users;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value =  "/user")
public class UserLoginController {
    /**
     * 用户登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@Valid Users user, BindingResult result, Model model, HttpServletRequest request){
        try {
            Subject subject = SecurityUtils.getSubject();
            if(subject.isAuthenticated()){
                return "redirect:/";
            }
            if (result.hasErrors()) {
                model.addAttribute("error", "参数错误！");
                return "login";
            }
        }catch(AuthenticationException e){

        }
        return "redirect:/";
    }



}
