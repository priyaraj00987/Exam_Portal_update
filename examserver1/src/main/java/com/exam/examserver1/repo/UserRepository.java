package com.exam.examserver1.repo;

import com.exam.examserver1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long>{

    public User findByUsername(String username);


}
