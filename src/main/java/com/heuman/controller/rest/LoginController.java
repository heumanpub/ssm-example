package com.heuman.controller.rest;

import com.heuman.common.utils.PathUtil;
import com.heuman.config.Config;
import com.heuman.domain.User;
import com.heuman.service.UserService;
import com.heuman.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by heuman on 2017/12/19.
 */
@Controller
public class LoginController {

    private final transient Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/json"})
    @ResponseBody
    public Object login(@RequestBody User user, HttpSession session) {
        if (logger.isDebugEnabled()) {
            logger.debug(user.toJson());
        }
        // 已经登录
        if (session.getAttribute("user") != null) {
            return Result.newSuccessResult().toJson();
        }
        String errorMsg;
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            errorMsg = "用户名和密码不能为空";
        } else {
            User u = userService.findByUsernamePassword(user);
            if (u == null) {
                errorMsg = "用户名或密码错误";
            } else {
                if (logger.isInfoEnabled()) {
                    logger.info("####### {} login #######", u.getUsername());
                }
                session.setAttribute("user", u);
                return Result.newSuccessResult().toJson();
            }
        }
        Result result = Result.newErrorResult();
        result.setMsg(errorMsg);
        return result.toJson();
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return PathUtil.append("redirect:", Config.getPagesPath(), "/index");
    }
}
