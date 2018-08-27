package com.mengyuan.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户主页
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/u")
public class UserspaceController {
    
    /**
     * 博客首页展示
     * @param order 排序规则 默认最新
     * @param keyword 关键字 默认无
     * @return
     */
    @GetMapping("/{username}")
    public String userSpace(@PathVariable("username") String username) {
        return "/userspace/u";
    }

    /**
     * 根据关键字查询list
     * @param username
     * @param order
     * @param category
     * @param keyword
     * @return
     */
    @GetMapping("/{username}/blogs")
    public String listBlogsByOrder(@PathVariable("username") String username,
            @RequestParam(value="order", required=false, defaultValue="new") String order,
            @RequestParam(value="category", required=false) Long category,
            @RequestParam(value="keyword", required=false) String keyword) {
        
        if (category != null) {
            return "/userspace/u";
        } else if (keyword != null && keyword.isEmpty() == false) {
            return "/userspace/u";
        }
        
        return "/userspace/u";
    }
    
    /**
     * 根据ID查询list
     * @param id
     * @return
     */
    @GetMapping("/{username}/blogs/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id) {
        return "/userspace/blog";
    }
    
    /**
     * 编辑博客
     * @return
     */
    @GetMapping("/{username}/blogs/edit")
    public String editBlog() {
        return "/userspace/blogedit";
    }
}
