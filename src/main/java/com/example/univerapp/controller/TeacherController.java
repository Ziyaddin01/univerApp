package com.example.univerapp.controller;

import com.example.univerapp.entity.Teacher;
import com.example.univerapp.model.dto.TeacherDTO;
import com.example.univerapp.model.request.TeacherRequest;
import com.example.univerapp.service.StudentService;
import com.example.univerapp.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/teachers")
public class TeacherController {
    private final TeacherService teacherService;
    private final StudentService studentService;

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping
    public List<Teacher> getTeachers() {
        return teacherService.getAllTeachers();
    }
    @PostMapping
    public void registerNewTeacher(@RequestBody Teacher teacher) {
        teacherService.addNewTeacher(teacher);
    }

    @DeleteMapping("{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }
    @PutMapping
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherRequest teacherRequest) {
        TeacherDTO createTeacher = teacherService.createTeacher(teacherRequest);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createTeacher);

    }
}
