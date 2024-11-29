package com.example.univerapp.service.impl;

import com.example.univerapp.entity.Teacher;
import com.example.univerapp.mapper.TeacherMapper;
import com.example.univerapp.model.dto.TeacherDTO;
import com.example.univerapp.model.request.TeacherRequest;
import org.mapstruct.Mapper;

@Mapper
public class TeacherMapperImpl implements TeacherMapper {
    @Override
    public TeacherDTO toDTOTeacherDto(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(teacher.getId());
        teacherDTO.setFirstName(teacher.getFirstName());
        teacherDTO.setLastName(teacher.getLastName());
        teacherDTO.setSubject(teacher.getSubject());
        teacherDTO.setEmail(teacher.getEmail());
        return teacherDTO;
    }

    @Override
    public Teacher toEntityTeacher(TeacherRequest teacherRequest) {
        if (teacherRequest == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.setSubject(teacherRequest.getSubject());
        teacher.setEmail(teacherRequest.getEmail());
        return teacher;
    }
}
