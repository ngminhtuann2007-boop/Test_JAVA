package repository;

import model.Task;
import service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepository{
    private final List<Task> tasks = new ArrayList<>();
    
    
    public void save(Task task){ tasks.add(task); }

    public List<Task> findAll(){ return tasks; }
    
    public Task findById(UUID id){
        return tasks.stream()
                    .filter(task -> task.getId().equals(id))
                    .findFirst()
                    .orElse(null);
    }

    public void deleteBtId(UUID id){}
    
}