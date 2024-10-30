package com.ust.Book_Authentication.Config;

import com.ust.Book_Authentication.Repository.UserinfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserinfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserinfoRepo userinfoRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userinfoRepo.findByUsername(username).map(UserinfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
