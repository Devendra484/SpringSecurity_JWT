package com.springboot.Service;

import com.springboot.Model.Jwt_Users;
import com.springboot.Repository.Jwt_UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class Jwt_UsersService {
    @Autowired
    private Jwt_UsersRepository jwtUsersRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    public Jwt_Users reg(Jwt_Users user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println(user);
        return  jwtUsersRepository.save(user);
    }

    public List<Jwt_Users> list() {
        return  jwtUsersRepository.findAll();
    }

    public Jwt_Users userById(Long id) {
        return jwtUsersRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No user found at Id :"+id) );
    }
}
