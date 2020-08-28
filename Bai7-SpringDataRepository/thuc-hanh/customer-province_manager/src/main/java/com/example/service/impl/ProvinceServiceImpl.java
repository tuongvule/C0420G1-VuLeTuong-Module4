package com.example.service.impl;

import com.example.model.Province;
import com.example.repository.ProvinceRepository;
import com.example.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<Province> getAllProvince() {
        return provinceRepository.findAll();
    }
}
