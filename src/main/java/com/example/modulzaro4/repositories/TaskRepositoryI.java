package com.example.modulzaro4.repositories;

import com.example.modulzaro4.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepositoryI extends JpaRepository<Task, Long> {

}
