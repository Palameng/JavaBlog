package com.mengyuan.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mengyuan.blog.domain.es.EsBlog;
import com.mengyuan.blog.repository.EsBlogRepository;

@RestController
@RequestMapping("/esblogs")
public class EsBlogController {
    
    @Autowired
    private EsBlogRepository esBlogRepository;
    
    /**
     * http://localhost:8080/blogs?title=A2&summary=C1&content=F2
     * @param title
     * @param summary
     * @param content
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping
    public List<EsBlog> list(@RequestParam(value="title") String title, 
            @RequestParam(value="summary") String summary, 
            @RequestParam(value="content") String content,
            @RequestParam(value="pageIndex", defaultValue="0") int pageIndex,
            @RequestParam(value="pageSize", defaultValue="10") int pageSize){
    
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(
                title, summary, content, pageable);
        
        return page.getContent();
    }
    
    
}
