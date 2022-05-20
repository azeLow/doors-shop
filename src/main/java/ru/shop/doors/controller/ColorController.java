package ru.shop.doors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shop.doors.model.Color;
import ru.shop.doors.service.ColorService;

@RestController
public class ColorController {

    private ColorService colorService;

    @Autowired
    public void setColorService(ColorService colorService){
        this.colorService = colorService;
    }

    @PostMapping(value = "/color/create")
    public void createColor(@RequestBody Color colorFromFronted) {

        colorService.createColor(colorFromFronted);
    }

    @GetMapping(value = "/createColor/get")
    public Color getColorById(@RequestParam Long id){
        return colorService.getColorById(id);
    }

   @DeleteMapping(value = "/color/delete/{id}")
    public void delete(@PathVariable Long id) {
       colorService.deleteColor(id);
   }
}
