package com.example.mapapp;
import org.springframework.data.repository.CrudRepository;


public interface LocationRepository extends CrudRepository<Location, Integer>{
    Location findLocationById(Integer id);
}
