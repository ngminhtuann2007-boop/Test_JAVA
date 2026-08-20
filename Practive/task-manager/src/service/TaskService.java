package service;

import java.util.UUID;
import java.util.List;

import repository.TaskRepository;
import model.Task;
import util.Validator;

public class TaskService {
    private final TaskRepository repository = new TaskRepository();

    private UUID getTaskIdByDisplayIndex(int displayIndex) {
        List<Task> tasks = repository.findAll();

        Validator.validator(displayIndex-1, tasks.size());

        return tasks.get(displayIndex - 1).getId(); 
    }

    
}