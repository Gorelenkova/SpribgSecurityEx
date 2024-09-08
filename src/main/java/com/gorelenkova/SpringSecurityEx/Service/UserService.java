package com.gorelenkova.SpringSecurityEx.Service;

import com.gorelenkova.SpringSecurityEx.Model.Users;
import com.gorelenkova.SpringSecurityEx.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    public String verify(Users users) {
        Authentication aut =
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(),users.getPassword()));
        if(aut.isAuthenticated()){
            return jwtService.generateToken(users.getUsername());
        }else{
            return "fail";
        }
    }
}
