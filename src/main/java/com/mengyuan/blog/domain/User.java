package com.mengyuan.blog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

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
    
    @NotEmpty(message="姓名不能为空")
    @Size(min=2, max=20)
    @Column(nullable=false, length=20)  //映射为字段，值不能为空
    private String name;
    
    @NotEmpty(message="邮箱不能为空")
    @Size(max=50)
    @Email(message="邮箱格式不对")
    @Column(nullable=false, length=50, unique=true)  //映射为字段，值不能为空
    private String email;
    
    @NotEmpty(message="账号不能为空")
    @Size(min=3, max=20)
    @Column(nullable=false, length=20, unique=true)  //映射为字段，值不能为空
    private String username;
    
    @NotEmpty(message="密码不能为空")
    @Size(max=100)
    @Column(length=100)  //映射为字段，值不能为空
    private String password;
    
    @Column(length=200)  //映射为字段，值不能为空
    private String avatar;
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    // 防止直接使用
    protected User(){
        
    }
    
    public User(Long id, String name, String username, String email){
        this.id = id;
        this.email = email;
        this.name = name;
        this.username = username;
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
        return String.format("User[id=%d, name='%s', username='%s', email='%s'", id, name, username, email);
    }
    
}
