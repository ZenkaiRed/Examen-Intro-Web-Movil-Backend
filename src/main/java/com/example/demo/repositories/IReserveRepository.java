package com.example.demo.repositories;

import com.example.demo.entities.Reserve;
import org.springframework.stereotype.Repository;

@Repository
public interface IReserveRepository extends IBaseRepository<Reserve, Integer> {

}
