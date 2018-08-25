package com.mengyuan.blog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户实体
 * @author MengYuan
 *
 */
@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)   //自增
    private Long id;    //主键
    private String name;
    private String email;
    
    // 防止直接使用
    protected User(){
        
    }
    
    public User(Long id, String name, String email){
        this.id = id;
        this.email = email;
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String toString() {
        return String.format("User[id=%d, name='%s', email='%s'", id, name, email);
    }
    
}
