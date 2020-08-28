package com.codegym.demo.service.impl;

import com.codegym.demo.model.Province;
import com.codegym.demo.repository.ProvinceRepository;
import com.codegym.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public List<Province> getAllProvince() {
        return provinceRepository.findAll();
    }
}
