package com.ritchey.edusys.web.controller;

import com.ritchey.edusys.web.model.Users;
import com.ritchey.edusys.web.service.IUserRelationService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Administrator on 2017/8/16.
 * @author Ritchey huang
 */
@Controller
@EnableSwagger2
@RequestMapping(value =  "/user")
public class UserLoginController {
    private static final Logger log = Logger.getLogger(UserLoginController.class);
    @Autowired
    public IUserRelationService userRelationService;

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "用户登录",notes = "用户登录验证")
    @ApiImplicitParams({@ApiImplicitParam(paramType ="Users",name = "user",value = "用户名密码")})
    public String login(@Valid Users user, BindingResult result, Model model, HttpServletRequest request){
        try {
            Subject subject = SecurityUtils.getSubject();
            if(subject.isAuthenticated()){
                return "index";
            }
            if (result.hasErrors()) {
                model.addAttribute("error", "参数错误！");
                return "login";
            }
            // 身份验证
            subject.login(new UsernamePasswordToken(user.getUserName(), user.getUserPwd()));
            // 验证成功在Session中保存用户信息
            final Users authUserInfo = userRelationService.selectUserByUserName(user.getUserName());
            request.getSession().setAttribute("userInfo", authUserInfo);
        }catch(AuthenticationException e){
            log.error(e.getMessage());
            // 身份验证失败
            model.addAttribute("error", "用户名或密码错误 ！");
            return "login";
        }
        return "index";
    }

    /**
     * 用户登出
     * @param session
     * @return
     */
    @RequestMapping(value = "loginOut",method = RequestMethod.GET)
    @ApiOperation(value = "用户登出系统",notes = "用户退出系统操作")
    @ApiImplicitParam(value = "HttpSession",name = "session",dataType = "HttpSession")
    public String loginOut(HttpSession session){
        session.removeAttribute("userInfo");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return  "login";
    }

}

