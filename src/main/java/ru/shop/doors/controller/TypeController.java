package ru.shop.doors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shop.doors.model.Type;
import ru.shop.doors.service.TypeService;

@RestController
public class TypeController {

    private TypeService typeService;

    @Autowired
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping(value = "/type/create")
    public void createType(@RequestBody Type typeFromFronted){
        typeService.createType(typeFromFronted);
    }

    @GetMapping(value = "/createType/get")
    public Type getTypeById(@RequestParam Long id){
        return typeService.getTypeById(id);
    }

    @DeleteMapping(value = "/type/delete/{id}")
    public void delete(@PathVariable Long id){
        typeService.deleteType(id);
    }
}
