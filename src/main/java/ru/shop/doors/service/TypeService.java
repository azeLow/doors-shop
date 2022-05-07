package ru.shop.doors.service;

import ru.shop.doors.model.Type;
import ru.shop.doors.repository.TypeRepository;

public class TypeService {

    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public void createType(Type typeFromFronted){
        Type type = new Type();
        type.setName(typeFromFronted.getName());
        type.setDeleted(false);
        typeRepository.save(type);
    }
}
