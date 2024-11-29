package com.example.univerapp.service;

import com.example.univerapp.entity.StudentEntity;
import com.example.univerapp.entity.Teacher;
import com.example.univerapp.mapper.TeacherMapper;
import com.example.univerapp.model.dto.TeacherDTO;
import com.example.univerapp.model.request.TeacherRequest;
import com.example.univerapp.repository.TeacherRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }


    public void addNewTeacher(Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepository.findByTeacherByEmail((teacher.getEmail()));
        if (teacherOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long teacherId) {
        boolean exists = teacherRepository.existsById(teacherId);
        if (!exists) {
            throw new IllegalStateException("teacherId with" + teacherId + " does not exist" );
        }
        teacherRepository.deleteById(teacherId);
    }
    public TeacherDTO createTeacher(TeacherRequest teacherRequest) {
        Teacher teacher = teacherMapper.toEntityTeacher(teacherRequest);
        return teacherMapper.toDTOTeacherDto(teacher);
    }
}
