package com.todo.list.mapper;

import com.todo.list.dao.entity.Task;
import com.todo.list.dto.request.TaskCreation;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class TaskMapper {

    public static final TaskMapper INSTANCE= Mappers.getMapper(TaskMapper.class);

    public abstract Task dtoToEntity(TaskCreation taskcreation);


}
