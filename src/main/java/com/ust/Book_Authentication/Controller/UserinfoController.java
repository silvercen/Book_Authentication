package com.ust.Book_Authentication.Controller;

import com.netflix.discovery.converters.Auto;
import com.ust.Book_Authentication.Model.Userinfo;
import com.ust.Book_Authentication.Service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserinfoController {
    @Autowired
    private UserinfoService userinfoService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public Userinfo addUser(@RequestBody Userinfo userinfo){
        return userinfoService.saveUser(userinfo);
    }

    @GetMapping("/validate/{token}")
    public boolean validateToken(@PathVariable String token){
        return userinfoService.validateToken(token);
    }

    @PostMapping("/validate/user")
    public String validateUser(@RequestBody Userinfo userinfo){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userinfo.getUsername(),userinfo.getPassword()));
        if(authentication.isAuthenticated())
        {
            return userinfoService.generateToken(userinfo.getUsername());
        }
        else
        {
            return "User not authenticated!";
        }
    }
}
