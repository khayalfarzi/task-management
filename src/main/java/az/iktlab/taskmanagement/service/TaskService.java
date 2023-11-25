package az.iktlab.taskmanagement.service;

import az.iktlab.taskmanagement.dao.repository.TaskRepository;
import az.iktlab.taskmanagement.model.dto.TaskDto;
import org.springframework.stereotype.Service;

import static az.iktlab.taskmanagement.mapper.TaskMapper.INSTANCE;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(TaskDto task) {
        var entity = INSTANCE.toEntity(task);
       entity = taskRepository.save(entity);
    }
}
