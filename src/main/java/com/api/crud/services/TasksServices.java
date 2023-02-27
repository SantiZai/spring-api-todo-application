package com.api.crud.services;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.crud.interfaces.ITaskRepository;
import com.api.crud.models.TaskModel;

@Service
public class TasksServices {
    @Autowired
    ITaskRepository taskRepository;

    public ArrayList<TaskModel> bringTasks() {
        return (ArrayList<TaskModel>) taskRepository.findAll();
    }

    public Optional<TaskModel> bringTask(Long id) {
        return taskRepository.findById(id);
    }

    public void saveTask(TaskModel task) {
        System.out.println(task);
        taskRepository.save(task);
    }

    public TaskModel updTask(TaskModel request, Long id) {
        Optional<TaskModel> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()) {
            TaskModel task = optionalTask.get();
            if (request.getTitle() != null) {
                task.setTitle(request.getTitle());
            }
            if (request.getDescription() != null) {
                task.setDescription(request.getDescription());
            }
            if (request.getLevel() != null) {
                task.setLevel(request.getLevel());
            }
            if (request.getCompleted() != null) {
                task.setCompleted(request.getCompleted());
            }
            return this.taskRepository.save(task);
        } else {
            throw new Error("Task with id: " + id + " not found.");
        }
    }

    public void delTask(Long id) {
        try {
            this.taskRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
