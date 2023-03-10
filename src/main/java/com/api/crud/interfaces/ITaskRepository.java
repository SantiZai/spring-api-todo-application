package com.api.crud.interfaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.models.TaskModel;

@Repository
public interface ITaskRepository extends JpaRepository<TaskModel, Long> {
    
}
