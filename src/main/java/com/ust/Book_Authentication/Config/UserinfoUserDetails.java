package com.ust.Book_Authentication.Config;

import com.ust.Book_Authentication.Model.Userinfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserinfoUserDetails implements UserDetails {
    private final String username;
    private final String password;

    public UserinfoUserDetails(Userinfo userinfo)
    {
        this.username=userinfo.getUsername();
        this.password=userinfo.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
