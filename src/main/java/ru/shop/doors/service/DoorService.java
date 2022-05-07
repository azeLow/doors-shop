package ru.shop.doors.service;

import ru.shop.doors.model.Door;
import ru.shop.doors.repository.DoorRepository;

public class DoorService {

    private final DoorRepository doorRepository;

    public DoorService(DoorRepository doorRepository) {
        this.doorRepository = doorRepository;
    }

    public void createDoor(Door doorFromFronted){
        Door door = new Door();
        door.setName(doorFromFronted.getName());
        door.setColor(doorFromFronted.getColor());
        door.setGlazing(doorFromFronted.getGlazing());
        door.setManufacturer(doorFromFronted.getManufacturer());
        door.setMaterial(doorFromFronted.getMaterial());
        door.setType(doorFromFronted.getType());
        door.setPrice(doorFromFronted.getPrice());
        door.setDeleted(false);
        doorRepository.save(door);
    }
}
