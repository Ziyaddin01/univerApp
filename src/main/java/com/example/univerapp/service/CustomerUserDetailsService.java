package com.example.univerapp.service;

import com.example.univerapp.entity.CustomerUserDetails;
import com.example.univerapp.repository.StudentRepository;
import com.example.univerapp.repository.TeacherRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomerUserDetailsService implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public CustomerUserDetailsService(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var student = studentRepository.findByUsername(username);
        if (student.isPresent()) {
            return new CustomerUserDetails(student.get().getUsername(),
                    student.get().getPassword(),
                    student.get().getRole());
        }
        var teacher = teacherRepository.findByUsername(username);
        if (teacher.isPresent()) {
            return new CustomerUserDetails(teacher.get().getUsername(),
                    teacher.get().getPassword(),
                    teacher.get().getRole());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
