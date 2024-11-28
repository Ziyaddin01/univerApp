package com.example.univerapp.mapper;


import com.example.univerapp.entity.StudentEntity;
import com.example.univerapp.model.dto.StudentDTO;
import com.example.univerapp.model.request.StudentRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toDto(StudentEntity studentEntity);
    StudentEntity toEntity(StudentRequest studentRequest);



}
