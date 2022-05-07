package ru.shop.doors.service;

import ru.shop.doors.model.Material;
import ru.shop.doors.repository.MaterialRepository;

public class MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public void createMaterial(Material materialFromFronted){
        Material material = new Material();
        material.setName(materialFromFronted.getName());
        material.setDeleted(false);
        materialRepository.save(material);
    }
}
