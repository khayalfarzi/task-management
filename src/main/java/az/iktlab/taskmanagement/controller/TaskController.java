package az.iktlab.taskmanagement.controller;

import az.iktlab.taskmanagement.model.dto.TaskDto;
import az.iktlab.taskmanagement.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @Operation(summary = "This endpoint help us to add new task",
            responses = {
                    @ApiResponse(responseCode = "200", description = "The request was successful"),
                    @ApiResponse(responseCode = "400",
                            description = "There is incoming request validation error"),
                    @ApiResponse(responseCode = "409",
                            description = "There is a conflict with the current state of the resource, " +
                                    "preventing the request from being completed."),
                    @ApiResponse(responseCode = "417",
                            description = "The server cannot meet the expectations specified in the request"),
                    @ApiResponse(responseCode = "500", description = "An unexpected error occurred on the server.")
            })
    public void addTask(@RequestBody TaskDto task) {
        taskService.addTask(task);
    }
}
