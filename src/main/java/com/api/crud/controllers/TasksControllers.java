package com.api.crud.controllers;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.api.crud.models.TaskModel;
import com.api.crud.services.TasksServices;

@RestController
@RequestMapping("/api/tasks")
public class TasksControllers {
    @Autowired
    private TasksServices tasksServices;

    @GetMapping
    public ArrayList<TaskModel> getTasks() {
        return this.tasksServices.bringTasks();
    }

    @GetMapping(path = "/{id}")
    public Optional<TaskModel> getTask(@PathVariable Long id) {
        return this.tasksServices.bringTask(id);
    }

    @PostMapping
    public void createTask(@RequestBody TaskModel task) {
        this.tasksServices.saveTask(task);
    }

    @PatchMapping(path = "/{id}")
    public TaskModel updateTask(@RequestBody TaskModel task, @PathVariable Long id) {
        return this.tasksServices.updTask(task, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTask(@PathVariable Long id) {
        this.tasksServices.delTask(id);
    }
}
