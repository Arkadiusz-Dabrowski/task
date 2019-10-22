package com.example.task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface ObjectRepository extends CrudRepository<ObjectForDatabase, String> {
}
