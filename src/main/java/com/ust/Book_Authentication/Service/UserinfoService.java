package com.ust.Book_Authentication.Service;

import com.ust.Book_Authentication.Model.Userinfo;
import com.ust.Book_Authentication.Repository.UserinfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserinfoService {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserinfoRepo userinfoRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Userinfo saveUser(Userinfo userinfo){
        userinfo.setPassword(passwordEncoder.encode(userinfo.getPassword()));
        return userinfoRepo.save(userinfo);
    }

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }

    public boolean validateToken(String token){
        jwtService.validateToken(token);
        return true;
    }
}
