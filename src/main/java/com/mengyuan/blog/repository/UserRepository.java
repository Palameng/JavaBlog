package com.mengyuan.blog.repository;

import java.util.List;

import com.mengyuan.blog.domain.User;

public interface UserRepository {
    
    User saveOrUpdateUser(User user);
    
    void deleteUser(Long id);
    
    User getUserById(Long id);
    
    List<User> getUserList();
}
