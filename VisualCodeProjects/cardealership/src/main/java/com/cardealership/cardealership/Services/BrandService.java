package com.cardealership.cardealership.Services;

import org.springframework.stereotype.Service;

import com.cardealership.cardealership.infrastructure.BrandRepository;
import com.cardealership.cardealership.models.Brands;

@Service
public class BrandService {
    private final BrandRepository _brandRepository;

    public BrandService(BrandRepository brandRepository) {
        _brandRepository = brandRepository;
    }

    public boolean addBrand(String brandName) throws Exception {
        var brandExist = _brandRepository.findByName(brandName);

        if(brandExist != null)
            throw new Exception("The brand all ready exist");

        var brand = new Brands(brandName);
        var brandSave = _brandRepository.saveAndFlush(brand);

        return brandSave != null ? true : false;
    }

}
