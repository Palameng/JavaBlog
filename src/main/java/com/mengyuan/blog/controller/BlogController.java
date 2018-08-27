package com.mengyuan.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    
    /**
     * 博客首页展示
     * @param order 排序规则 默认最新
     * @param keyword 关键字 默认无
     * @return
     */
    @GetMapping
    public String listBlogs(@RequestParam(value="order", required=false, defaultValue="new") String order,
            @RequestParam(value="keyword",required=false,defaultValue="" ) String keyword)  {
        System.out.println("order:" + order + ";keyword:" + keyword);
        return "redirect:/index?order=" + order + "&keyword=" + keyword;
    }

}
