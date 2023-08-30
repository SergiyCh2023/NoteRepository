package com.example.Note.feature.user;

import com.example.Note.feature.auth.CustomUserDetailsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE name = :name")
    User searchUserByName(@Param("name") String name);





}
