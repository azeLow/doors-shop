package ru.shop.doors.service;

import org.springframework.stereotype.Service;
import ru.shop.doors.model.Manufacturer;
import ru.shop.doors.repository.ManufacturerRepository;

@Service
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

    public Manufacturer getManufacturerById(Long id) {
        Manufacturer manufacturer = manufacturerRepository.getById(id);
        return  manufacturer;
    }

    public void deleteManufacturer(Long id){
        Manufacturer manufacturer = manufacturerRepository.getById(id);
        manufacturer.setDeleted(true);
        manufacturerRepository.save(manufacturer);
    }
}
