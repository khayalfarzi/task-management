package az.iktlab.taskmanagement.mapper;

import az.iktlab.taskmanagement.dao.entity.TaskEntity;
import az.iktlab.taskmanagement.model.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskEntity toEntity(TaskDto dto);
}
