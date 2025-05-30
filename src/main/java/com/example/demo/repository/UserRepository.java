package com.example.demo.repository;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.User;

    @Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User hoidanit);//insert into values()
    List<User> findOneByEmail(String email);
    List<User> findAll();
    User findById(long id);
    void deleteById(long id);
    boolean existsByEmail(String email);

}
