package com.example.univerapp.repository;

import com.example.univerapp.entity.StudentEntity;
import com.example.univerapp.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE t.email =?1")
    Optional<Teacher> findByTeacherByEmail(String username);
    Optional<Teacher> findByUsername(String  username);
}
