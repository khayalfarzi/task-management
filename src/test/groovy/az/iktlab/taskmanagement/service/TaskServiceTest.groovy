package az.iktlab.taskmanagement.service

import az.iktlab.taskmanagement.dao.repository.TaskRepository
import az.iktlab.taskmanagement.mapper.TaskMapper
import az.iktlab.taskmanagement.model.dto.TaskDto
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class TaskServiceTest extends Specification {

    private TaskService taskService
    private TaskRepository taskRepository

    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    def "setup"() {
        taskRepository = Mock()
        taskService = new TaskService(taskRepository)
    }

    def "addTask - SUCCESS case"() {
        given:
        def dto = random.nextObject(TaskDto)
        def entity = TaskMapper.INSTANCE.toEntity(dto)

        when:
        taskService.addTask(dto)

        then:
        taskRepository.save(entity) >> entity
    }
}
