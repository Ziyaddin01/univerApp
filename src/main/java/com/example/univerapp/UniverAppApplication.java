package com.example.univerapp;


import com.example.univerapp.entity.StudentEntity;
import com.example.univerapp.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class UniverAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniverAppApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            StudentEntity studentEntity = new StudentEntity(
                    "Ziya","Huseynov","ziya.hus2001@mail.ru","0516600773",23);
            studentRepository.save(studentEntity);
        };
    }
}
