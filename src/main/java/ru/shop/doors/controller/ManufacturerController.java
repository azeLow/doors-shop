package ru.shop.doors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shop.doors.model.Manufacturer;
import ru.shop.doors.service.ManufacturerService;

@RestController
public class ManufacturerController {

    private ManufacturerService manufacturerService;

    @Autowired
    public void setManufacturerService(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping(value = "/manufacturer/create")
    public void createManufacturer(@RequestBody Manufacturer manufacturerFromFronted){
        manufacturerService.createManufacturer(manufacturerFromFronted);
    }

    @GetMapping(value = "/manufacturer/get")
    public Manufacturer getManufacturerById(@RequestParam Long id){
        return manufacturerService.getManufacturerById(id);
    }

    @DeleteMapping(value = "/manufacturer/delete/{id}")
    public void delete(@PathVariable Long id){
        manufacturerService.deleteManufacturer(id);
    }
}
