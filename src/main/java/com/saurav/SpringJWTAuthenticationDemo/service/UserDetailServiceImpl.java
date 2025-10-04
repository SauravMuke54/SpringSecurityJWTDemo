package com.saurav.SpringJWTAuthenticationDemo.service;

import com.saurav.SpringJWTAuthenticationDemo.entity.UserPrincipal;
import com.saurav.SpringJWTAuthenticationDemo.entity.Users;
import com.saurav.SpringJWTAuthenticationDemo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepository.findByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("Username not found");
        }

        return new UserPrincipal(user);

    }
}
