package com.example.demo.services;

import com.example.demo.entities.Software;
import com.example.demo.repositories.IBaseRepository;
import com.example.demo.repositories.ISoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftwareService extends BaseService<Software, Integer> implements ISoftwareService {

    @Autowired
    private ISoftwareRepository softwareRepository;

    public SoftwareService(IBaseRepository<Software, Integer> baseRepository) {
        super(baseRepository);
    }
}
