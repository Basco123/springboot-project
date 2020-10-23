package com.basco.web;

import com.basco.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonalController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/personal")
    public String personal(Model model) {
        return "personal";
    }

    @GetMapping("/fragments")
    public String _fragments(Model model) {
        return "_fragments";
    }



    @GetMapping("/footer/latestBlog")
    public String latestBlogs(Model model){

        model.addAttribute("latestBlogs",blogService.listRecommendBlogTop(3));
        return "_fragments :: latestBlogsList";
    }

}
