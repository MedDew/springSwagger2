package com.meddew.swagger2.repositories;

import com.meddew.swagger2.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepostory extends CrudRepository<Student, Long> {
}
