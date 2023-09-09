package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends IBaseRepository<User, Integer> {

}