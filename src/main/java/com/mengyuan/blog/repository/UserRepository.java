package com.mengyuan.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.List;

//import org.springframework.data.repository.CrudRepository;

import com.mengyuan.blog.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
//    User saveOrUpdateUser(User user);
//    
//    void deleteUser(Long id);
//    
//    User getUserById(Long id);
//    
//    List<User> getUserList();
    
    Page<User> findByNameLike(String name, Pageable pageable);
    
    User findByUsername(String username);
    
}
