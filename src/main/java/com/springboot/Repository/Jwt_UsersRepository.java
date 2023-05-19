package com.springboot.Repository;

import com.springboot.Model.Jwt_Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Jwt_UsersRepository extends JpaRepository<Jwt_Users,Long> {

    Optional<Jwt_Users> findByName(String username);

}
