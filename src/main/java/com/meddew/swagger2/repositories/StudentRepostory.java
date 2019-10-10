package com.meddew.swagger2.repositories;

import com.meddew.swagger2.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
public interface StudentRepostory extends CrudRepository<Student, Long> {
}
