package com.gorelenkova.SpringSecurityEx.Repository;

import com.gorelenkova.SpringSecurityEx.Model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}