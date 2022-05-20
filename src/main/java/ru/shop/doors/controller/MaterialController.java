package ru.shop.doors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shop.doors.model.Material;
import ru.shop.doors.service.MaterialService;

@RestController
public class MaterialController {

    private MaterialService materialService;

    @Autowired
    public void setMaterialService(MaterialService materialService){
        this.materialService = materialService;
    }

    @PostMapping(value = "/material/create")
    public void createMaterial(@RequestBody Material materialFromFronted){
        materialService.createMaterial(materialFromFronted);
    }

    @GetMapping(value = "/material/get")
    public Material getMaterialId(@RequestParam Long id){
        return materialService.getMaterialById(id);
    }

    @DeleteMapping(value = "/material/delete/{id}")
    public void delete(@PathVariable Long id){
        materialService.deleteMaterial(id);
    }
}
