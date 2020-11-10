package com.codegym.service;

import com.codegym.model.Province;

import java.util.List;

public interface IProvinceService {
    List<Province> listProvince();
    Province getProvinceById(int id);
    Province getProvinceByName(String provinceName);
    void save(Province province);
    void update(int id,Province newProvince);
    void delete(int id);


}
