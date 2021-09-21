package com.gb.springthymeleafproduct.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "auth/loginPage";
    }

    @GetMapping("/userInfo")
    public String getUserInfo(Model uiModel) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        uiModel.addAttribute ("userName", auth.getName());
        uiModel.addAttribute ("role", auth.getAuthorities().toString());
        return "auth/userInfo";
    }

}