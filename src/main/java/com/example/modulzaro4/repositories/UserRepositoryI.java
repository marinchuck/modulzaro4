package com.example.modulzaro4.repositories;

import com.example.modulzaro4.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryI extends JpaRepository<User, Long> {

}
