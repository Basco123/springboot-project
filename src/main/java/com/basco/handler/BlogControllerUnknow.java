package com.basco.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BlogControllerUnknow {
    @GetMapping("/blog-admin-list")
    public String blogs(){
        return "admin/blog-admin-list";
    }
}
