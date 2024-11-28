package com.example.univerapp.service.impl;

import com.example.univerapp.entity.StudentEntity;
import com.example.univerapp.mapper.StudentMapper;
import com.example.univerapp.model.dto.StudentDTO;
import com.example.univerapp.model.request.StudentRequest;
import org.mapstruct.Mapper;

@Mapper
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDTO toDto(StudentEntity studentEntity) {
        if (studentEntity == null) {
            return null;
        }
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentEntity.getId());
        studentEntity.setFirst_name(studentEntity.getFirst_name());
        studentEntity.setLast_name(studentEntity.getLast_name());
        studentEntity.setEmail(studentEntity.getEmail());
        studentEntity.setPhone_number(studentEntity.getPhone_number());
        studentEntity.setAge(studentEntity.getAge());
        return studentDTO;
    }
    @Override
    public StudentEntity toEntity(StudentRequest studentRequest) {
        if (studentRequest == null) {
            return null;
        }
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirst_name(studentRequest.getFirst_name());
        studentEntity.setLast_name(studentRequest.getLast_name());
        studentEntity.setEmail(studentRequest.getEmail());
        studentEntity.setPhone_number(studentRequest.getPhone_number());
        studentEntity.setAge(studentRequest.getAge());
        return studentEntity;
    }
}
