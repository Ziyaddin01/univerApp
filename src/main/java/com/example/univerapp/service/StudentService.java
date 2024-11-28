package com.example.univerapp.service;

import com.example.univerapp.entity.StudentEntity;
import com.example.univerapp.exception.StudentNotFoundException;
import com.example.univerapp.mapper.StudentMapper;
import com.example.univerapp.model.dto.StudentDTO;
import com.example.univerapp.model.request.StudentRequest;
import com.example.univerapp.repository.StudentRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Data
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

    public Page<StudentEntity> getStudents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return studentRepository.findAll(pageable);
    }

    public StudentDTO findStudentById(Long id) {
        logger.info("Find student by id" + id);
        StudentEntity student = studentRepository.findById(id).orElseThrow(() -> new
                StudentNotFoundException("Student not found with ID: " + id));
        return studentMapper.toDto(student);
    }

    public StudentDTO createStudent(StudentRequest studentRequest) {
        StudentEntity student = studentMapper.toEntity(studentRequest);
        return studentMapper.toDto(student);
    }

    public List<StudentEntity> getStudents() {
        return studentRepository.findAll();
    }
    public void addNewStudent(StudentEntity studentEntity) {
        Optional<StudentEntity> studentEntityOptional = studentRepository.findByStudentEntityByEmail((studentEntity.getEmail()));
        if (studentEntityOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(studentEntity);
    }
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }
    public void updateStudent(Long studentId,
                              String first_name,
                              String email) {
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));

        if (first_name != null && !first_name.isEmpty() && !Objects.equals(studentEntity.getFirst_name(), first_name)) {
            studentEntity.setFirst_name(first_name);
        }
        if (email != null && !email.isEmpty() && !Objects.equals(studentEntity.getEmail(), email)) {
            Optional<StudentEntity> studentEntityOptional = studentRepository.findByStudentEntityByEmail(email);
            if (studentEntityOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            studentEntity.setFirst_name(email);
        }
    }

}
