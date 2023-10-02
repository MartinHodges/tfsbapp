package com.example.demo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoLaterRepo extends CrudRepository<DoLaterEntity, Long> {

    public List<DoLaterEntity> findAll();
}
