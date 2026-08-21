package service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import dto.TaskRequest;
import repository.TaskRepository;
import model.Task;
import model.TaskStatus;
import util.Input;
import util.Validator;
import exception.InvalidTaskException;
import exception.TaskNotFoundException;

public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(TaskRequest request) {
        if (request.getTitle() == null || request.getTitle().isBlank()) {
            throw new InvalidTaskException("Tên task không được để trống!");
        }
        Task task = new Task(
            request.getTitle(),
            request.getDescription(),
            request.getPriority(),
            TaskStatus.TODO,
            LocalDateTime.now()
        );
        repository.save(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    private UUID getTaskIdByDisplayIndex(int displayIndex) {
        List<Task> tasks = repository.findAll();

        Validator.validatorDisplayIndex(displayIndex-1, tasks.size());

        return tasks.get(displayIndex - 1).getId(); 
    }

    public void deleteTaskByDisplayIndex(int displayIndex) {
        UUID id = getTaskIdByDisplayIndex(displayIndex);
        repository.deleteById(id);
    }

    public Task updateTask(int displayIndex, TaskRequest updatedTaskData) {
        UUID id = getTaskIdByDisplayIndex(displayIndex);

        // 2. Kiểm tra dữ liệu mới truyền vào có hợp lệ không
        if (updatedTaskData == null || updatedTaskData.getTitle() == null || updatedTaskData.getTitle().isBlank()) {
            throw new InvalidTaskException("Tên task không được để trống!");
        }

        Task existingTask = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Không tìm thấy task để cập nhật!"));

        existingTask.setTitle(updatedTaskData.getTitle());
        existingTask.setDescription(updatedTaskData.getDescription());
        existingTask.setPriority(updatedTaskData.getPriority());
        existingTask.setStatus(TaskStatus.TODO);

        return existingTask;
    }
}