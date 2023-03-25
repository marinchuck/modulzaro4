package com.example.modulzaro4.controllers;

import com.example.modulzaro4.dtos.TaskDTO;
import com.example.modulzaro4.exceptions.ResourceNotFoundException;
import com.example.modulzaro4.models.Task;
import com.example.modulzaro4.services.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private final TaskService taskService;

    @Autowired
    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/task")
    public String getTasks(@RequestParam Long id, Model model){
        try{
            Task task = taskService.getTaskByID(id);
            model.addAttribute("task", task);
        }
        catch (ResourceNotFoundException exception){
            model.addAttribute("error", exception.getMessage());
        }
        return "task";
    }

//    Készíts egy egyszerű REST megjelenítő oldalt ahol le tudod kérdezni a task adatait.
//    Itt a visszaadott JSON egy Task-User hibrid osztályból álljon elő ami tartalmazza a task
//    adatokat és a kapcsolódó user nevét. (10p)

    @ResponseBody
    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDTO> getJSONTask(@PathVariable String id){
            TaskDTO task = taskService.getTaskDTOByTaskID(Long.valueOf(id));
            return ResponseEntity.ok(task);
    }

    @ExceptionHandler({ ResourceNotFoundException.class })
    public ResponseEntity<String> handleException(ResourceNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


//    Készíts egy egyszerű REST api endpointot ahol törölni tudjuk az egyes taskokat. (15p)
    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable String id){
        taskService.deleteTaskById(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }

}
