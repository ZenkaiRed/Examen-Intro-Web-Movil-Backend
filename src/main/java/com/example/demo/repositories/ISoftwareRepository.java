package com.example.demo.repositories;

import com.example.demo.entities.Software;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoftwareRepository extends IBaseRepository<Software, Integer> {

}
