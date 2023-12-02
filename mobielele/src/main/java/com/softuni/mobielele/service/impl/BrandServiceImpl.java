package com.softuni.mobielele.service.impl;

import com.softuni.mobielele.model.dto.BrandDto;
import com.softuni.mobielele.model.dto.ModelDto;
import com.softuni.mobielele.model.entity.ModelEntity;
import com.softuni.mobielele.repository.ModelRepository;
import com.softuni.mobielele.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class BrandServiceImpl implements BrandService {
    private ModelRepository modelRepository;

    public BrandServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<BrandDto> getAllBrands() {


        Map<String, BrandDto> brands = new TreeMap<>();

        for (ModelEntity model: modelRepository.findAll()){
            if (!brands.containsKey(model.getBrand().getBrand())) {
                brands.put(model.getBrand().getBrand(),
                        new BrandDto(model.getBrand().getBrand(),
                                new ArrayList<>()));
            }
            brands.get(model.getBrand().getBrand()).models().add(
                    new ModelDto(model.getId(), model.getName()));
        }

        return brands.values().stream().toList();
    }
}
