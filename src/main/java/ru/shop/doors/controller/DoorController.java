package ru.shop.doors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shop.doors.model.Door;
import ru.shop.doors.service.DoorService;

@RestController
public class DoorController {


    private DoorService doorService;


    @Autowired
    public void setDoorService(DoorService doorService){
        this.doorService = doorService;
    }

    @PostMapping(value = "/door/create")
    public void createDoor(@RequestBody Door doorFromFronted){
        doorService.createDoor(doorFromFronted);
    }

    @GetMapping(value = "/door/get")
    public Door getDoorById(@RequestParam Long id){
        return doorService.getDoorById(id);
    }

    @DeleteMapping(value = "/door/delete/{id}")
    public void delete(@PathVariable Long id){
        doorService.deleteDoor(id);
    }
}
