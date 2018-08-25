package com.mengyuan.blog.repository;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mengyuan.blog.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
    
//    User saveOrUpdateUser(User user);
//    
//    void deleteUser(Long id);
//    
//    User getUserById(Long id);
//    
//    List<User> getUserList();
}
