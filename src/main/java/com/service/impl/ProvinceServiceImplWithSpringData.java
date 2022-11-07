package com.service.impl;

import com.model.Province;
import com.repository.ProvinceRepository;
import com.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class ProvinceServiceImplWithSpringData extends ProvinceService {
    @Autowired
    private ProvinceRepository repository;

    @Override
    protected CrudRepository<Province, Long> repository() {
        return repository;
    }
}
