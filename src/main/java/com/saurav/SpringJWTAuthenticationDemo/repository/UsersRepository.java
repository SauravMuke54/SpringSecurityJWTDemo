package com.saurav.SpringJWTAuthenticationDemo.repository;

import com.saurav.SpringJWTAuthenticationDemo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    Users findByUsername(String username);
}
