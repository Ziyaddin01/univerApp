package com.example.univerapp.controller;

import com.example.univerapp.entity.StudentEntity;
import com.example.univerapp.model.dto.StudentDTO;
import com.example.univerapp.model.request.StudentRequest;
import com.example.univerapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{email}")
    public List<StudentEntity> getStudents(@PathVariable String email) {
        return studentService.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody StudentEntity studentEntity) {
        studentService.addNewStudent(studentEntity);
    }
    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path = "update_students")
    public void updateStudent(@PathVariable("id") Long id,
                              @RequestBody(required = false) String first_name,
                              @RequestParam(required = false)String email){
        studentService.updateStudent(id, first_name, email);
    }
    @PostMapping("create_student")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentRequest studentRequest) {
        StudentDTO createStudent = studentService.createStudent(studentRequest);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createStudent);
    }
    @GetMapping()
    public ResponseEntity<Page<StudentEntity>>getStudents(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size) {
        Page<StudentEntity> students = studentService.getStudents(page,size);
        return ResponseEntity.ok(students);
    }
}
