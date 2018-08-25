package com.mengyuan.blog.domain.es;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="blog", type="blog")
public class EsBlog implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    private String id;
    private String title;
    private String summary;
    private String content;
    
    // JPA规范要求防止直接使用
    protected EsBlog(){
        
    }
    
    public EsBlog(String title, String summary, String content){
        this.content = content;
        this.summary = summary;
        this.title = title;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
    @Override
    public String toString() {
        return String.format("Esblog[id='%s', title='%s', summary='%s', content='%s'", id, title, summary, content);
    }
}
