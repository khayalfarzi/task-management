package az.iktlab.taskmanagement.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "The Task Model")
public class TaskDto {

    @Schema(description = "Task id", example = "123")
    private Long id;

    @Schema(description = "Task Name", example = "Add new task")
    private String name;

    private String description;
    private TaskPriority priority;
    private LocalDateTime deadline;
    private TaskStatus status;
}
