package ru.shop.doors.service;

import org.springframework.stereotype.Service;
import ru.shop.doors.model.Material;
import ru.shop.doors.repository.MaterialRepository;

@Service
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

    public Material getMaterialById(Long id) {
        Material material = materialRepository.getById(id);
        return material;
    }

    public Material getMaterialByName(String name){
        Material material = materialRepository.getMaterialByName(name);
        return material;
    }

    public void deleteMaterial(Long id) {
        Material material = materialRepository.getById(id);
        material.setDeleted(true);
        materialRepository.save(material);
    }
}
