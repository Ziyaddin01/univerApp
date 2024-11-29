package com.example.univerapp.mapper;

import com.example.univerapp.entity.Teacher;
import com.example.univerapp.model.dto.TeacherDTO;
import com.example.univerapp.model.request.TeacherRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherDTO toDTOTeacherDto(Teacher teacher);
    Teacher toEntityTeacher(TeacherRequest teacherRequest);
}