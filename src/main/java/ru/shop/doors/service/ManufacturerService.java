package ru.shop.doors.service;

import ru.shop.doors.model.Manufacturer;
import ru.shop.doors.repository.ManufacturerRepository;

public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public void createManufacturer(Manufacturer manufacturerFromFronted) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(manufacturerFromFronted.getName());
        manufacturer.setAddress(manufacturerFromFronted.getAddress());
        manufacturer.setCountry(manufacturerFromFronted.getCountry());
        manufacturer.setFax(manufacturerFromFronted.getFax());
        manufacturer.setTelephone(manufacturer.getTelephone());
        manufacturer.setWebsite(manufacturer.getWebsite());
        manufacturer.setDeleted(false);
        manufacturerRepository.save(manufacturer);
    }
}
