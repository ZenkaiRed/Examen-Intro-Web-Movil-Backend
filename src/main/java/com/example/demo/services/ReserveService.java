package com.example.demo.services;

import com.example.demo.entities.Reserve;
import com.example.demo.repositories.IBaseRepository;
import com.example.demo.repositories.IReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReserveService extends BaseService<Reserve, Integer> implements IReserveService{

    @Autowired
    private IReserveRepository reserveRepository;

    public ReserveService(IBaseRepository<Reserve, Integer> baseRepository) {
        super(baseRepository);
    }
}
