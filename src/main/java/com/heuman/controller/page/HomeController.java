package com.heuman.controller.page;

import com.heuman.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by heuman on 2017/12/19.
 */
@Controller
public class HomeController {

    private final transient Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/index")
    public String index(HttpSession session, Model model) {
        if (session.getAttribute("user") != null) {
            model.addAttribute("username", ((User)session.getAttribute("user")).getUsername());
            return "index";
        }
        return "logout";
    }

}
