package ru.shop.doors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shop.doors.model.Door;
import ru.shop.doors.service.DoorService;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(value = "/createDoor/get")
    public Door getDoorById(@RequestParam Long id){
        return doorService.getDoorById(id);
    }

    @DeleteMapping(value = "/door/delete/{id}")
    public void delete(@PathVariable Long id){
        doorService.deleteDoor(id);
    }

    @GetMapping(value = "/door/all")
    public List<Door> findAll(){
        return doorService.findAll();
    }

    @GetMapping(value = "/door/correlation")
    public double getCorrelation(@RequestParam String param) {
        return doorService.spearmanCorrelation(param);
    }

    @GetMapping(value = "/door/distanceBetweenValues")
    public double[][] distanceBetweenValues(@RequestParam String param) {
        return doorService.distanceBetweenValues(param);
    }

    @GetMapping(value = "/door/getSimilar")
    public ArrayList<Door> similarDoors(@RequestParam int id, @RequestParam int value){
        return (ArrayList<Door>) doorService.getSimilar(id, value);
    }

    @GetMapping(value = "/door/distanceBetweenDoors")
    public double[] distanceBetweenDoors(@RequestParam long id) {
        return doorService.distanceBetweenDoors(id);
    }
}
